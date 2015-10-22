/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.saucelabs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author Raghava
 */
public class TestData {
    
    public List<TestStep> teststeps;
    TestData(String filePath,WebDriver driver) throws Exception{
        this.teststeps = new ArrayList<TestStep>();
        FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\" + filePath));
        HSSFWorkbook workbook = new HSSFWorkbook (file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next();
        while (rowIterator.hasNext())
        {
            TestStep t = new TestStep(driver);
            Row row = rowIterator.next();
            t.Action =  (row.getCell(1) != null ? row.getCell(1).getStringCellValue() : "");
            t.Field = (row.getCell(2) != null ? row.getCell(2).getStringCellValue() : "");
            t.FieldType = (row.getCell(3) != null ? row.getCell(3).getStringCellValue() : "");
            t.Associate = (row.getCell(4) != null ? row.getCell(4).getStringCellValue() : "");
            teststeps.add(t);
        }
        file.close();
    }  

}

  