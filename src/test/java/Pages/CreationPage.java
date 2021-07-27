package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;

public class CreationPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]/div/div/a")
    public WebElement btnValidation2;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/form/section/div/div/a")
    public WebElement btnValidation3;


    @FindBy(how = How.ID, using = "validbutton")
    public WebElement btnValidation;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/form/div/table/tbody/tr[65]/td[2]/div/div/div")
    public WebElement eip;



    @FindBy(how = How.XPATH, using = "/html/body/div[3]/form/div/table/tbody/tr[47]/td[2]/div/input")
    public WebElement dateDeCloture;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[3]/ul[3]/li[42]")
    public WebElement selectedDateDeCloture;

    public CreationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void SelectDocument(WebDriver driver,String document){
        Select SelectedDoc=new Select(driver.findElement(By.id("SelectDocument"))) ;
        SelectedDoc.selectByVisibleText(document);
    }

    public void SelectChart(WebDriver driver,String chart){
        Select SelectedChart=new Select(driver.findElement(By.id("SelectChart"))) ;
        SelectedChart.selectByVisibleText(chart);
    }

    public void SelectRedactors(WebDriver driver,String redactor){
        Select SelectedRedactors=new Select(driver.findElement(By.id("SelectRedactors"))) ;
        SelectedRedactors.selectByVisibleText(redactor);
        SelectedRedactors.selectByVisibleText("Corbet Sophie");

    }

    public void SelectApprobator(WebDriver driver,String approbator){
        Select SelectedApprobator=new Select(driver.findElement(By.id("SelectApprobator"))) ;
        SelectedApprobator.selectByVisibleText(approbator);
    }


    public void activateEIP() throws InterruptedException {
        Thread.sleep(3000);
        eip.click();
        Thread.sleep(8000);
    }


    public void Validate() {
        btnValidation.click();
    }


    public void Validate2() throws InterruptedException {
        btnValidation2.click();
        Thread.sleep(5000);
    }

    public void Validate3() {
        btnValidation3.click();
    }

    public void addDateDeCloture() throws InterruptedException {
        dateDeCloture.click();
        Thread.sleep(2000);
        selectedDateDeCloture.click();
        Thread.sleep(3000);
    }
}