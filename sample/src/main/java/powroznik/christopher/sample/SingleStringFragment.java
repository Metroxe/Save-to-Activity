package powroznik.christopher.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import powroznik.christopher.save_to_activity.SaveToActivity;

public class SingleStringFragment extends Fragment {

    SaveToActivity saveToActivity = new SaveToActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.single_string_fragment, container, false);
        final EditText putKey = (EditText) rootView.findViewById(R.id.putKey);
        final EditText putString = (EditText) rootView.findViewById(R.id.putString);
        final EditText getKey = (EditText) rootView.findViewById(R.id.getKey);
        final TextView getString = (TextView) rootView.findViewById(R.id.getValue);
        Button putButton = (Button) rootView.findViewById(R.id.put);
        Button getButton = (Button) rootView.findViewById(R.id.get);
        Button closeFragment = (Button) rootView.findViewById(R.id.closeFragment);

        //put
        if (putButton != null && putKey != null && putString != null) {
            putButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = putKey.getText().toString();
                    String string = putString.getText().toString();
                    if (!key.isEmpty() && !string.isEmpty()) {
                        try {
                            saveToActivity.putSingleString(getActivity(), key, string);
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
                            getString.setText(saveToActivity.getSingleHashString(getActivity(), key));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        //Close Fragment
        if (closeFragment != null) {
            closeFragment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction().remove(SingleStringFragment.this).commit();
                }
            });
        }

        return rootView;
    }
}
