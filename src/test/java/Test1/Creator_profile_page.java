package Test1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Creator_profile_page extends View_assets_details_page {
	
	@Test(priority=19)
	public void Click_connect_option() {
         driver.findElement(By.xpath("//span[text()='Connect']")).click();
         
	}

	@Test(priority = 20)
	public void Verify_click_drive_the_google_option() throws InterruptedException {
		Set<String> allWindowHandles = driver.getWindowHandles();
		//String mainWindowHandle = driver.getWindowHandle();
		String currentUrl = driver.getCurrentUrl();
		for (String handle : allWindowHandles) {
			if (!handle.equals(currentUrl)) {
				driver.switchTo().window(handle);
				System.out.println(handle);
			}
		}
        Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Discord']")).click();

	}
	
	@Test(priority=21)
	public void Verify_discord_page_enterinvalidusername_and_invalidpassword_then_geterror() {
    
		driver.findElement(By.name("email")).sendKeys("yugendrankumar01@gmail.com");
		driver.findElement(By.name("password")).sendKeys("yugendran@123");
		driver.findElement(By.xpath("//div[text()='Log In']")).click();
	
	}
	@Test(priority=22)
	public void Verify_click_forget_password() {
       driver.findElement(By.xpath("//div[text()='Forgot your password?']")).click();
       driver.navigate().refresh();
//       
       }
	
	
	@Test(priority=23)
	public void Verify_click_regsiter_option_and_fill_all_details() {
      driver.findElement(By.xpath("//div[text()='Register']")).click();
      driver.findElement(By.name("email")).sendKeys("yawine7228@mfunza.com");
      driver.findElement(By.name("global_name")).sendKeys("yugendran");
      driver.findElement(By.name("username")).sendKeys("yugendran_12");
      driver.findElement(By.name("password")).sendKeys("Yugendran@23");
		/*
		 * WebElement day = driver.findElement(By.xpath("//span[text()='Day']")); Select
		 * date = new Select(day); date.selectByValue("4"); WebElement month =
		 * driver.findElement(By.xpath("//span[text()='Month']")); Select s = new
		 * Select(month); s.selectByValue("May"); WebElement year
		 * =driver.findElement(By.xpath("//span[text()='Year']")); Select year1 = new
		 * Select(month); year1.selectByValue("2001");
		 */   
      driver.findElement(By.xpath("//span[text()='Day']")).click();
      driver.findElement(By.xpath("//span[text()='Month']")).click();
      driver.findElement(By.xpath("//span[text()='Year']")).click();
      driver.findElement(By.xpath("//div[text()='Continue']")).click();
      driver.quit();
	
	}
	
}
