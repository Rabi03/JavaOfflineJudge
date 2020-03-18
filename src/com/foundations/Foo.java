package com.foundations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Foo {
    public static List<String> l;;
    public static String c[];
    public static String d;
    public Foo(){
        this.l=new ArrayList<String>();
    }

    public void runfile(String m,String s,String file) throws IOException{
        File theFile = new File(file);
        String parent = theFile.getName();
        String fileN = parent.replaceFirst("[.][^.]+$", "");
        Process process;
        final String JAVA_FILE_LOCATION = file;
        if(s.equals("c++")) {
            String command[] = {"g++", "-o", "cpp.exe", JAVA_FILE_LOCATION};
            c=command;
            d="cpp.exe";
        }
        if(s.equals("c")) {
            String command[] = {"gcc", "-o", "c.exe", JAVA_FILE_LOCATION};
            c=command;
            d="c.exe";
        }
        if(s.equals("java")) {
            String command[] = {"javac", JAVA_FILE_LOCATION};
            c=command;
        }


            ProcessBuilder processBuilder = new ProcessBuilder(c);

            process = processBuilder.start();
            if (process.getErrorStream().read() != -1) {
                //result(process.getErrorStream());
                process.destroy();
                process.exitValue();
                return;

            }

        if( process.exitValue() == 0 ){
            for(int i=1;i<4;i++) {
                if(s.equals("java")){
                    process = new ProcessBuilder(new String[]{"java","-cp","d:\\",fileN}).start();
                }
                else process = new ProcessBuilder(new String[]{d}).start();
                OutputStream os = process.getOutputStream();
                Files.copy(Paths.get("C:\\Users\\Asus\\Desktop\\JavaOfflineJudge\\src\\problem-Inputs-Outputs\\Inputs\\in-"+m+"."+i+".txt"), os);
                os.close();

                if (process.getErrorStream().read() != -1) {
                    //result(process.getErrorStream());
                    process.destroy();
                    process.exitValue();
                    return;
                } else {
                    result(process.getInputStream());
                }
            }
        }
    }

    private  void result(InputStream input) throws IOException{
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            String line = null;
            while ((line = in.readLine()) != null) {
                this.l.add(line);
            }
            in.close();
    }
    public List<String> result_list(){
        return this.l;
    }


}