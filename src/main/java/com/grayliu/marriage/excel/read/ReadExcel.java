package com.grayliu.marriage.excel.read;

import com.grayliu.marriage.db.dao.PersonDao;
import com.grayliu.marriage.db.entity.Person;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReadExcel {

    @Autowired
    PersonDao personDao;

    public static void main(String[] args) {
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        String pathName = "E:/Esseay/90_girls.xls";
//        File file = new File();
        ReadExcel readExcel = new ReadExcel();
        Workbook workbook = readExcel.getWorkbook(pathName);

        int numberOfSheet = workbook.getNumberOfSheets();

        for(int i = 0 ; i < numberOfSheet ; i++){
            Sheet sheet = readExcel.getSheet(i, workbook);
            readExcel.readRows(sheet);
        }
    }

    public Workbook getWorkbook(String path) {
        Workbook wb = null;
        File file = new File(path);
        InputStream is = null;
        try {
            is = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String filePath = file.getAbsolutePath();
        String extString = filePath.substring(filePath.lastIndexOf("."));
        try{
            if(".xls".equals(extString)){
                wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                wb = new XSSFWorkbook(is);
            }else{
                wb = null;
            }
        }catch(Exception e){

        }
        return wb;
    }

    public Sheet getSheet(int index, Workbook wb){
        InputStream is = null;
        Sheet sheet = null;
        sheet = wb.getSheetAt(index);
        return sheet;
    }

    public void readRows(Sheet sheet) {

        int rows = sheet.getPhysicalNumberOfRows();
//        Row row0 = sheet.getRow(0);
//        int cells = row0.getPhysicalNumberOfCells();

        //先读取第一列，找到字段
        Map<Integer, String> colMap = new HashMap<Integer, String>();
        for(int i = 0 ; i < rows ; i++){
            Row rowX = sheet.getRow(i);
            Cell cellX = rowX.getCell(0);
            if(cellX != null){
                String field = FieldConvert.getField(cellX.toString());
                colMap.put(i, field);
            }else{
                break;
            }
        }

        int cells = colMap.size();

        for (int j = 1; j < cells; j++) {
            Person person = new Person();
            for (int i = 0; i < rows; i++) {
                // 读取左上端单元格
                Row row = sheet.getRow(i);
                // 行不为空
                if (row != null) {
                    // 获取到Excel文件中的所有的列
    //                int cells = row.getPhysicalNumberOfCells();
                    // System.out.println("cells:" + cells);
                    // 遍历列
                    // 获取到列的值
                    Cell cell = row.getCell(j);
                    if (cell != null) {
//                            if (isMergedRegion(sheet, cell)) {
//                                value += getMergedRegionValue(sheet, cell);
//                            } else {
//                                value += "第" + (i + 1) + "行 第" + (j + 1) + "列 的内容是： " + getCellContent(cell) + ",";
//                            }

                        String content = cell.toString();
//                        System.out.println(content);
                        String fieldName = colMap.get(i);
                        String fieldMethod = "set" + fieldName.substring(0,1).toUpperCase() +fieldName.substring(1);
                        try {
                            if("setNum".equals(fieldMethod)){
                                Method method = Person.class.getMethod(fieldMethod,Integer.class);
                                method.invoke(person, Integer.valueOf(content));
                            }else{
                                Method method = Person.class.getMethod(fieldMethod,String.class);
                                method.invoke(person, content);
                            }
                        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            personDao.insert(person);
        }
    }






}