package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AnnexesPage 
{
	@FindBy(how = How.ID, using ="TEST model base")
	public static WebElement Tab_Test;
	 
   //@FindBy(how = How.XPATH, using="/html/body/div[3]/div/div/div[2]/div/button")
    public WebElement btnNouveauAnnexe;

    //@FindBy(how = How.XPATH, using="/html/body/div[3]/div/div/table/tbody/tr[1]/td[1]/input")
    public WebElement annexeName;


    //@FindBy(how = How.XPATH, using="/html/body/div[3]/div/div/table/tbody/tr[1]/td[2]/form/input")
    public WebElement annexeFile;

    //@FindBy(how = How.XPATH, using="/html/body/div[3]/div/div/table/tbody/tr[2]/td/button[1]")
    public WebElement saveAnnexe;

    //@FindBy(how = How.XPATH, using="/html/body/div[3]/div/div/div[1]/table/tbody/tr[5]/td[2]/table/tbody/tr/td[2]/input")
    public WebElement deleteAnnexe;


    public AnnexesPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        
    }

    public void createNewAnnexe(String file,WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        
        btnNouveauAnnexe=driver.findElement(By.id("newModel"));
        
        btnNouveauAnnexe.click();
        
        Thread.sleep(2000);
        
        annexeName=driver.findElement(By.id("DocumentName"));
        
        annexeName.sendKeys(" Test");
        Thread.sleep(1000);
        
        annexeFile=driver.findElement(By.id("file"));
        
        annexeFile.sendKeys(file);
               
        Thread.sleep(2000);
        
        saveAnnexe=driver.findElement(By.id("mod_updateBtn"));
        saveAnnexe.click();
        Thread.sleep(2000);
    }

    public void deleteAnnexeCreated(WebDriver driver) throws InterruptedException 
    {
        Thread.sleep(2000);
        
        
        List<WebElement> lstAnnexes=driver.findElements(By.className("testclass"));
        
        for (WebElement item : lstAnnexes) 
        {
		 
        	 System.out.println(item.getText());
        	
        	 if(item.getText().equals("NOUVELLE ANNEXE TEST"))
        	 {
        		 deleteAnnexe=item.findElement(By.xpath("td[2]/table/tbody/tr/td[4]/input"));
        		 deleteAnnexe.click();
        		 
        	     Thread.sleep(2000);
        	        
        	     driver.switchTo().alert().accept();
        	 }
        }
        
        //deleteAnnexe.click();

        Thread.sleep(2000);

    }


}
