package tests.day12_webTables;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class exell {

    @Test
    public void exeldeneme() throws IOException {
       String dosyayolu = "src/test/java/tests/day12_webTables/yeni.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyayolu);
        //WorkbookFactory.create(fileInputStream);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        System.out.println(sayfa1.getRow(2).getCell(2));
        String istenen = sayfa1.getRow(2).getCell(2).toString();
        System.out.println(istenen);

        String expected = "t";
        String actuel = sayfa1.getRow(4).getCell(1).toString();
        Assert.assertEquals(expected ,actuel);

        System.out.println(sayfa1.getLastRowNum());
        System.out.println(sayfa1.getPhysicalNumberOfRows());


    }







}
