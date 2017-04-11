package flex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.avocarrot.json2view.sample.R;

public class FlexActivity extends AppCompatActivity {


    private FlexActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        context = this;


        setContentView(R.layout.flexlayout);

    }





}
