package com.example;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import java.lang.reflect.Type;

public class MyClass {



    public static void main(String[] args)
    {


        System.out.println("s");
        ExclusionStrategy myExclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(FieldAttributes fa) {
                Type declaredType = fa.getDeclaredType();

                System.out.println(declaredType);

                return fa.getName().startsWith("_");
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {

                return false;
            }

        };

        YiewBean obj  = new YiewBean();
        obj.view ="aview";

//        Gson gson = new GsonBuilder()

//                .setExclusionStrategies(myExclusionStrategy) // <---
//                .create();
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(YiewBean.class, new YiewBeanAda())
//                .create();
//
//        String json = gson.toJson(obj);
//
//        System.out.println(json);

        ObjectMapper mapper = new  ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        SimpleBeanPropertyFilter width = SimpleBeanPropertyFilter.filterOutAllExcept("width");
//        width.serializeAsField();
//        FilterProvider filters1 = new SimpleFilterProvider().addFilter("myFilter1", width);
        FilterProvider filters2 = new SimpleFilterProvider().addFilter("filters2", new PropertyFilter(){

            @Override
            public void serializeAsField(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyWriter propertyWriter) throws Exception {
                System.out.println(((YiewBean)o).view);

                if (propertyWriter.getName() == "layout_alignParentTop")
                {
                    propertyWriter.serializeAsField(o, jsonGenerator, serializerProvider);
                }
                System.out.println(propertyWriter.getName());


            }

            @Override
            public void serializeAsElement(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, PropertyWriter propertyWriter) throws Exception {
                System.out.println(((YiewBean)o).view);
            }

            @Override
            public void depositSchemaProperty(PropertyWriter propertyWriter, ObjectNode objectNode, SerializerProvider serializerProvider) throws JsonMappingException {
                System.out.println(objectNode);
            }

            @Override
            public void depositSchemaProperty(PropertyWriter propertyWriter, JsonObjectFormatVisitor jsonObjectFormatVisitor, SerializerProvider serializerProvider) throws JsonMappingException {

            }
        });
//
//        FilterProvider filter3 = new SimpleFilterProvider().addFilter("myFilter3", new BeanPropertyFilter(){
//            @Override
//            public void serializeAsField(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, BeanPropertyWriter beanPropertyWriter) throws Exception {
//
//            }
//
//            @Override
//            public void depositSchemaProperty(BeanPropertyWriter beanPropertyWriter, ObjectNode objectNode, SerializerProvider serializerProvider) throws JsonMappingException {
//
//            }
//
//            @Override
//            public void depositSchemaProperty(BeanPropertyWriter beanPropertyWriter, JsonObjectFormatVisitor jsonObjectFormatVisitor, SerializerProvider serializerProvider) throws JsonMappingException {
//
//            }
//        });


//        mapper.setFilterProvider(filters2);
        try {
            String json2 = mapper.writeValueAsString(obj);
            System.out.println(json2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
