package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class View_assets_details_page extends Search_and_fliter_function {
	
		
	
	
	@Test(priority=11)
    public void Verify_click_assets_on_homepage() {
	  driver.findElement(By.xpath("//span[text()='Discover']")).click();	
      driver.findElement(By.xpath("//span[text()='Watch for TEST']")).click();
	}
	
	@Test(priority=12)
    public void Verify_get_assets_title_and_get_allcategories() {
      String Assetstitle = driver.findElement(By.xpath("//span[text()='Watch for TEST']")).getText();
      System.out.println(Assetstitle);
      String Assetscategories = driver.findElement(By.xpath("//span[text()='Body']")).getText();
      System.out.println(Assetscategories);
      
	}
	@Test(priority=13)
	public void Verify_get_creator_name_and_creator_mentor() throws InterruptedException {
		Thread.sleep(2000);
		String creator = driver.findElement(By.xpath("//span[text()='Mallikarjun M G']")).getText();
		System.out.println(creator);
		String creatoron = driver.findElement(By.xpath("//span[text()='Jun 21st 23']")).getText();
		System.out.println(creatoron);

	}
	@Test(priority=13)
	public void Verify_get_price() {
       String Pricetext = driver.findElement(By.xpath("//span[text()='0.1']")).getText();
	   System.out.println(Pricetext);
	}
	
	@Test(priority=14)
	public void Verify_click_react_option() {
		driver.findElement(By.xpath("//span[text()='React']")).click();
//		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/div[2]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/span[2]/div/svg")).click();

	}
    
	@Test(priority=15)
	public void Verify_click_sharenow_option() {
		driver.findElement(By.xpath("//span[text()='Share']")).click();
	//	driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div/div[2]/div[2]/svg/path")).click();
		
	}
	
	@Test(priority=16)
	public void Verify_click_popup_canceloption_click_each_and_every_option() throws InterruptedException {
		//driver.findElement(By.xpath("/html/body/div/div/div[1]/div[5]/div[2]/div/div/div[2]/div[1]/div[1]/button/svg")).click();
        //driver.close();
		Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='close']")).click();
	}
	
	@Test(priority=17)
	public void Verify_suggestion_assets_click_all() {
		JavascriptExecutor js = (JavascriptExecutor)(driver);
      js.executeScript("window.scrollBy(0, 500)");
      driver.findElement(By.xpath("//span[text()='One Plus ']")).click();
	}
	
	@Test(priority=18)
	public void Verify_click_Buynow_option() {
		JavascriptExecutor js2 = (JavascriptExecutor)(driver);
		 js2.executeScript("window.scrollBy(0, 1000)");
		
        try {
            WebElement element = driver.findElement(By.xpath("//div[@class='flex items-center justify-center gap-2']"));
            element.click(); 
            } catch (StaleElementReferenceException e) {
            // Increment attempt counter and retry
        }
          
        driver.findElement(By.xpath("//span[text()='Discover']")).click();
       	}
	
}
