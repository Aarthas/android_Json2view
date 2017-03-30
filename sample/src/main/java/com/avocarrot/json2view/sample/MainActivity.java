package com.avocarrot.json2view.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.arthas.yiew.ImageAdapter;
import com.arthas.yiew.Yiew;
import com.arthas.yiew.YiewConfig;
import com.arthas.yiew.YiewEngine;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        UiUtil.application = getApplicationContext();
        JSONObject jsonObject;
//        String json = readFile("textview.json", this);
        String json = readFile("imageview.json", this);
        try {

//            int i = UiUtil.generateViewId();
//            Log.d("syb","i="+i);
//
//             i = UiUtil.generateViewId();
//            Log.d("syb","i="+i);
//
//             i = UiUtil.generateViewId();
//            Log.d("syb","i="+i);

            jsonObject = new JSONObject(json);


        } catch (JSONException je) {
            je.printStackTrace();
            jsonObject = null;
        }
        ImageAdapter imageAdapter = new ImageAdapter() {

            @Override
            public void display(ImageView view, String src, Yiew yiew) {
                Glide.with(view.getContext()).
                        load(yiew.src).
                        crossFade(400)
                        .into(view);
            }
        };

        YiewConfig.setImageAdapter(imageAdapter);
        Gson gson = new Gson();
        Yiew pane = gson.fromJson(json, Yiew.class);
        Log.d("syb","pane"+pane);
        View createmyiew = YiewEngine.createmyiew(this, null, pane);
        createmyiew.setLayoutParams(new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
        setContentView(createmyiew);
//        View viewById = createmyiew.findViewById(1000);
//        Object tag = viewById.getTag();
//        Log.d("syb","tag"+tag);
//        View viewById = createmyiew.findViewById(1001);
//        Log.d("syb","viewById"+((TextView)viewById).getText().toString());
//        if (viewById != null) {
//            viewById.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("syb","viewById1001"+((TextView)v).getText().toString());
//                }
//            });
//        }
//
//        View viewById1002 = createmyiew.findViewById(1002);
//        Log.d("syb","viewById1002"+((TextView)viewById1002).getText().toString());
//        if (viewById1002 != null) {
//            viewById1002.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("syb","viewById1002"+((TextView)v).getText().toString());
//                }
//            });
//        }


//        setContentView(R.layout.aa);
        if (jsonObject != null) {

            /* create dynamic view and return the view with the holder class attached as tag */
//            View sampleView = DynamicView.createView(this, jsonObject, SampleViewHolder.class);
//            /* get the view with id "testClick" and attach the onClickListener */
//            ((SampleViewHolder) sampleView.getTag()).clickableView.setOnClickListener(this);
//
//            /* add Layout Parameters in just created view and set as the contentView of the activity */
//            sampleView.setLayoutParams(new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT));
//            setContentView(R.layout.aa);

        } else {
            Log.e("Json2View", "Could not load valid json file");
        }

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onClick(View v) {
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.avocarrot.com/")));
    }

    /**
     * Helper function to load file from assets
     */
    private String readFile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets().open(fileName);
            isr = new InputStreamReader(fIn);
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
                if (fIn != null) fIn.close();
                if (input != null) input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }


    /**
     * Holder class that keep UI Component from the Dynamic View
     */
//    static public class SampleViewHolder {
//        @DynamicViewId(id = "testClick")
//        public View clickableView;
//
//        public SampleViewHolder() {
//        }
//    }

    public void myClick(){

    }

    public void myClick2(){
        Log.d("syb","myClick2");
    }
}
