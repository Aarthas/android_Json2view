package weexact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.avocarrot.json2view.sample.R;

public class WeexActivity1 extends AppCompatActivity {


    private WeexActivity1 context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;


        setContentView(R.layout.flexlayout);

    }





}
