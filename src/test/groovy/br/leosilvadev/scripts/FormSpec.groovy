package br.leosilvadev.scripts

import geb.Browser
import geb.spock.GebSpec
import spock.lang.Shared;

class FormSpec extends GebSpec {
	
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
		
		when:
		form.firstname = 'Leonardo'
		
		and:
		form.lastname = 'Silva'
		
		and:
		form.sex = 'Male'
		
		and:
		form.exp = 7
		
		and:
		$('#datepicker') << new Date().format('dd.MM.yyyy')
		
		and:
		$('#profession-0').click()
		$('#profession-1').click()
		
		and:
		form.photo = file.absolutePath
		
		and:
		$('#tool-1').click()
		$('#tool-2').click()
		
		and:
		form.continents = 'South America'
		
		and:
		form.selenium_commands = ['Browser Commands', 'Switch Commands']
		
		and:
		$('#submit').click()
		
		then:
		true
	}
}