import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


/**
 * Created on 2/9/2016.
 * Add new News to News portal.
 *
 * @author Bocharnikov Alexander
 */
public class AddNewsSeleniumTest {

    private static final Logger log = Logger.getLogger(AddNewsSeleniumTest.class);
    public static final String TEST_URL = "http://localhost:8000";
    public static final String ADD_NEWS_LINK = "Add News";
    public static final String NEWS_FORM = "newsForm";
    public static final String TITLE = "title";
    public static final String BRIEF = "brief";
    public static final String CONTENT = "content";
    public static final String DAY = "day";
    public static final String MONTH = "month";
    public static final String YEAR = "year";

    @Test
    public void testAddNews() throws Exception {
        boolean result = false;
        try {
            result = addNews();
        } catch (Exception ignored) {
            log.error("Test failed");
        }
        assertTrue(result);

    }

    private static boolean addNews() {
        WebDriver firefox =  new FirefoxDriver();
        firefox.get(TEST_URL);
        WebElement link = firefox.findElement(By.linkText(ADD_NEWS_LINK));
        link.click();
        WebElement newsForm = firefox.findElement(By.name(NEWS_FORM));
        WebElement title = firefox.findElement(By.name(TITLE));
        title.sendKeys("Vasya!");
        WebElement brief = firefox.findElement(By.name(BRIEF));
        brief.sendKeys("SUPER BRIEF");
        WebElement content = firefox.findElement(By.name(CONTENT));
        content.sendKeys("SUPER CONTENT");
        WebElement day = firefox.findElement(By.name(DAY));
        WebElement month = firefox.findElement(By.name(MONTH));
        WebElement year = firefox.findElement(By.name(YEAR));
        day.sendKeys("09");
        month.sendKeys("02");
        year.sendKeys("2016");
        newsForm.submit();
        firefox.close();
        return true;
    }
}
