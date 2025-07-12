package org.ictkerala.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee  extends Login{

public AddEmployee(WebDriver driver) {
	super(driver);
}
public void add() {
	WebElement add=driver.findElement(By.xpath("(//button[@type='button'])[5]"));
	add.click();
}
public void enterfirst(String first) {
WebElement frst=	driver.findElement(By.xpath("//input[@placeholder='First Name']"));
frst.sendKeys(first);
}
public void lastname(String last) {
	WebElement lst=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
lst.sendKeys(last);
}
	
public void save() {
	WebElement sv=driver.findElement(By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary')]"));
	sv.click();
	

/*public void save() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Wait for the save button to be clickable
    WebElement sv = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//button[@type='submit' and contains(@class, 'oxd-button--secondary')]")));

    // Scroll to the button
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", sv);

    // Use JS click to avoid any click interception
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sv);

    // ✅ Wait for success message or indicator after save (adjust the XPath if needed)
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//*[contains(text(), 'Successfully Saved')]"))); // or use another stable success locator*/
}
public void logincredential() {
	WebElement lgn=driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']"));
lgn.click();
}
public void eneterusername(String username) {
	WebElement user=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]"));
	user.sendKeys(username);
}
public void eneterpassword(String password) {
	WebElement pass=driver.findElement(By.xpath("(//input[@type='password'])[1]"));
	pass.sendKeys(password);
}
public void eneterconfirmpass(String conpas) {
	WebElement con=driver.findElement(By.xpath("(//input[@type='password'])[2]"));
	con.sendKeys(conpas);
}
public void editablefield(String date) {
	WebElement dat=driver.findElement(By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]"));
	dat.sendKeys(date);
}
public void savethefield() {
	WebElement savefield=driver.findElement(By.xpath("(//button[@type='submit' and contains(@class, 'oxd-button--secondary')])[1]"));
savefield.click();
}
public void title() {
	WebElement ttl=driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'and text()='Personal Details']"));

}

}