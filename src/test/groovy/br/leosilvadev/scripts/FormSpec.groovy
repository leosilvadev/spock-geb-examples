package br.leosilvadev.scripts

import geb.Browser
import geb.spock.GebReportingSpec
import spock.lang.Shared

class FormSpec extends GebReportingSpec {
	
	@Shared def file
	
	def setupSpec() {
		file = new File('temp.json')
	}

	def "Should fill and send the form"(){
		given:
		def url = 'http://www.abodeqa.com/wp-content/uploads/2016/05/DemoSite.html'
		
		when:
		browser.go url
		
		then:
		def form = $("form")
		report 'Clean form'
		
		when:
		form.firstname = 'Leonardo'
		report 'First name entered'
		
		and:
		form.lastname = 'Silva'
		report 'Last name entered'
		
		and:
		form.sex = 'Male'
		report 'Sex entered'
		
		and:
		form.exp = 7
		report 'Experience entered'
		
		and:
		$('#datepicker') << new Date().format('dd.MM.yyyy')
		report 'Date entered'
		
		and:
		$('#profession-0').click()
		$('#profession-1').click()
		report 'Professions selected'
		
		and:
		form.photo = file.absolutePath
		report 'Photo selected'
		
		and:
		$('#tool-1').click()
		$('#tool-2').click()
		report 'Tools selected'
		
		and:
		form.continents = 'South America'
		report 'Continent selected'
		
		and:
		form.selenium_commands = ['Browser Commands', 'Switch Commands']
		report 'Commands selected'
		
		and:
		$('#submit').click()
		
		then:
		true
	}
}