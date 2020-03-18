package com.foundations;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Tert {

    public List<String> output(String s) throws Exception {
        List<String> list = new ArrayList<String>();
        String e=s;
            BufferedReader br = new BufferedReader(new FileReader(e));
            String st;
            while ((st = br.readLine()) != null)
                list.add(st);
        return list;
    }
    public List<String> input(String s1) throws Exception {
        List<String> list = new ArrayList<String>();
        File[] fileList = getFileList(""+s1);

        for(File file : fileList) {
            list.add(file.getName());
        }
        return list;
    }

    private static File[] getFileList(String dirPath) {
        File dir = new File(dirPath);

        File[] fileList = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });
        return fileList;
    }
}