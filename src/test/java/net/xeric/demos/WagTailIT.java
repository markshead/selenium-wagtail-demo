package net.xeric.demos;

import net.xeric.demos.pages.WagTailAdminLoginPage;
import net.xeric.demos.pages.WagTailAdminPage;
import net.xeric.demos.pages.WagTailPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WagTailIT {
    @Autowired
    WagTailPage wagTailPage;
    @Autowired
    WagTailAdminLoginPage wagTailAdminLoginPage;
    @Autowired
    WagTailAdminPage wagTailAdminPage;
    @Test
    public void addPageTest() throws Exception {
        Random r = new Random();
        int randomNumber = r.nextInt(9999999);
        wagTailAdminLoginPage.go();
        wagTailAdminLoginPage.login("admin", "SuperSecret!!");
        wagTailAdminPage.addSubPage("My Sub Page-" + randomNumber);
        String retrievedTitle = wagTailAdminPage.retrievePublicPageTitle("my-sub-page-" + randomNumber);
        assertEquals(retrievedTitle, "My Sub Page-" + randomNumber);

    }

}
