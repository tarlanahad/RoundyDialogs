# RoundyDialogs
_______________________________
### Screenshots here
_______________________________
### Requirements
__________________________
* Android SDK 16+

### Usage
___________________________
Add to your root build.gradle:

```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
Add the dependency:

  ```
  	dependencies {
	        compile 'com.github.tarlanahad:RoundyDialogs:1.0'
	}
  ```
  ### How to use in your library project
  _____________
To use the library you just should know that all implementations extends Dialog class in this Library. That's why you can use dialog methods in this library as well.

Create your dialog just like this.
```
RoundyDialog.AlertType dialog = new RoundyDialog.AlertType(this);
```

### Customization
Generally, you can customize all you see in the dialogs 💪
