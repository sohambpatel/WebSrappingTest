import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UsingSelenium {

    public static void seleniumStart(String url){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        try{
            List<WebElement> hrefElements;
            driver.get(url);
             hrefElements=driver.findElements(By.xpath("//a[@href]"));
             for(WebElement hrefElement:hrefElements){
                 System.out.println(hrefElement.getDomProperty("href"));
             }
             driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            driver.quit();
        }
    }
    public static void main(String args[]){
        seleniumStart("https://sourceforge.net/projects/orangehrm/");
    }
}
