package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ConfirmationPage {

    //@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/section/div/a[1]")
	@FindBy(how = How.ID, using = "btnvalid")
    public WebElement btnConfirmation;

    @FindBy(how = How.LINK_TEXT, using="Se déconnecter")
    public WebElement btnLogout;


    public ConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void confirm(){
        btnConfirmation.click();
    }
    public void selectCGI(WebDriver driver){
    	
    	try
    	{
    		WebElement select = driver.findElement(By.xpath("/html/body/div[4]/div/table[5]/tbody/tr[2]/td[2]/div/select"));
        	if(select != null)
        	{
            Select SelectedCGI=new Select(select) ;
            //SelectedCGI.selectByVisibleText("CGI_CAC_Entité_ non cotée_non EIP sans notes");
            SelectedCGI.selectByIndex(1);
        	}
    	}
    	catch(Exception ex)
    	{
    		
    	}
    	

    }

    public void selectCGItest(WebDriver driver){
    	try
    	{
            WebElement select = driver.findElement(By.xpath("/html/body/div[4]/div/table[5]/tbody/tr[2]/td[2]/div/select"));
        	if(select != null)
        	{
            Select SelectedCGI=new Select(select) ;
            SelectedCGI.selectByVisibleText("Test");
        	} 
        
    	}
    	catch(Exception ex)
    	{
    		
    	}
   

    }

    public void logout(){
        btnLogout.click();
    }
}
