package com.yi.generate;

import com.yi.bean.YiewBean;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ServerCodeGenerate {


    public static void main(String[] args) throws Exception, IllegalAccessException {


        File file = new File("lib/complaintDetail.json");
//        file.createNewFile();

        String s = readFile(file);
        System.out.println(s);
        Gson gson = new Gson();

        YiewBean yiewBean = gson.fromJson(s, YiewBean.class);
//        YiewEngine.createmyiew(yiewBean)


        create(null,"yiew_1", yiewBean);

//        int count = 0;
//        if (yiewBean!= null)
//        {
//            String  yiewName = "yiew";
//            System.out.println(" Yiew "+yiewName+" = new Yiew();");
//            Field[] declaredFields = YiewBean.class.getDeclaredFields();
//            for (Field declaredField : declaredFields) {
//
//            }
//
//            yiew.view = "verticalLayout";
//
//        }


    }

    private static void create(String parentName,String yiewName, YiewBean yiewBean) throws IllegalAccessException {


        System.out.println(" Yiew " + yiewName + " = new Yiew();");
        if (parentName != null) {
            System.out.println(" " + parentName + ".addChild(" + yiewName + ");");
        }

        Field[] declaredFields = YiewBean.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            if (declaredField.getType() == String.class) {

                String value = (String) declaredField.get(yiewBean);
                if (value != null) {
                    System.out.println("" + yiewName + "." + name + " = \"" + value + "\";");
                }


            }
            if (declaredField.getType() == int.class) {


                int value = Integer.parseInt(declaredField.get(yiewBean).toString());
                if (value != 0) {
                    System.out.println("" + yiewName + "." + name + " = " + value + ";");
                }

            }
            if (declaredField.getType() == boolean.class) {

//                System.out.println(name);
//                System.out.println(declaredField.get(yiewBean).toString());
                boolean value = Boolean.valueOf(declaredField.get(yiewBean).toString());
                if (value) {
                    System.out.println("" + yiewName + "." + name + " = " + value + ";");
                }
            }


        }

        ArrayList<YiewBean> child = yiewBean.child;
//                    System.out.println(child);
        if (child != null) {
            for (int i = 0; i < child.size(); i++) {

                YiewBean yiewBean1 = child.get(i);


                System.out.println("\n");
                String childName = yiewName + "_" + (i + 1);
                create(yiewName,childName, yiewBean1);


            }


        }
    }


    private static String readFile(File fileName) {
        StringBuilder returnString = new StringBuilder();
        InputStream fileInputStream = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fileInputStream = new FileInputStream(fileName);

            isr = new InputStreamReader(fileInputStream);
            input = new BufferedReader(isr);
            String line;
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null) isr.close();
                if (fileInputStream != null) fileInputStream.close();
                if (input != null) input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }
}
