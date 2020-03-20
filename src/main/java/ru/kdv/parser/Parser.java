package ru.kdv.parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class Parser {
    public static String getSqlIntoCommandFromXlsx(File file) {
        String toReturn = " ";
        try (FileInputStream fileInputStream = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fileInputStream);) {
            toReturn = parseToSqlInsertTypeFromXml(workbook);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return toReturn;
    }


    // into KTP_VATS_AFFILATE (MRF_NAME, AFFILATE_NAME, CITY_NAME, CITY_ID)
    // values ('МРФ «Центр»','Смоленский филиал','Сафоново','766882700')
    private static String parseToSqlInsertTypeFromXml(Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);
        StringBuilder sb = new StringBuilder();
        for (Row row : sheet) {
            Cell cell = null;
            sb.append("into KTP_VATS_AFFILATE (MRF_NAME, AFFILATE_NAME, CITY_NAME, CITY_ID)\n values(");
            for (int i = 0; i < row.getLastCellNum(); i++) {
                cell = row.getCell(i);
                if (i == row.getLastCellNum() - 1) {
                    String s = new DecimalFormat("#").format(row.getCell(i).getNumericCellValue());
                    sb.append("'" + s + "'");
                } else {
                    sb.append("'" + cell + "',");
                }
            }
            sb.append(")\n");
        }
        return sb.toString();
    }
}
