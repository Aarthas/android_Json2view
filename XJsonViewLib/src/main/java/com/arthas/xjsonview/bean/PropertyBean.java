package com.arthas.xjsonview.bean;

public class PropertyBean {


    public String name;
    public String type;
    public String value;

    public Class getClassType() {
        switch (type) {
            case "int":
                return int.class;

            case "long":
                return long.class;
            case "short":
                return short.class;
            case "float":
                return float.class;
            case "double":
                return double.class;
            case "boolean":
                return boolean.class;

            case "Integer":
                return Integer.class;

            case "Long":
                return Long.class;
            case "Short":
                return Short.class;
            case "Float":
                return Float.class;

            case "Double":
                return Double.class;

            case "Boolean":
                return Boolean.class;


            case "String":
                return String.class;
            case "Object":
                return Object.class;

            case "char":
                return char.class;
            case "Byte":
                return Byte.class;
            case "byte":
                return byte.class;

            default:
//                Log.d("syb", "Class.forName  =" + type);
                Class<?> aClass = null;
                try {
                    aClass = Class.forName(type);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return aClass;
        }

    }



    public Object getValueClassType(Class classType) {
        if(classType == int.class){
            if(value.equals("")){
                return 0;
            }
            return Integer.parseInt(value);
        }else if(classType == short.class){
            if(value.equals("")){
                return 0;
            }
            return Short.parseShort(value);
        }else if(classType == byte.class){
            if(value.equals("")){
                return 0;
            }
            return Byte.parseByte(value);
        }else if(classType == double.class){
            if(value.equals("")){
                return 0;
            }
            return Double.parseDouble(value);
        }else if(classType == boolean.class){
            if(value.equals("")){
                return false;
            }
            return Boolean.parseBoolean(value);
        }else if(classType == float.class){
            if(value.equals("")){
                return 0;
            }
            return Float.parseFloat(value);
        }else if(classType == long.class){
            if(value.equals("")){
                return 0;
            }
            return Long.parseLong(value);
        }else {
            return classType.cast(value);
        }
    }
}