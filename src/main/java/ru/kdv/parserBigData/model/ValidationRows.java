package ru.kdv.parserBigData.model;

import lombok.Data;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationRows {
    private List<Row> errorRows;
    private List<List<Integer>> notValidCells;
    private int counter;

    public ValidationRows() {
        refresh();
        counter = 0;
    }

    public void refresh() {
        errorRows = new ArrayList<>();
        notValidCells = new ArrayList<>();
    }

    public String getAndIncrementCounter() {
        return String.valueOf(counter++);
    }
}
