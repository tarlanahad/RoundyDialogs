package com.tarlanahad.roundydialogs;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tarlanahad.roundydialog.RoundyDialog;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.progress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showProgressDialog();
            }
        });

        findViewById(R.id.list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showListDialog();
            }
        });

        findViewById(R.id.alert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

    }

    void showProgressDialog() {
        final RoundyDialog.ProgressType dialog = new RoundyDialog.ProgressType(this, R.style.AlertDialogCustom, this);
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
                dialog.dismiss();
            }
        });
        dialog.setPositiveButton("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    void showAlertDialog() {
        final RoundyDialog.AlertType dialog = new RoundyDialog.AlertType(this);
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
                dialog.dismiss();
            }
        });
        dialog.setPositiveButton("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    void showListDialog() {
        final RoundyDialog.ListType dialog = new RoundyDialog.ListType(this);
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

    }
}
