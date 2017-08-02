package br.leosilvadev

import spock.lang.Specification
import spock.util.concurrent.BlockingVariable

import java.util.concurrent.TimeUnit
import java.util.function.Consumer

class MySpec extends Specification {

    def 'Should sum the value of three given numbers'() {
        given: 'three different values'
        def n1 = 10
        def n2 = 20
        def n3 = 30

        when: 'a counter sum these values'
        def total = new Counter().sum(n1, n2, n3)

        then: 'the result should be correct'
        total == 60
    }


    def 'Should sum many times'() {
        when: 'a counter sum all the three given values'
        def total = new Counter().sum(n1, n2, n3)

        then: 'the result should be correct'
        total == result

        where:
        n1 | n2 | n3 | result
        10 | 20 | 30 | 60
        12 | 22 | 32 | 66
         5 | 15 | 25 | 45
    }

    def 'Should sum three numbers with my current money'() {
        given:
        def n1 = 10
        def n2 = 20
        def n3 = 30

        and:
        def serviceMock = Mock(Service)

        when:
        1 * serviceMock.currentMoney() >> 100

        and:
        def total = new Counter(serviceMock).sumWithMyCurrentMoney(n1, n2, n3)

        then:
        total == 160
    }


    def 'Should sum three numbers with my current money using async method'() {
        given:
        def n1 = 10
        def n2 = 20
        def n3 = 30

        and:
        def var = new BlockingVariable(2, TimeUnit.SECONDS)

        and:
        def callback = var.&set

        when:
        new Counter().sumWithMyCurrentMoneyAsync(callback, n1, n2, n3)

        then:
        var.get() == 160
    }

}


class Counter {
    def service

    Counter(Service service = new Service()) {
        this.service = service
    }

    Double sum(Double... values) {
        values.inject(0) { total, value -> total + value }
    }

    Double sumWithMyCurrentMoney(Double... values) {
        sum(*(values + service.currentMoney()))
    }

    void sumWithMyCurrentMoneyAsync(Consumer<Double> callback, Double... values) {
        service.currentMoneyAsync { current ->
            callback.accept(sum(*(values + current)))
        }
    }
}

class Service {
    Double currentMoney() {
        sleep(1000)
        100
    }

    void currentMoneyAsync(Consumer<Double> callback) {
        new Thread({
            callback.accept(currentMoney())
        }).start()
    }
}