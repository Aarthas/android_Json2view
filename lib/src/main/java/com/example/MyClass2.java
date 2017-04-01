package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class MyClass2 {


    public static void main(String[] args) throws Exception, IllegalAccessException {


        System.out.println("s");



        Yiew obj = new Yiew();
        obj.view = "aview";
        obj.width = Yiew.MATCH;
        obj.weight = 1;
        obj.layout_alignParentBottom = true;
        HashMap map = YiViewCodeHelp.toMap(obj);


//

        ObjectMapper mapper = new ObjectMapper();
        String json2 = mapper.writeValueAsString(map);
        System.out.println(json2);
    }
}
