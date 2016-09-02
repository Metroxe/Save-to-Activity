package powroznik.christopher.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button singleStringExample = (Button) findViewById(R.id.singleStringExample);
        Button multiStringExample = (Button) findViewById(R.id.multiStringExample);

        if (singleStringExample != null) {
            singleStringExample.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SingleStringActivity.class);
                    startActivity(intent);
                }
            });
        }

        if (multiStringExample != null) {
            multiStringExample.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SingleStringActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

}
