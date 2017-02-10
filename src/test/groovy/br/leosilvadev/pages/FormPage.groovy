package br.leosilvadev.pages

import geb.Page

class FormPage extends Page {

	static url

	static {
		def p = System.getProperty('geb.domain')
		url = 'http://www.abodeqa.com/wp-content/uploads/2016/05/DemoSite.html?p='+p
	}
	
	static at = {
		$('#header-links-inner').displayed
	}
	
	static content = {
		form(wait: true) { $('form') }
		
		date() { $('#datepicker') }
		
		profession() { form.profession }
		
		photo() { form.photo }
		
		tool() { form.tool }
		
		continents() { form.continents }
		
		commands() { form.selenium_commands }
		
		btnSubmit() { $('#submit') }
	}
	
	def "enter first name "(name) {
		form.firstname = name
	}
	
	def "enter last name "(name) {
		form.lastname = name
	}
	
	def "select sex "(sex) {
		form.sex = sex
	}
	
	def "select experience "(exp) {
		form.exp = exp
	}
	
	def "enter date "(value) {
		date << value
	}
	
}
