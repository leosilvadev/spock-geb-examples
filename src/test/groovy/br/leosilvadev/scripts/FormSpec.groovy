package br.leosilvadev.scripts

import geb.spock.GebReportingSpec
import spock.lang.Shared

class FormSpec extends GebReportingSpec {
	
	@Shared def file
	
	def setupSpec() {
		file = new File('temp.json')
	}

	def "Should fill and send the form"(){
		given:
		def p = System.getProperty('geb.domain')
		def nowDate = new Date().format('dd.MM.yyyy')
		def url = 'http://www.abodeqa.com/wp-content/uploads/2016/05/DemoSite.html?a='+p
		
		when:
		browser.go url
		
		then:
		def form = $("form")
		report 'Clean form'
		
		when:
		form.firstname = 'Leonardo'
		report 'First name entered'
		
		then:
		form.firstname == 'Leonardo'
		
		when:
		form.lastname = 'Silva'
		report 'Last name entered'
		
		then:
		form.lastname == 'Silva'
		
		when:
		form.sex = 'Male'
		report 'Sex entered'
		
		then:
		form.sex == 'Male'
		
		when:
		form.exp = 7
		report 'Experience entered'
		
		then:
		form.exp == '7'
		
		when:
		$('#datepicker') << nowDate
		report 'Date entered'
		
		then:
		$('#datepicker').value() == nowDate
		
		when:
		$('#profession-0').click()
		$('#profession-1').click()
		report 'Professions selected'
		
		then:
		form.profession == ['Manual Tester', 'Automation Tester']
		
		when:
		form.photo = file.absolutePath
		report 'Photo selected'
		
		then:
		form.photo == 'temp.json'
		
		when:
		$('#tool-1').click()
		$('#tool-2').click()
		report 'Tools selected'
		
		then:
		form.tool == [false, 'Selenium IDE', 'Selenium Webdriver']
		
		when:
		form.continents = 'South America'
		report 'Continent selected'
		
		then:
		form.continents =='South America'
		
		when:
		form.selenium_commands = ['Browser Commands', 'Switch Commands']
		report 'Commands selected'
		
		then:
		form.selenium_commands == ['Browser Commands', 'Switch Commands']
		
		when:
		$('#submit').click()
		
		then:
		$('input[name=firstname]').value() == ''
	}
}