package ru.kdv.writer;

import java.io.*;

public class Writer {
    public static void writIn(String directory, String fileName, String content) {
        try (java.io.Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(directory + fileName + ".txt"), "utf-8"))) {
            writer.write(content);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
