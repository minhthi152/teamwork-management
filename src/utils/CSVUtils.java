package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

//    public static <T> void write(String path, Object o){
//        try {
//            FileWriter fw = new FileWriter(path, true);
//
//                fw.write(o.toString());
//
//            fw.flush();
//            fw.close();
//        } catch (Exception e) {
//            throw new IllegalArgumentException(path + "invalid");
//        }
//    }
    public static <T> void write(String path, List<T> items){
        try {
            PrintWriter pw = new PrintWriter(path);
            for (Object item: items) {
                pw.println(item.toString());
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path + "invalid");
        }
    }


    public static List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty())
                lines.add(line);
        } catch (IOException e) {
            throw new IllegalArgumentException(path + "invalid");
        }
        return lines;
    }

//    public static List<String> read(String path){
//        try {
//            return Files.readAllLines(Paths.get(path));
//        } catch (IOException e) {
//            throw new IllegalArgumentException(path + "invalid");
//        }
//    }
}
