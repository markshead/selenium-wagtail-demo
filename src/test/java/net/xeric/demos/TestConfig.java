package net.xeric.demos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * This is the Spring configuration file that allows us to get the webdriver.
 */
@Configuration
public class TestConfig {

    private static final String MAC_CHROME_DRIVER = "./src/test/resources/bin/chromedriver";
    private static final String WINDOWS_CHROME_DRIVER = "./src/test/resources/bin/chromedriver.exe";

    @Bean(destroyMethod = "quit")
    @Lazy
    @Scope("singleton")
    public WebDriver getWebDriver() {
        String driverPath = isWindows()? WINDOWS_CHROME_DRIVER : MAC_CHROME_DRIVER;
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();
    }

    private boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }

}
