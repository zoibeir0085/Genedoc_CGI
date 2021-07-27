package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EngagementsPage {

    //@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[2]/table/tbody/tr/td[1]/input")
	@FindBy(how = How.ID, using = "codeengag")
    public WebElement engagementCode;

    //@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[2]/table/tbody/tr/td[2]/button")
	@FindBy(how = How.ID, using = "searchbutton")
    public WebElement select;

    //@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div[3]/table/tbody/tr")
    public WebElement engagement;


    public EngagementsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }
    public void insertEngagementCode(String code){
        engagementCode.sendKeys(code);
        select.click();
    }
    public void selectEngagement (WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        
        List<WebElement> lst_engagement =  driver.findElements(By.className("ligneLien"));
        
        engagement= lst_engagement.size() > 0 ? lst_engagement.get(0) : null;
        
        if(engagement != null)
        	engagement.click();
    }
}
