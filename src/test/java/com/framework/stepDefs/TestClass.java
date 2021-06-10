package com.framework.stepDefs;

public class TestClass {


    public static void main(String[] args) {
        String str="abc(tetet}(87i]}";
        System.out.println(testString(str));

    }

    public static  boolean testString(String str){
        //(){}--- ({)

       char[] ch= str.toCharArray();
       boolean valid =true;

       for(int i=0;i<ch.length-1;i++){
           int endIndex1=0;
           int endIndex2=0;
           int endIndex3=0;
           if(ch[i]=='(' ){
               int startIndx=i;
               for(int j=i;j<ch.length-1;j++){
                   if(ch[j]==')'){
                       endIndex1 =j;
                   }
                    if(ch[j]=='}'){
                       endIndex2 =j;
                   }
                   if(ch[j]==']'){
                       endIndex3 =j;
                   }
               }
               if(endIndex1>endIndex2){
                   valid=false;
                   break;
               }

               else if(endIndex1>endIndex3){
                   valid=false;
                   break;
               }

           }
       }
        return valid;
    }

}
