//facebook login validation
package example.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends BasePage {

	@FindBy(id = "email")
	private WebElement emailInput;
	@FindBy(id = "pass")
	private WebElement pass;

	public FacebookLoginPage(WebDriver driver) {
		super(driver);
	}

	public FacebookLoginPage enterEmail(String email) {
		emailInput.sendKeys(email);
		return this;
	}

	public FacebookLoginPage enterPassword(String password) {
		pass.sendKeys(password);
		return this;
	}

	public void clickSignIn() {
		pass.submit();
	}
}

@Test(testName = "Facebook login test", description = "Facebook login test")
public class FaceBookLoginTest extends BaseTest {

	@Test
	public void facebookLoginTest() {
		driver.get("https://www.facebook.com/");
		FacebookLoginPage facebookLoginPage = PageinstancesFactory.getInstance(FacebookLoginPage.class);
		facebookLoginPage.enterEmail("abc").enterPassword("abc").clickSignIn();
		Assert.assertTrue(false, "Login failed : Test failed");
