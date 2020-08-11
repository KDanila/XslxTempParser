package ru.kdv.parserBigData.parser;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.kdv.parserBigData.util.XlsValidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Parser {

    public static void parseFiles() {
        String resourceDirectory = "src/main/resources/";
        String s = getSqlIntoCommandFromXlsx(new File(resourceDirectory + "CA_TRANSFER_HI_10.06.2020.xlsx"));
    }


    public static String getSqlIntoCommandFromXlsx(File file) {
        String toReturn = " ";
        try (FileInputStream fileInputStream = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
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
    private static void parseToSqlInsertTypeFromXml(Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Cell cell = null;
            List<Integer> invalidateColumnNumber = XlsValidator.validateRow(row);
            if(invalidateColumnNumber.size() != 0){
                //todo write in other xls
                return;
            }
            System.out.print((int) row.getCell(0).getNumericCellValue() + " ");
            System.out.print(row.getCell(1).getStringCellValue() + " ");
            System.out.print(row.getCell(2).getStringCellValue() + " ");
            System.out.print(row.getCell(3).getStringCellValue() + " ");
            System.out.print(row.getCell(4).getStringCellValue() + " ");
            System.out.print(row.getCell(5).getLocalDateTimeCellValue() + " ");
            System.out.print(row.getCell(6).getLocalDateTimeCellValue() + " ");
            System.out.print(row.getCell(7).getStringCellValue() + " ");
            System.out.print(new BigDecimal(String.valueOf(row.getCell(8).getNumericCellValue())) + " ");
            System.out.print(row.getCell(9).getStringCellValue() + " ");
            System.out.print(row.getCell(10).getStringCellValue() + " ");
            System.out.print(row.getCell(11).getLocalDateTimeCellValue() + " ");
            System.out.print(row.getCell(12).getStringCellValue() + " ");
            System.out.print(row.getCell(13).getStringCellValue() + " ");
            System.out.print(row.getCell(14).getStringCellValue() + " ");
            System.out.print(row.getCell(15).getStringCellValue() + " ");
            System.out.print(row.getCell(16).getStringCellValue() + " ");
            System.out.print(row.getCell(17).getStringCellValue() + " ");
            System.out.print(row.getCell(18).getStringCellValue() + " ");
            System.out.print(row.getCell(19).getLocalDateTimeCellValue() + " ");
            System.out.print(row.getCell(20).getLocalDateTimeCellValue() + " ");
            System.out.print(row.getCell(21).getLocalDateTimeCellValue() + " ");
            System.out.print(row.getCell(22).getLocalDateTimeCellValue() + " ");
            System.out.print(new BigDecimal(String.valueOf(row.getCell(23).getNumericCellValue())) + " ");
            System.out.print(new BigDecimal(String.valueOf(row.getCell(24).getNumericCellValue())) + " ");
            System.out.print(new BigDecimal(String.valueOf(row.getCell(25).getNumericCellValue())) + " ");
            System.out.print(new BigDecimal(String.valueOf(row.getCell(26).getNumericCellValue())) + " ");
            System.out.print(new BigDecimal(String.valueOf(row.getCell(27).getNumericCellValue())) + " ");
            System.out.print(new BigDecimal(String.valueOf(row.getCell(28).getNumericCellValue())) + " ");
            System.out.print(new BigDecimal(String.valueOf(row.getCell(29).getNumericCellValue())) + " ");
            System.out.print(row.getCell(30).getLocalDateTimeCellValue() + " ");
            System.out.print((int) row.getCell(31).getNumericCellValue() + " ");
            System.out.print(row.getCell(32).getLocalDateTimeCellValue() + " ");
            System.out.print(new BigDecimal(String.valueOf(row.getCell(33).getNumericCellValue())) + " ");
            System.out.print(row.getCell(34).getNumericCellValue() + " ");
            System.out.print(row.getCell(35).getNumericCellValue() + " ");
            System.out.println();
        }
    }
}
