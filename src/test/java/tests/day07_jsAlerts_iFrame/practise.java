package tests.day07_jsAlerts_iFrame;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class practise extends TestBase {
    @Test
    public void practice() {


        //1. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //2. Ana sayfanın başarıyla göründüğünü title "Automation Exercise"ile doğrulayın
        String expected ="Automation Exercise";
        String actuel= driver.getTitle();
        Assert.assertEquals(expected,actuel);
        //3.  Sayfa’nin window handle degerini String bir degiskene atayin
        String testwindowhandle = driver.getWindowHandle();
        //4. ilk ürünüde Viev Product a tıklayın
        driver.findElement(By.xpath("(//*[@class='fa fa-plus-square'])[1]")).click();
        //5."blue Top" Ürününü sepete ekleyin
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();
        //5. 'View Cart' a tıklayın
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        //6. Blue Top ürününün Sepette görüntülendiğini doğrulayın.
        ReusableMethods.bekle(2);
        WebElement blue=driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Assert.assertTrue(blue.isDisplayed());
        //7. bir önceki sayfaya geri dönün
        driver.navigate().back();
        //8. sayfayı yenileyin
        driver.navigate().refresh();
        //8. Sign ap/Login tıklayın
        WebElement login = driver.findElement(By.xpath(" //*[text()=' Signup / Login']"));
        login.click();
        //9. New User Signup kısmına Faker isim ve mail girin
        ReusableMethods.bekle(1);
        WebElement user = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        actions.click(user).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        ReusableMethods.bekle(4);
        //10.Yeni bir sekme açın ve "https://www.youtube.com/ adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com/");
        ReusableMethods.bekle(5);
        //11.Ara kısmına Faker müzik girin
        //Faker faker1=new Faker();
         WebElement ara = driver.findElement(By.xpath("//input[@id='search']"));
         ara.click();
         ara.sendKeys("zorunda mıyım", Keys.ENTER);


         //ara.sendKeys(faker1.music().instrument(),Keys.ENTER);

        //12.Müziği açın
        driver.findElement(By.xpath("(//*[@class='text-wrapper style-scope ytd-video-renderer'])[1]")).click();
        ReusableMethods.bekle(10);
        //13.tüm sayfanın ss alın

        //13.önceki sekmeye geri dönün.
    }
}
