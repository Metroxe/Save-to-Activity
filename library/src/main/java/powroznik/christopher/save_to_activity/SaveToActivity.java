package powroznik.christopher.save_to_activity;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class SaveToActivity {

    //Starts the Hash Map in the activity
    //Users can skip this if a HashMap is already created
    public HashMap<String, String> startHashMap() {
        return new HashMap<>();
    }

    //Loads the Hashmap privately to all other methods in the Class
    private static HashMap<String, String> receiveHashMap(Activity activity) throws ClassNotFoundException {
        java.lang.reflect.Method loadInformation;
        try {
            loadInformation = activity.getClass().getMethod("loadInformation");
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
    private static void pushHashMap(Activity activity, HashMap<String, String> hashMap) throws ClassNotFoundException {
        java.lang.reflect.Method saveInformation;
        try {
            saveInformation = activity.getClass().getMethod("saveInformation", HashMap.class);
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
    public void putSingleString(Activity activity, String key, String string) throws ClassNotFoundException {
        HashMap<String, String> hashMap = receiveHashMap(activity);
        hashMap.put(key, string);
        pushHashMap(activity, hashMap);
    }

    public void putStrings(Activity activity, String[] keys, String[] strings) throws ClassNotFoundException {
        HashMap<String, String> hashMap = receiveHashMap(activity);
        if (keys.length == strings.length) {
            Integer length = keys.length;

            for (int i = 0; i <= length - 1; i++) {
                hashMap.put(keys[i], strings[i]);
            }

            pushHashMap(activity, hashMap);
        }
    }

    //Performs same function as the private method, but for debugging reasons the two primary
    //function methods are kept as private
    public void replaceHashMap(Activity activity, HashMap<String, String> hashMap) throws ClassNotFoundException {
        pushHashMap(activity, hashMap);
    }


    /**
     * Get Methods
     */
    public String getSingleHashString(Activity activity, String key) throws ClassNotFoundException {
        HashMap<String, String> hashMap = receiveHashMap(activity);
        return hashMap.get(key);
    }

    //Performs same function as the private method, but for debugging reasons the two primary
    //function methods are kept as private
    public HashMap<String, String> getHashMap(Activity activity) throws ClassNotFoundException {
        return receiveHashMap(activity);
    }
}
