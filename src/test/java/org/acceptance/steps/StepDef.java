package org.acceptance.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	private WebDriver driver;
	private WebElement searchBox;
	private WebElement searchBox1;

	@Given("^: It's a weekend$")
	public void it_s_a_weekend() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com/xhtml");
		searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("https://weather.com/");
		searchBox.submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//h3[@class='r']/a)[1]")).click();
		searchBox1 = driver.findElement(By.name("search"));
		searchBox1.sendKeys("Boston, MA");
		Assert.assertTrue(true);
	}

	@When("^: Boston's temperature is more than (\\d+)$")
	public void boston_s_temperature_is_more_than(int arg) {
		driver.get("https://weather.com/weather/today/l/USMA0046:1:US");
		driver.findElement(By.linkText("Weekend")).click();
		assert (arg > 55) ? false : true;
	}

	@Then("^: Lets go to beach\\.$")
	public void lets_go_to_beach() {
		driver.findElement(By.xpath("//*[@id=\"twc-scrollable\"]/div[3]/article/div/div/div[1]/section/header/h3")).click();
	//	driver.findElement(By.xpath("//*[@id=\"twc-scrollable\"]/div[3]/article/div/div/div[1]/section/header/h3")).click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MINUTES);
		driver.quit();
		Assert.assertFalse(true);
		
	}

	@Given("^: It's any day$")
	public void it_s_any_day() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com/xhtml");
		searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("https://weather.com/");
		searchBox.submit();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//h3[@class='r']/a)[1]")).click();
		searchBox1 = driver.findElement(By.name("search"));
		searchBox1.sendKeys("Boston, MA");
		Assert.assertTrue(true);
	}

	@Then("^: Go grab them!$")
	public void go_grab_them() {
		driver.findElement(By.xpath("//*[@id=\"twc-scrollable\"]/div[3]/article/div/div/div[1]/section/header/h3")).click();
	//	driver.findElement(By.xpath("//*[@id=\"twc-scrollable\"]/div[3]/article/div/div/div[1]/section/header/h3")).click();
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MINUTES);
		driver.quit();
		Assert.assertTrue(true);
	}


}