package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.junit.Assert.assertThat;

public class RapportPage 
{
    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div[2]/div[1]/div[2]/img[2]")
    public WebElement btnValidation;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/span[1]")
    public WebElement btnPreview;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div[2]/div[1]/div[3]/ol/li[2]/ol/li[2]/ol/li/div")
    public WebElement articleNoEIP;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div[2]/div[1]/div[3]/ol/li[3]/ol/li[2]/ol/li/div")
    public WebElement articleEIP;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/textarea")
    public WebElement articleReference;


    //@FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div[1]/div/table/tbody/tr/td[4]/a/div")
    @FindBy(how = How.CLASS_NAME, using = "viewDocumentExternalValues")
    public WebElement btnEngagement;


    @FindBy(how = How.LINK_TEXT, using="Se déconnecter")
    public WebElement btnLogout;

    public RapportPage(WebDriver driver)  {
        PageFactory.initElements(driver,this);
    }

    public void Validate() {
        btnValidation.click();
    }

    public void Preview() throws InterruptedException {
        Thread.sleep(5000);
        btnPreview.click();
    }

    public void verifyNoEIP() throws InterruptedException{
        Thread.sleep(15000);
        articleNoEIP.click();
        Thread.sleep(8000);
        System.out.println("article reference= "+articleReference.getText());
        boolean EIP=(articleReference.getText().equals("Indépendance non EIP"));

        //Assert.assertEquals(EIP,true,"its not displayed" );
        Thread.sleep(5000);

    }

    public void verifyEIP() throws InterruptedException{
        Thread.sleep(15000);
        articleEIP.click();
        Thread.sleep(8000);
        System.out.println("article reference= "+articleReference.getText());
        boolean EIP=(articleReference.getText().equals("Indépendance EIP"));
        Thread.sleep(3000);
        //Assert.assertEquals(EIP,true,"its not displayed" );
        Thread.sleep(5000);


    }

    public void Logout(){
        btnLogout.click();
    }

    public void goToEngagement() throws InterruptedException {
        btnEngagement.click();
        Thread.sleep(5000);
    }

}
