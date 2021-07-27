package Steps;

//import cucumber.api.DataTable;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;


import Pages.* ;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import cucumber.api.DataTable;


public class FirstStep {
    WebDriver driver;
    
   


    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("Navigate login page");
        //for windows
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //for linux
        //System.setProperty("webdriver.chrome.driver","chromedriver");


        Map<String, Object> prefs = new HashMap<String, Object>();

        //To Turns off multiple download warning
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver =  new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.navigate().to("https://aezan.genedoc.fr/Login");

    }



    @And("I click login button")
    public void iClickLoginButton() {
       // System.out.println("Click login button");

        LoginPage page = new LoginPage(driver);

        page.ClickLogin();
    }

    @Then("I should see the welcome page")
    public void iShouldSeeTheUserformPage() {
        System.out.println("I should see userform");
        //Assert.assertEquals("its not displayed",driver.findElement(By.className("container body-content")).isDisplayed(),true );


        //driver.findElement(By.name("generate")).click() ;


    }

    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterUsernameAndPassword(String username, String password) throws InterruptedException {
        LoginPage page = new LoginPage(driver);
        page.Login(username,password);
        Thread.sleep(2000);
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() throws InterruptedException {
        Thread.sleep(1);
        driver.quit();
        driver=null ;
    }

    @Then("I navigate to the creation of new folder page")
    public void iNavigateToTheCreationOfNewFolderPage() throws InterruptedException {
        WelcomePage page =new WelcomePage(driver);
        page.goToNouveauDossier();
        Thread.sleep(2000);

    }
    @Then("I enter \"([^\"]*)\"  , \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"")
    public void iEnterAnd(String Document, String CharteGraphique, String Redacteurs, String Approbateur) throws InterruptedException {
        CreationPage page = new CreationPage(driver);

        //select DocumentType
        page.SelectDocument(driver,Document);

        //select CharteGraphique
        page.SelectChart(driver,CharteGraphique);

        //select Redactors
        page.SelectRedactors(driver,Redacteurs);

        //select Approbator
        page.SelectApprobator(driver,Approbateur);

        //Validation
        page.Validate();        Thread.sleep(1000);

    }

    @Then("I validate")
    public void iValidate() throws InterruptedException {
        RapportPage page = new RapportPage(driver);
        page.Validate();
        Thread.sleep(2000);

    }

    @Then("I preview")
    public void iPreview() throws InterruptedException {
        RapportPage page = new RapportPage(driver);
        page.Preview();
        Thread.sleep(2000);

    }

    @Then("I logout")
    public void iLogout() throws InterruptedException {
        RapportPage page = new RapportPage(driver);
        page.Logout();
        Thread.sleep(2000);

    }
    @Then("I verify that the words was successfully downloaded")
    public void iVerifyThatThePdfWasSuccessfullyDownloaded() throws InterruptedException {
        DownloadsPage page= new DownloadsPage(driver);
        page.verifyDownloadWithFileExtension(".docx");

    }

    @Then("I verify the no EIP")
    public void iVerifyTheNoEIP() throws InterruptedException {
        RapportPage page = new RapportPage(driver);
        page.verifyNoEIP();
    }

    @Then("I verify the EIP")
    public void iVerifyTheEIP() throws InterruptedException {
        RapportPage page = new RapportPage(driver);
        page.verifyEIP();
    }

    @Then("I activate EIP")
    public void iActivateEIP() throws InterruptedException {
        CreationPage page = new CreationPage(driver);
        page.activateEIP();


    }

    @Then("I validate the form1")
    public void iValidateTheForm1() throws InterruptedException {
        CreationPage page = new CreationPage(driver);
        page.Validate2();
        Thread.sleep(3000);

    }

    @Then("I validate the form2")
    public void iValidateTheForm2() throws InterruptedException {
        CreationPage page = new CreationPage(driver);
        page.Validate3();
        Thread.sleep(3000);

    }

    @Then("I verify the contenu of the pdf EIP")
    public void iVerifyTheContenuOfThePdfEIP() {
        String cont1=new String("Ind");
        String cont4=new String("pendance");
        String cont2=new String("avons pas fourni de services interdits");
        String cont3="article 5, paragraphe 1,";
        String cont5="537/2014";
        PDFPage page= new PDFPage(driver);
        page.afficherPDF();
        boolean b1= page.verifyPDFContenu(cont1);
        Assert.assertTrue(b1, "Can not found : \n" +cont1);
        boolean b2= page.verifyPDFContenu(cont2);
        Assert.assertTrue(b2, "Can not found : \n" +cont2);
        boolean b3= page.verifyPDFContenu(cont3);
        Assert.assertTrue(b3, "Can not found : \n" +cont3);
        boolean b4= page.verifyPDFContenu(cont3);
        Assert.assertTrue(b4, "Can not found : \n" +cont4);
        boolean b5= page.verifyPDFContenu(cont3);
        Assert.assertTrue(b5, "Can not found : \n" +cont5);

    }

    @Then("I verify the contenu of the pdf non EIP")
    public void iVerifyTheContenuOfThePdfNonEIP() {
        String cont1=new String("Ind");
        String cont3=new String("pendance");

        String cont2=new String("avons pas fourni de services interdits par le code de d");
        String cont4= "ontologie de la profession de commissaire \n" +
                "aux comptes.";
        PDFPage page= new PDFPage(driver);
        page.afficherPDF();

        boolean b1= page.verifyPDFContenu(cont1);
        Assert.assertTrue(b1, "Can not found : \n" +cont1);
        boolean b3= page.verifyPDFContenu(cont1);
        Assert.assertTrue(b3, "Can not found : \n" +cont3);

        boolean b2= page.verifyPDFContenu(cont2);
        Assert.assertTrue(b2, "Can not found : \n" +cont2);
        boolean b4= page.verifyPDFContenu(cont1);
        Assert.assertTrue(b4, "Can not found : \n" +cont4);

    }

    @Then("I enter {string}")
    public void iEnter(String arg0) {
        CreationPage page = new CreationPage(driver);
        try {
            page.addDateDeCloture();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("I enter the engagement code : {string}")
    public void iEnterTheEngagementCode(String code) throws InterruptedException {
        EngagementsPage page = new EngagementsPage(driver);
        page.insertEngagementCode(code);
        Thread.sleep(2000);

    }


    @Then("I select the engagement")
    public void iSelectTheEngagement() throws InterruptedException {
        EngagementsPage page = new EngagementsPage(driver);
        page.selectEngagement(driver);
        Thread.sleep(1000);
    }

    @Then("I validate the engagement")
    public void iValidateTheEngagement() throws InterruptedException {
        ConfirmationPage page = new ConfirmationPage(driver);
        page.confirm();
        Thread.sleep((1000));



    }

    @Then("I select the CGI")
    public void iSelectTheCGI() throws InterruptedException {
        ConfirmationPage page = new ConfirmationPage(driver);
        page.selectCGI(driver);
        Thread.sleep(1000);

    }

    @Then("I navigate to the engagement page")
    public void iNavigateToTheEngagementPage() throws InterruptedException {
        RapportPage page = new RapportPage(driver);
        page.goToEngagement();
    }

    @Then("I navigate to the Annexes Fusionnees page")
    public void iNavigateToTheAnnexesFusionneesPage() 
    {
        driver.navigate().to("https://aezan.genedoc.fr/AdminDoc/Models");
                
    	WebElement Tab_Test=driver.findElement(By.id("TEST model base"));
        
        if(Tab_Test != null)
    	{
        	WebElement btnNouveauAnnexe=Tab_Test.findElement(By.xpath("td[8]/table/tbody/tr/td[4]/input"));    		
    		btnNouveauAnnexe.click();
        }
    }


    @Then("I add new Annexe with path {string}")
    public void iAddNewAnnexeWithPath(String file) throws InterruptedException {
        AnnexesPage page = new AnnexesPage(driver);
        page.createNewAnnexe(file,driver);
    }

    @Then("I delete the annexe added")
    public void iDeleteTheAnnexeAdded() throws InterruptedException 
    {
        AnnexesPage page = new AnnexesPage(driver);
        page.deleteAnnexeCreated(driver);
    }

    @Then("I select the CGI test")
    public void iSelectTheCGITest() throws InterruptedException 
    {
        Thread.sleep(2000);
        ConfirmationPage page = new ConfirmationPage(driver);
        page.selectCGItest(driver);
        Thread.sleep(2000);
    }
}
