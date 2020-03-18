package net.xeric.demos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * This represents a page in the application. Ideally we want to isolate all the details
 * about the page to this class. That way if we change an id or class name, there is just
 * a single place where we have to update it and our step files can remain unchanged.
 */

@Component
public class WagTailPage extends AbstractWagTailPage{





    @Autowired
    public WagTailPage(final WebDriver driver) {
        super(driver);
    }

    public void go() {
        System.out.println("Go to: " + BASE_URL + PATH);
        driver.get(BASE_URL + PATH);
    }

    public void getSource() {
        System.out.println(driver.getPageSource());
    }
}
