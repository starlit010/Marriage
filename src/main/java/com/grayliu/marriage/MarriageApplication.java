package com.grayliu.marriage;

import com.grayliu.marriage.excel.read.ReadExcel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.grayliu.marriage.db.dao")
public class MarriageApplication {

    public static void main(String[] args) {

        SpringApplication.run(MarriageApplication.class, args);

        ReadExcel obj = new ReadExcel();
        String pathName = "E:/Esseay/90_girls.xls";
        ReadExcel readExcel = new ReadExcel();
        Workbook workbook = readExcel.getWorkbook(pathName);
        int numberOfSheet = workbook.getNumberOfSheets();
        for(int i = 0 ; i < numberOfSheet ; i++){
            Sheet sheet = readExcel.getSheet(i, workbook);
            readExcel.readRows(sheet);
        }
    }
}
