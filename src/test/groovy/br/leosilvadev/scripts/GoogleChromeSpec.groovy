package br.leosilvadev.scripts

import geb.Browser
import geb.spock.GebSpec

import org.openqa.selenium.firefox.FirefoxDriver

class GoogleChromeSpec extends GebSpec {

	def setupSpec() {
		System.properties.put('geb.env', 'test')
		System.properties.put('geb.driver', 'chrome')
	}
	
	def "Should find for Groovy in Google"(){
		given:
		def url = 'http://google.de'
		
		when:
		browser.go url
		
		and:
		$('input[type=text]').value 'Groovy'
		
		and:
		$('button[type=submit]').click()
		
		and:
		waitFor {
			$('#center_col').displayed
		}
		
		then:
		$('h3>a').first().text().contains 'Groovy'
	}
}