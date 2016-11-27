import org.openqa.selenium.phantomjs.PhantomJSDriver

waiting {
	timeout = 5
	retryInterval = 1
	includeCauseMessage = true
}

environments {
	phantomJs {
		driver = { new PhantomJSDriver() }
	}
}

baseUrl = "http://localhost:8080"