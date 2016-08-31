package powroznik.christopher.save_to_activity;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class SaveToActivity {

    //Starts the Hash Map in the activity
    //Users can skip this if a HashMap is already created
    public HashMap<String, String> StartHashMap() {
        return new HashMap<>();
    }

    //Loads the Hashmap privately to all other methods in the Class
    private static HashMap<String, String> ReceiveHashMap(Activity activity) throws ClassNotFoundException {
        java.lang.reflect.Method loadInformation;
        try {
            loadInformation = activity.getClass().getMethod("LoadInformation");
            try {
                return (HashMap<String, String>) loadInformation.invoke(activity);

            } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (SecurityException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        Log.wtf("RETURN", "NULL HASHMAP");
        return new HashMap<>();
    }

    //Pushes the HashMap Privately Back to the Activity
    private static void PushHashMap(Activity activity, HashMap<String, String> hashMap) throws ClassNotFoundException {
        java.lang.reflect.Method saveInformation;
        try {
            saveInformation = activity.getClass().getMethod("SaveInformation", HashMap.class);
            try {
                saveInformation.invoke(activity, hashMap);

            } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (SecurityException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * Put Methods
     */
    public void PutSingleString(Activity activity, String key, String string) throws ClassNotFoundException {
        HashMap<String, String> hashMap = ReceiveHashMap(activity);
        hashMap.put(key, string);
        PushHashMap(activity, hashMap);
    }

    public void PutStrings(Activity activity, String[] keys, String[] strings) throws ClassNotFoundException {
        HashMap<String, String> hashMap = ReceiveHashMap(activity);
        if (keys.length == strings.length) {
            Integer length = keys.length;

            for (int i = 0; i <= length - 1; i++) {
                hashMap.put(keys[i], strings[i]);
            }

            PushHashMap(activity, hashMap);
        }
    }

    //Performs same function as the private method, but for debugging reasons the two primary
    //function methods are kept as private
    public void ReplaceHashMap(Activity activity,HashMap<String, String> hashMap) throws ClassNotFoundException {
        PushHashMap(activity, hashMap);
    }


    /**
     * Get Methods
     */
    public String GetSingleHashString(Activity activity, String key) throws ClassNotFoundException {
        HashMap<String, String> hashMap = ReceiveHashMap(activity);
        return hashMap.get(key);
    }

    //Performs same function as the private method, but for debugging reasons the two primary
    //function methods are kept as private
    public HashMap<String, String> GetHashMap(Activity activity) throws ClassNotFoundException {
        return ReceiveHashMap(activity);
    }
}
