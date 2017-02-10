package br.leosilvadev.scripts

import br.leosilvadev.pages.FormPage
import geb.spock.GebReportingSpec
import spock.lang.Shared

class FormPageSpec extends GebReportingSpec {
	
	@Shared def file
	
	def setupSpec() {
		file = new File('temp.json')
	}

	def "Should fill and send the form"(){
		given:
		def nowDate = new Date().format('dd.MM.yyyy')
		
		when:
		to FormPage
		
		and:
		"enter first name "('Leonardo')
		"enter last name "('Silva')
		"select sex "('Male')
		"select experience "(7)
		"enter date "(nowDate)
		
		then:
		true
	}
}