package net.xeric.demos.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class WagTailAdminPage extends AbstractWagTailPage{
    String PATH = "/admin";

    @FindBy(linkText="Pages")
    private WebElement pagesLink;

    @FindBy(xpath = "//*[@id=\"wagtail\"]/div/aside/div[2]/div/nav/div/div/div/div[1]/a[1]/h3")
    private WebElement editHomePageLink;

    @FindBy(xpath="//*[@id=\"page-reorder-form\"]/table/thead/tr[1]/td[1]/ul/li[3]/a")
    private WebElement addChildPageLink;

    @FindBy(name="title")
    private WebElement title;

    @FindBy(name="action-publish")
    private WebElement publishButton;

    @FindBy(className = "icon-arrow-up")
    private WebElement upArrowMoreActions;



    public WagTailAdminPage(WebDriver driver) {
        super(driver);
    }



    public void go() {
        System.out.println("Go to: " + BASE_URL + PATH);
        driver.get(BASE_URL + PATH);
    }

    public void addSubPage(String pageName) {
        pagesLink.click();
        waitForElement(editHomePageLink);
        editHomePageLink.click();
        waitForElement(addChildPageLink);
        addChildPageLink.click();
        waitForElement(title);
        title.sendKeys(pageName);
        upArrowMoreActions.click();
        publishButton.click();
    }

    public String retrievePublicPageTitle(String pagePath) {
        driver.get(BASE_URL + "/" + pagePath);
        return driver.getTitle();
    }
}
