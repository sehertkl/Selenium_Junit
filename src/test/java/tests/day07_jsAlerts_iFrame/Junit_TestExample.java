package tests.day07_jsAlerts_iFrame;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Junit_TestExample extends TestBase {

    @Test
    public void sepet(){

        //1. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //2.  Sayfa’nin window handle degerini String bir degiskene atayin
        String testwindowhandle = driver.getWindowHandle();
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String expected = "Automation Exercise";
        Assert.assertTrue(driver.getTitle().contains(expected));

        //4. ilk ürünüde view tıklayın
        driver.findElement(By.xpath("(//*[@class='choose'])[1]")).click();
        //5."blue Top" Ürününü sepete ekleyin
        driver.findElement(By.xpath("//*[@class=\"btn btn-default cart\"]")).click();
        //5. 'Sepete göster' düğmesine tıklayın
        driver.findElement(By.xpath("(//*[@class='text-center'])[2]")).click();
        //6. Blue Top ürününün Sepette görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//a[text() =\"Blue Top\"]")).isDisplayed();
        //7. bri önceki sayfaya geri dönün
        driver.navigate().back();

        //8.sayfayı yenileyinai
        driver.navigate().refresh();
        ReusableMethods.bekle(2);

        //8. log in yapın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //9.Faker isim ve mail girin
        WebElement isim= driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        Actions action =new Actions( driver );
        Faker faker =new Faker();
        ReusableMethods.bekle(1);
        action.click(isim).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        ReusableMethods.bekle(1);
        //10.Yeni bir sekme açın ve "https://www.youtube.com/ adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.youtube.com/");
        ReusableMethods.bekle(1);
        //10. Sayfa title’nin “Youtube” icerdigini test edin
        String expectedTitleIcerik = "https://www.youtube.com";
        String actualTitle = driver.getCurrentUrl();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        //11.Ara kısmına Faker müzik girin
        WebElement ara =driver.findElement(By.xpath("//*[@placeholder=\"Ara\"]"));
        ara.sendKeys(faker.music().instrument());
        ara.submit();
        ReusableMethods.bekle(4);
        //12.Müziği açın
        WebElement muzik =driver.findElement(By.xpath("(//*[@class=\"style-scope ytd-video-renderer\"])[1]"));
        muzik.click();
        ReusableMethods.bekle(10);
        ReusableMethods.tumSayfaSreenshot(driver , "muzik");
        //13.önceki sekmeye geri dönün.
        driver.switchTo().window(testwindowhandle);

        ReusableMethods.bekle(10);










    }





}
