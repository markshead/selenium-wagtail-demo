package net.xeric.demos.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.stereotype.Component;

@Component
public class WagTailAdminLoginPage extends AbstractWagTailPage{
    String PATH = "/admin";

    @FindBy(name="username")
    private WebElement username;

    @FindBy(name="password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"wagtail\"]/div/main/form/ul/li[3]/button")
    private WebElement submitLogin;

    public WagTailAdminLoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) throws InterruptedException {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitLogin.click();
        Thread.sleep(10000);

    }

    public void go() {
        System.out.println("Go to: " + BASE_URL + PATH);
        driver.get(BASE_URL + PATH);
    }

    public void getSource() {
        System.out.println(driver.getPageSource());
    }
}
