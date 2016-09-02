package powroznik.christopher.sample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import powroznik.christopher.save_to_activity.SaveToActivity;

public class MultiStringFragment extends Fragment {

    SaveToActivity saveToActivity = new SaveToActivity();

    List<String> putKeys = new ArrayList<>();
    List<String> putStrings = new ArrayList<>();
    List<String> getKeys = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.multi_string_fragment, container, false);
        final EditText putKey = (EditText) rootView.findViewById(R.id.putKey);
        final EditText putString = (EditText) rootView.findViewById(R.id.putString);
        final EditText getKey = (EditText) rootView.findViewById(R.id.getKey);
        final TextView getString = (TextView) rootView.findViewById(R.id.getValue);
        final TextView putArray = (TextView) rootView.findViewById(R.id.putArray);
        final TextView getArray = (TextView) rootView.findViewById(R.id.getArray);
        Button putButton = (Button) rootView.findViewById(R.id.put);
        Button getButton = (Button) rootView.findViewById(R.id.get);
        Button closeFragment = (Button) rootView.findViewById(R.id.closeFragment);
        Button putAddToArray = (Button) rootView.findViewById(R.id.putAddToArray);
        Button getAddToArray = (Button) rootView.findViewById(R.id.getAddToArray);

        //Put add to array
        if (putAddToArray != null && putKey != null && putString != null && putArray != null) {
            putAddToArray.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = putKey.getText().toString();
                    String string = putString.getText().toString();

                    if (!key.isEmpty() && !string.isEmpty()) {

                        String display = "";

                        putKeys.add(key);
                        putStrings.add(string);

                        //Display for UX
                        for (int i = 0; i < putKeys.size(); i++) {
                            display += putKeys.get(i) + ": " + putStrings.get(i) + " \n";
                        }

                        putArray.setText(display);

                    }

                }
            });
        }

        //put
        if (putButton != null && putArray != null) {
            putButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //convert to String[]
                    String[] keysArr = putKeys.toArray(new String[putKeys.size()]);
                    String[] stringsArr = putStrings.toArray(new String[putStrings.size()]);
                    try {
                        saveToActivity.putStrings(getActivity(), keysArr, stringsArr);

                        putKeys.clear();
                        putStrings.clear();
                        putArray.setText("");

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        //Put add to array
        if (getAddToArray != null && getKey != null && getArray != null) {
            getAddToArray.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = getKey.getText().toString();

                    if (!key.isEmpty()) {

                        String display = "";

                        getKeys.add(key);

                        //Display for UX
                        for (int i = 0; i < getKeys.size(); i++) {
                            display += getKeys.get(i) + " \n";
                        }

                        getArray.setText(display);

                    }

                }
            });
        }

        //get
        if (getButton != null && getArray != null && getString != null) {
            getButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //convert to String[]
                    String[] keysArr = getKeys.toArray(new String[getKeys.size()]);

                    try {
                        String[] result = saveToActivity.getStrings(getActivity(), keysArr);

                        String display = "";

                        for (String s : result) {
                            display += s + " \n";
                        }

                        getString.setText(display);

                        getKeys.clear();
                        getArray.setText("");

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

        //Close Fragment
        if (closeFragment != null) {
            closeFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction().remove(MultiStringFragment.this).commit();
                }
            });
        }

        return rootView;
    }

}
