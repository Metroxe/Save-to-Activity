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
HashMap<String, String> hashMap = saveToActivity.StartHashMap();
```
#### SaveInformation()
```sh
public void SaveInformation(HashMap<String, String> newHashMap) {
    hashMap = newHashMap;
}
```
#### LoadInformation()
```sh
public HashMap<String, String> LoadInformation() {
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
```sh
	dependencies {
	        compile 'com.github.metroxe:save-to-activity:c5eab45c6f'
	}
```
## Methods
Documentation Coming...

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
