package com.example;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MyClass3 {


    public static void main(String[] args) throws Exception, IllegalAccessException {










        Field[] declaredFields = YiewBean.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            if (declaredField.getType() == String.class) {

//                String value = (String) declaredField.get(obj);
//                if (value!=null)
//                {
//
//                }
                System.out.println(" if (obj."+name+" != null) {");
                System.out.println(" hashMap.put(\""+name+"\", obj."+name+");");
                System.out.println("}");

            }
            if (declaredField.getType() == int.class) {


                System.out.println(" if (obj."+name+" != 0) {");
                System.out.println(" hashMap.put(\""+name+"\", obj."+name+");");
                System.out.println("}");

            }
            if (declaredField.getType() == boolean.class) {


                System.out.println(" if (obj."+name+") {");
                System.out.println(" hashMap.put(\""+name+"\", obj."+name+");");
                System.out.println("}");

            }
            if (declaredField.getType() == ArrayList.class) {


                System.out.println(" if (obj."+name+" != null ) {");
                System.out.println(" hashMap.put(\""+name+"\", obj."+name+");");
                System.out.println("}");

            }

        }



    }
}
