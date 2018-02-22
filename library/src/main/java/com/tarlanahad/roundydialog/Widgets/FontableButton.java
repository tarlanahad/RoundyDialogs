package com.tarlanahad.roundydialog.Widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.tarlanahad.roundydialog.R;


public class FontableButton extends AppCompatButton {
    public FontableButton(Context context) {
        super(context);
    }

    public FontableButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontableButton, 0, 0);
        try {
            setFont(ta.getString(R.styleable.FontableButton_btn_font));
        } finally {
            ta.recycle();
        }
    }

    void setFont(String FontName) {
        try {
            setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/" + FontName));
        } catch (Exception e) {
        }
    }

    public FontableButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}