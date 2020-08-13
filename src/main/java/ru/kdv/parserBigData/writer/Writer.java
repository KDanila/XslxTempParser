package ru.kdv.parserBigData.writer;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.*;
import java.util.List;

public class Writer {
    public static void createXlsFileFromErrorRows(List<Row> errorRows, List<List<Integer>> notValidCellsList, String name) {
        if(errorRows.size() == 0){
            return;
        }
        File file = new File("src/main/resources/" + "workbook" + name + ".xlsx");
        Workbook wb = new SXSSFWorkbook();
        Sheet sheet1 = wb.createSheet("Error values");
        Row row;

        CellStyle errorStyle = wb.createCellStyle();
        errorStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        errorStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        List<Integer> notValidCells;
        for (int i = 0; i < errorRows.size(); i++) {
            row = sheet1.createRow(i);
            notValidCells = notValidCellsList.get(i);
            Cell cell, cellFrom;

            for (int j = 0; j < errorRows.get(i).getLastCellNum(); j++) {
                cell = row.createCell(j);
                cellFrom = errorRows.get(i).getCell(j);

                if (notValidCells.contains(j)) {
                    cell.setCellStyle(errorStyle);
                }

                if (cellFrom == null) {
                    cell.setCellValue("");
                } else {
                    cell.setCellValue(cellFrom.getStringCellValue());
                }

            }
        }

        try (OutputStream fileOut = new FileOutputStream(file)) {
            wb.write(fileOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
