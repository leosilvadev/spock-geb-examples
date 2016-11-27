package br.leosilvadev.scripts

import geb.Browser
import geb.spock.GebSpec

import org.openqa.selenium.firefox.FirefoxDriver

class GoogleSpec extends GebSpec {

	def "Should find for Groovy"(){
		given:
		def url = 'http://google.de'
		
		when:
		browser.go url
		
		and:
		$('input[type=text]') << 'Groovy'
		
		and:
		$('button[type=submit]').click()
		
		and:
		waitFor {
			$('#center_col').displayed
		}
		
		then:
		$('h3 > a').first().text().contains 'Groovy'
	}
}