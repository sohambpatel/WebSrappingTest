import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;

public class ConsoleLogsCapture {

    public static void checkConsoleSelenium(String url){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        try{
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            LogEntries entry=driver.manage().logs().get(LogType.BROWSER);
            System.out.println("Started capturing the logs");
            System.out.println("==========================================================");

            for(LogEntry e : entry){
                System.out.println(e);
            }
            driver.quit();
        }catch(Exception e){
            e.printStackTrace();
            driver.quit();
        }
    }

    public static void main(String args[]){
        checkConsoleSelenium("https://sourceforge.net/projects/orangehrm/");
    }
}
