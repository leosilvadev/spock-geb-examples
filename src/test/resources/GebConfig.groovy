import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
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

	firefox {
		driver = { new FirefoxDriver() }
	}

	chrome {
		driver = { new ChromeDriver() }
	}
}

baseUrl = "http://localhost:8080"