# RoundyDialogs
Highly customizable simple alert dialog implementation
## Screenshot

![GIF](https://github.com/tarlanahad/RoundyDialogs/blob/master/ezgif-1-1b55732ddd.gif)



## Requirements
* Android SDK 16+

## Usage
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
  
  ## How to use in your library project
To use the library, you just should know that all implementations *extend* Dialog class in this Library. That's why you can
use dialog methods as well.

Create your dialog just like this.
```
RoundyDialog.AlertType dialog = new RoundyDialog.AlertType(this);
dialog.show();
```

## Customization
Generally, you can customize all you see in the dialogs 💪
### ProgressDialog
```
        RoundyDialog.ProgressType dialog = new RoundyDialog.ProgressType(this, R.style.AlertDialogCustom, this);
        dialog.getDialogBackground().setRadius(20);
        dialog.getDialogBackground().getChildAt(0).setBackgroundResource(R.drawable.gradient_two);
        dialog.getTitleView().setFont("Lato-Bold.ttf");
        dialog.getTitleView().setTextColor(Color.WHITE);
        dialog.getMessageView().setFont("Lato-Regular.ttf");
        dialog.getMessageView().setTextColor(Color.WHITE);
        dialog.getTitleView().setText("Please, wait.");
        dialog.getMessageView().setText("File is downloading, it may take a while...");
        dialog.getNegativeButton().setTextColor(Color.WHITE);
        dialog.getPositiveButton().setTextColor(Color.WHITE);
        dialog.getNegativeButton().setFont("Lato-Bold.ttf");
        dialog.getPositiveButton().setFont("Lato-Bold.ttf");
        dialog.setNegativeButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        dialog.setPositiveButton("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        dialog.show();
```
###  AlertDialog
```
        RoundyDialog.AlertType dialog = new RoundyDialog.AlertType(this);
        dialog.getDialogBackground().setRadius(20);
        dialog.getDialogBackground().getChildAt(0).setBackgroundResource(R.drawable.gradient_three);
        dialog.getTitleView().setFont("Lato-Bold.ttf");
        dialog.getTitleView().setTextColor(Color.WHITE);
        dialog.getMessageView().setFont("Lato-Regular.ttf");
        dialog.getMessageView().setTextColor(Color.WHITE);
        dialog.getTitleView().setText("Warning!");
        dialog.getMessageView().setText("This alert dialog contains too much cool stuff.");
        dialog.getNegativeButton().setTextColor(Color.WHITE);
        dialog.getPositiveButton().setTextColor(Color.WHITE);
        dialog.getNegativeButton().setFont("Lato-Bold.ttf");
        dialog.getPositiveButton().setFont("Lato-Bold.ttf");
        dialog.setNegativeButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        dialog.setPositiveButton("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        dialog.show();
```
###  ListDialog
```
        RoundyDialog.ListType dialog = new RoundyDialog.ListType(this);
        dialog.getDialogBackground().getChildAt(0).setBackgroundResource(R.drawable.gradient);
        dialog.getTitleView().setText("Cool List Dialog");
        dialog.getDialogBackground().setRadius(20);
        dialog.getTitleView().setTextColor(Color.parseColor("#ffffff"));
        dialog.setNegativeButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.setPositiveButton("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.getNegativeButton().setTextColor(Color.WHITE);
        dialog.getPositiveButton().setTextColor(Color.WHITE);
        dialog.getNegativeButton().setFont("Lato-Bold.ttf");
        dialog.getPositiveButton().setFont("Lato-Bold.ttf");
        dialog.getTitleView().setFont("Lato-Bold.ttf");
        dialog.setItemsFont("Lato-Light.ttf");
        dialog.setItemColor(Color.WHITE);

        for (int i = 0; i < 9; i++)
            dialog.addItem("Lorem Ipsum ", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        dialog.show();
```
## Important
To use the fonts, add all of them to **assets/fonts/** and use like setFont("fontname.fontEnding")
