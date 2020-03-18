package com.foundations;

import java.util.*;

public class Match_output {

    public String match(String d, String file, String lan) throws Exception {
        int c=0;
        String k=" ";
        Tert t=new Tert();
        Foo f=new Foo();
        List<String> L = t.output("C:\\Users\\Asus\\Desktop\\JavaOfflineJudge\\src\\problem-Inputs-Outputs\\Outputs\\out-" + d + ".txt");
        f.runfile(d,lan,file);
        List<String> q=f.result_list();
        if(q.size()==0){
            k="Compilation Error";
        }
        else{
            for(int i=0;i<L.size();i++){
                if(L.get(i).equals(q.get(i))) c+=1;
            }
        }
        if(c==q.size() && q.size()!=0) return k="Accepted";
        else if(c<q.size() && q.size()!=0)return k="Wrong Answer on\ntest case-"+(c+1);
        //System.out.println(k);
        return k;

    }

}
