import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver

waiting {
	timeout = 5
	retryInterval = 1
	includeCauseMessage = true
}

environments {
	firefox {
		driver = { new FirefoxDriver() }
	}
	phantomJs {
		driver = { new PhantomJSDriver() }
	}
}

reportsDir = 'target/geb-reports'
baseUrl = "http://localhost:8080"