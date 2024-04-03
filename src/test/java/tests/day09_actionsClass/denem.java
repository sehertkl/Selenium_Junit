package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class denem extends TestBase {
    @Test
    public void denemeee(){
         //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions =new Actions(driver);
        ReusableMethods.bekle(3);
        WebElement drag = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement droop =driver.findElement(By.xpath("(//*[@id=\"droppable\"])[1]"));
        ReusableMethods.bekle(3);
        actions.dragAndDrop(drag, droop).perform();
        ReusableMethods.bekle(3);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement yeni = driver.findElement(By.xpath("//*[@id=\"droppable\"]/p"));
        String expected ="Dropped!";
        String actuel = yeni.getText();
        Assert.assertEquals(expected,actuel);





    }
}
