# Save To Activity

This library is an easy to use series of commands to interact with a hashmap across multiple fragments attached to any running activity. This also allows users to pass information between fragments, without a transaction or bundle.

**Please Note this solution for a data structure is very inefficient compared to using bundles, but this library allows users with an over whelming amounts of fragments to manage semi-global variables easily, rather than writing bundle logic for often overly complicated fragment transactions**

## Supported Data Types

- Strings
- More Coming...

## Implementation

In the activity you wish to store your variables in, please incorporate this line and these classes...

#### Start the HashMap
```sh
SaveToActivity saveToActivity = new SaveToActivity();
HashMap<String, String> hashMap = saveToActivity.startHashMap();
```
#### saveInformation()
```sh
public void saveInformation(HashMap<String, String> newHashMap) {
    hashMap = newHashMap;
}
```
#### loadInformation()
```sh
public HashMap<String, String> loadInformation() {
    return hashMap;
```

## Integrate with Gradle
#### Add this in your root build.gradle
```sh
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
#### Add the Dependency
Call from Activity
```sh
	dependencies {
	        compile 'com.github.metroxe:save-to-activity:c5eab45c6f'
	}
```
## Methods
For the methods its necessary to send in the activity. If the class is being called from the activity, then simply send in...
```sh
ActivityName.this
```
but, if being called from a fragment use
```sh
getActivity()
```
all methods assume the class has already called this line
```sh
SaveToActivity saveToActivity = new SaveToActivity();
```
### Put Methods
#### putSingleString
Puts a single string into the activity.
```sh
saveToActivity.putSingleString(Activity, Key, String)
```
#### putStrings
Puts a String[] of strings into the activity. The strings will be added individually, so using putSingleString will work for any of these values. This class will not work unless there are an equal amount of keys and strings. Keys and strings will be paired accoridng to their index in the array (e.g. the key at index 3, will be paired with the string at index 3).
```sh
saveToActivity.getStrings(Activity, Keys, Strings)
```
### Get Methods
If the Keys don't exist when getting called, nothing will be returned.
#### getSingleString
Gets a String[] from the activity. Strings are returned in the same index of the keys that were sent in.
```sh
saveToActivity.getSingleHashString(Activity, Key)

Returns String
```
#### getStrings
Gets a String[] from the activity. Strings are returned in the same index of the keys that were sent in.
```sh
saveToActivity.getStrings(Activity, Keys)

Returns String[]
```

## License
```
Copyright 2016 Christopher Powroznik

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
