package ru.kdv;

import ru.kdv.parser.Parser;
import ru.kdv.writer.Writer;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String resourceDirectory = "src/main/resources/";
        String s = Parser.getSqlIntoCommandFromXlsx(new File(resourceDirectory + "vats_affilate.xlsx"));
        System.out.println(s);
        Writer.writIn(resourceDirectory, "sqlInsertFile", s);
    }
}
