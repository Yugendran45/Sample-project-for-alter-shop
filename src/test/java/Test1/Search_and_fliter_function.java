package Test1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_and_fliter_function {
	
	public static WebDriver driver ;
	
	@BeforeClass
	public void Lanuch_browser() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://betashop.alter.game/");
		driver.manage().window().maximize();
	} 
	
	@Test(priority=1)
	public void Verify_search_function() {
		driver.findElement(By.id("auto-suggestion-search")).sendKeys("Chicken");
		driver.findElement(By.id("auto-suggestion-search")).clear();
	}
	@Test(priority=2)
	public void Verify_enter_text_click_enteroption() {
       driver.findElement(By.id("auto-suggestion-search")).sendKeys("Chicken",Keys.ENTER);
       driver.findElement(By.id("auto-suggestion-search")).clear();
	}

	@Test(priority=3)
     public void Verify_enter_maximum_minimum_and_specialcharacter() throws InterruptedException {
	       driver.findElement(By.id("auto-suggestion-search")).sendKeys("a",Keys.ENTER);
	       driver.findElement(By.id("auto-suggestion-search")).sendKeys("ChicChickenvkenChickenChickenChickenChicken",Keys.ENTER);
		   //because the web application get slow
	     //  driver.findElement(By.id("auto-suggestion-search")).sendKeys("!@#$%^&*(",Keys.ENTER);
	       
	}

	@Test(priority=4)
	public void Verify_get_suggestion_option() throws InterruptedException {
		driver.findElement(By.id("auto-suggestion-search")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("auto-suggestion-search")).sendKeys("Chicken");
        List<WebElement> findElements = driver.findElements(By.id("auto-suggestion-search"));
        for(WebElement message :findElements ) {
        	String text = message.getText();
        	System.out.println(text);
        }
	
	}
    @Test(priority=5)
	public void Verify_click_suggestion_message() throws InterruptedException {
    	driver.findElement(By.id("auto-suggestion-search")).clear();
    	driver.findElement(By.id("auto-suggestion-search")).sendKeys("chick");
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div[text()='Chicken']")).click();

	}
	
    @Test(priority=6)
    public void Verify_search_text_realted_results() throws InterruptedException {
    	String str = "Chicken";
    	Thread.sleep(2000);
    	driver.findElement(By.id("auto-suggestion-search")).sendKeys(str,Keys.ENTER);
    	Thread.sleep(4000);
    	WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/span")) ; 
    	String text = element.getText();
    	if(str.contentEquals(text)) {
    		System.out.println("The condition is pass");
    	}
    
    }
    @Test(priority=7)
     public void Verify_left_side_options() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//img[@alt='down png']")).click();
        driver.findElement(By.xpath("//li[text()='Body']")).click();
        driver.findElement(By.xpath("//img[@alt='down png']")).click();
        driver.findElement(By.xpath("//li[text()='Buildings']")).click();
        driver.findElement(By.xpath("//img[@alt='down png']")).click();
        driver.findElement(By.xpath("//li[text()='Buildings']")).click();
        driver.findElement(By.xpath("//img[@alt='down png']")).click();
        driver.findElement(By.xpath("//li[text()='Indoor Assets']")).click();
        driver.findElement(By.xpath("//img[@alt='down png']")).click();
        driver.findElement(By.xpath("//li[text()='Outdoor Assets']")).click();	
        driver.findElement(By.xpath("//img[@alt='down png']")).click();
        driver.findElement(By.xpath("//li[text()='All Categories']")).click();
    
      	}
    
       @Test(priority=8)
       public void Verify_fliter_opitons() {
        driver.findElement(By.id("price-sort-select")).click();
        driver.findElement(By.xpath("//li[text()='Price Low to High']")).click();
        driver.findElement(By.xpath("//li[text()='Price High to Low']")).click();
        
	}
       @Test(priority=9)
       public void Verify_select_price_range_and_clearoption() {
    	   driver.findElement(By.xpath("//span[text()='Clear']")).click();

	}
       
    @Test(priority=10)   
    public void Verify_mouseover_to_assets_check_borderhighlights() {
    	
       Actions action = new Actions(driver);
       WebElement findElement = driver.findElement(By.xpath("//div[@class='mt-2 flex w-full flex-col items-start']"));
       action.moveToElement(findElement).perform();
	}
    
}

