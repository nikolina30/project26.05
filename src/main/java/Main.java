import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.kupujemprodajem.com/");

        WebElement popUp = driver.findElement(By.className("kpBoxCloseButton"));
        popUp.click();

        WebElement search = driver.findElement(By.id("searchKeywordsInput"));
        search.sendKeys("iphone 13");
        search.sendKeys(Keys.ENTER);

        WebElement firstPhoneElementInList = driver.findElement(By.id("adDescription7321776"));
        WebElement firstPhoneInList = firstPhoneElementInList.findElement(By.className("imgAndBlurHolder"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        firstPhoneInList.click();

        if(driver.findElement(By.className("oglas-title")).getText().equals("iPhone 13, iPhone 12, iPhone 11 - NOVO!")) {
            System.out.println("The first entry in the phone query is OK.");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
    }
}

