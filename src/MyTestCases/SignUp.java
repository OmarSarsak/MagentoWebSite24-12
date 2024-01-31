package MyTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUp extends Info {

	WebDriver driver = new ChromeDriver();

	@BeforeTest()
	public void MySetUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(priority = 1)
	public void MyFirstTest() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Create an Account")).click();

		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));
		;
		WebElement Email = driver.findElement(By.id("email_address"));
		;
		WebElement Password = driver.findElement(By.id("password"));
		;
		WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
		;
		WebElement CreateAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));
		FirstName.sendKeys(FirstNames[randomIndex]);
		LastName.sendKeys(LastNames[randomIndex]);
		Email.sendKeys(EmailID);
		Password.sendKeys(CommonPassword);
		ConfirmPassword.sendKeys(CommonPassword);
		CreateAccountButton.click();
		String welcomeMsg = driver.findElement(By.className("message-success")).getText();

		assertEquals(welcomeMsg, "Thank you for registering with Main Website Store.");
	}

	@Test(priority = 2)
	public void LogoutProccess() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
		assertEquals(driver.getCurrentUrl().contains("logoutSuccess"), true);
	}

	@Test(priority = 3)
	public void LoginProccess() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(EmailID);
		driver.findElement(By.id("pass")).sendKeys(CommonPassword);
		driver.findElement(By.id("send2")).click();
		Thread.sleep(2000);
		String welcomMsg = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(welcomMsg.contains("Welcome"), true);
	}

	@Test(priority = 4)
	public void addOneRandomItem() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		WebElement ItemsContainer = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
		int numerOfItems = ItemsContainer.findElements(By.tagName("li")).size();
		System.out.println(numerOfItems);
		
		int randomItemToSelect = rand.nextInt(4);
		ItemsContainer.findElements(By.tagName("li")).get(randomItemToSelect).click();
		WebElement sizesContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		int theSizes = sizesContainer.findElements(By.className("swatch-option")).size();
		sizesContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theSizes)).click();
		Thread.sleep(2000);
		
		WebElement colorsContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int theColors = colorsContainer.findElements(By.className("swatch-option")).size();
		colorsContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theColors)).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);
		
		String ActualMsg = driver.findElement(By.cssSelector(".page.messages")).getText();
		assertEquals(ActualMsg.contains("You added"), true);


		
	}
}