package powroznik.christopher.sample;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import powroznik.christopher.save_to_activity.SaveToActivity;

public class MultiStringActivity extends AppCompatActivity {

    SaveToActivity saveToActivity = new SaveToActivity();
    HashMap<String, String> hashMap = saveToActivity.startHashMap();

    public void saveinformation(HashMap<String, String> newHashMap) {
        hashMap = newHashMap;
    }

    public HashMap<String, String> loadinformation() {
        return hashMap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_string_activity);
        final EditText putKey = (EditText) findViewById(R.id.putKey);
        final EditText putString = (EditText) findViewById(R.id.putString);
        final EditText getKey = (EditText) findViewById(R.id.getKey);
        final TextView getString = (TextView) findViewById(R.id.getValue);
        Button putButton = (Button) findViewById(R.id.put);
        Button getButton = (Button) findViewById(R.id.get);
        Button openFragment = (Button) findViewById(R.id.openFragment);

        //put
        if (putButton != null && putKey != null && putString != null) {
            putButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = putKey.getText().toString();
                    String string = putString.getText().toString();
                    if (!key.isEmpty() && !string.isEmpty()) {
                        try {
                            saveToActivity.putSingleString(MultiStringActivity.this, key, string);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        //get
        if (getButton != null && getKey != null && getString != null) {
            getButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = getKey.getText().toString();
                    if (!key.isEmpty()) {
                        try {
                            getString.setText(saveToActivity.getSingleHashString(MultiStringActivity.this, key));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        //Open Fragment
        if (openFragment != null) {
            openFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SingleStringFragment singleStringFragment = new SingleStringFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.parent, singleStringFragment);
                    fragmentTransaction.commit();
                    Log.d("TEST", "Run");
                }
            });
        }

    }
}
