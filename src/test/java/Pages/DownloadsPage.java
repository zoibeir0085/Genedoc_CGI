package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DownloadsPage {

    //String downloadPath="/home/ala/Téléchargements";
    String downloadPath="C:\\Users\\abensalah\\Downloads";

    public DownloadsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    public void verifyDownloadWithFileExtension(String ext)  {
        Assert.assertTrue(isFileDownloaded_Ext(downloadPath, ext), "Failed to download document which has extension .pdf");
    }

    public String pdfFileName()
    {
        String file = "";
        if (getLatestFilefromDir(downloadPath).getName().contains(".pdf"))
        {
            return getLatestFilefromDir(downloadPath).getName();
        }
        else if (getLatestFilefromDir(downloadPath).getName().contains(".pdf")) 
        {
            file = getSecondLatestFilefromDir(downloadPath).getName();
        }
        return file ;
    }

    private boolean isFileDownloaded_Ext(String dirPath, String ext)
    {
        int compteur =0;
        boolean flag=false;
        if (getLatestFilefromDir(downloadPath).getName().contains(ext) )
        {
            compteur++;
        }
        if (getSecondLatestFilefromDir(downloadPath).getName().contains(ext) )
        {
            compteur++;
        }

        /*if (getThirdLatestFilefromDir(downloadPath).getName().contains(ext) )
        {
            compteur++;
        }*/

        if (compteur >=1 ) flag=true;

            return flag;
    }
    
    private File getLatestFilefromDir(String dirPath)
    {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }
        Arrays.sort(files, Comparator.comparingLong(File::lastModified));
        
        System.out.println("Last modified:"+ files[files.length-1]);
        File lastModifiedFile = files[files.length-1];
        return lastModifiedFile;
    }
    
    private File getSecondLatestFilefromDir(String dirPath)
    {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) 
        {
            return null;
        }

        Arrays.sort(files, Comparator.comparingLong(File::lastModified));

        
        System.out.println("second last modified:"+ files[files.length-2]);
        
        return files[files.length-2];
    }


    private File getThirdLatestFilefromDir(String dirPath)
    {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) 
        {
            return null;
        }

        Arrays.sort(files, Comparator.comparingLong(File::lastModified));
        System.out.println("third last modified: "+ files[files.length-3]);
        return files[files.length-3];
    }


}
