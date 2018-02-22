package com.tarlanahad.roundydialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.tarlanahad.roundydialog.Widgets.FontableTextView;

import java.util.ArrayList;

/**
 * Created by tarlan on 2/21/18.
 */ //private static float cornerRadius = 60;


public class RoundyDialog {

    public static class AlertType extends Dialog {

        private Activity activity;

        private CardView mCardView;

        private FontableTextView mTitle;

        public AlertType(@NonNull Context context, int themeResId, Activity activity) {
            super(context, themeResId);
            this.activity = activity;
            show();
            dismiss();
        }

        public AlertType(Activity activity) {
            super(activity);
            this.activity = this.activity;
            show();
            dismiss();
        }

        private FontableTextView mMessage;

        private FontableTextView mPositiveBtn;

        private FontableTextView mNegativeBtn;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            requestWindowFeature(1);

            setContentView(R.layout.alert_type);

            mCardView = findViewById(R.id.container);

            mTitle = findViewById(R.id.title);

            mMessage = findViewById(R.id.message);


            mPositiveBtn = findViewById(R.id.positiveButton);

            mNegativeBtn = findViewById(R.id.negativeButton);

        }


        public FontableTextView getMessageView() {
            return mMessage;
        }

        public FontableTextView getPositiveButton() {
            return mPositiveBtn;
        }

        public FontableTextView getNegativeButton() {
            return mNegativeBtn;
        }

        public void setPositiveButton(String text, View.OnClickListener listener) {
            mPositiveBtn.setVisibility(View.VISIBLE);
            mPositiveBtn.setText(text);
            mPositiveBtn.setOnClickListener(listener);
        }

        public void setNegativeButton(String text, View.OnClickListener listener) {
            mNegativeBtn.setVisibility(View.VISIBLE);
            mNegativeBtn.setText(text);
            mNegativeBtn.setOnClickListener(listener);
        }

        public CardView getDialogBackground() {
            return mCardView;
        }

        public FontableTextView getTitleView() {
            return mTitle;
        }
    }

    public static class ListType extends Dialog {

        public class Item {
            String Text;
            View.OnClickListener listener;

            public Item(String text, View.OnClickListener listener) {
                Text = text;
                this.listener = listener;
            }

            public String getText() {
                return Text;
            }

            public View.OnClickListener getListener() {
                return listener;
            }
        }

        private Activity activity;

        private CardView mCardView;

        private FontableTextView mTitle;

        private FontableTextView mPositiveBtn;

        private FontableTextView mNegativeBtn;

        private RecyclerView mList;

        public ListType(@NonNull Activity activity) {
            super(activity);
            this.activity = activity;
            show();
            dismiss();
        }

        public ListType(@NonNull Context context, int themeResId, Activity activity) {
            super(context, themeResId);
            this.activity = activity;
            show();
            dismiss();
        }

        private ArrayList<Item> Items = new ArrayList<>();

        String ItemFont = "";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            requestWindowFeature(1);
            setContentView(R.layout.list_type);

            mCardView = findViewById(R.id.container);

            mTitle = findViewById(R.id.title);

            mPositiveBtn = findViewById(R.id.positiveButton);

            mNegativeBtn = findViewById(R.id.negativeButton);

            mList = findViewById(R.id.list);

            mList.setLayoutManager(new LinearLayoutManager(activity));

            mList.setAdapter(new RoundyListAdapter());

            mCardView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    mCardView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int heightOfView = mCardView.getHeight(); //height is ready

                    //Toast.makeText(activity, "" + heightOfView, Toast.LENGTH_SHORT).show();

                    FrameLayout.LayoutParams cardViewParams = new FrameLayout.LayoutParams(Utils.getScreenDimensions(activity)[0] - (int) Utils.convertDpToPixel(80, activity), ViewGroup.LayoutParams.WRAP_CONTENT);
                    mCardView.setLayoutParams(cardViewParams);

                    if (heightOfView > Utils.getScreenDimensions(activity)[1] - Utils.convertDpToPixel(200, activity)) {
                        //mList.setLayoutParams(params);
                        ViewGroup.LayoutParams params = mList.getLayoutParams();
                        params.height = (int) (Utils.getScreenDimensions(activity)[1] - Utils.convertDpToPixel(300, activity));
                        mList.setLayoutParams(params);
                    }

                }
            });


        }

        public void addItem(String Text, View.OnClickListener listener) {
            Items.add(new Item(Text, listener));
        }

        private class RoundyListAdapter extends RecyclerView.Adapter<RoundyListAdapter.SurahsHolder> {

            public class SurahsHolder extends RecyclerView.ViewHolder {
                View Container;
                FontableTextView Text;

                public SurahsHolder(View view) {
                    super(view);
                    this.Text = (FontableTextView) view.findViewById(R.id.text);
                    this.Container = view.findViewById(R.id.container);
                }
            }

            public void onBindViewHolder(SurahsHolder holder, int position) {

                holder.Text.setFont(ItemFont);
                holder.Text.setText(Items.get(position).getText());
                holder.Text.setTextColor(itemColor);
                holder.Container.setOnClickListener(Items.get(position).getListener());

            }

            public int getItemCount() {
                return Items.size();
            }

            public SurahsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new SurahsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_type_item, parent, false));
            }
        }

        public RecyclerView getListView() {
            return mList;
        }

        public void setItemsFont(String fontName) {
            this.ItemFont = fontName;
        }

        public FontableTextView getPositiveButton() {
            return mPositiveBtn;
        }

        public FontableTextView getNegativeButton() {
            return mNegativeBtn;
        }

        public void setPositiveButton(String text, View.OnClickListener listener) {
            mPositiveBtn.setVisibility(View.VISIBLE);
            mPositiveBtn.setText(text);
            mPositiveBtn.setOnClickListener(listener);
        }

        public void setNegativeButton(String text, View.OnClickListener listener) {
            mNegativeBtn.setVisibility(View.VISIBLE);
            mNegativeBtn.setText(text);
            mNegativeBtn.setOnClickListener(listener);
        }

        public CardView getDialogBackground() {
            return mCardView;
        }

        public FontableTextView getTitleView() {
            return mTitle;
        }

        private int itemColor = Color.parseColor("#000000");
        public void setItemColor(int Color){
            itemColor = Color;
        }

    }


    public static class ProgressType extends Dialog {

        public ProgressType(@NonNull Context context, int themeResId, Activity activity) {
            super(context, themeResId);
            this.activity = activity;
            show();
            dismiss();
        }

        public ProgressType(@NonNull Activity activity) {
            super(activity);
            this.activity = activity;
            show();
            dismiss();
        }

        private Activity activity;

        private CardView mCardView;

        private FontableTextView mTitle;

        private FontableTextView mMessage;

        private FontableTextView mPositiveBtn;

        private FontableTextView mNegativeBtn;

        private ProgressBar progressBar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            requestWindowFeature(1);
            setContentView(R.layout.progress_type);



            mCardView = findViewById(R.id.container);

            mTitle = findViewById(R.id.title);

            mMessage = findViewById(R.id.message);

            progressBar = findViewById(R.id.progressBar);

            //TODO  progressBar.getProgressDrawable().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);

            mPositiveBtn = findViewById(R.id.positiveButton);

            mNegativeBtn = findViewById(R.id.negativeButton);

            FrameLayout.LayoutParams cardViewParams = new FrameLayout.LayoutParams(Utils.getScreenDimensions(activity)[0] - (int) Utils.convertDpToPixel(80, activity), ViewGroup.LayoutParams.WRAP_CONTENT);

            mCardView.setLayoutParams(cardViewParams);

        }

        public FontableTextView getPositiveButton() {
            return mPositiveBtn;
        }

        public FontableTextView getNegativeButton() {
            return mNegativeBtn;
        }

        public void setPositiveButton(String text, View.OnClickListener listener) {
            mPositiveBtn.setVisibility(View.VISIBLE);
            mPositiveBtn.setText(text);
            mPositiveBtn.setOnClickListener(listener);
        }

        public void setNegativeButton(String text, View.OnClickListener listener) {
            mNegativeBtn.setVisibility(View.VISIBLE);
            mNegativeBtn.setText(text);
            mNegativeBtn.setOnClickListener(listener);
        }

        public CardView getDialogBackground() {
            return mCardView;
        }

        public FontableTextView getTitleView() {
            return mTitle;
        }

        public FontableTextView getMessageView() {
            return mMessage;
        }

        public ProgressBar getProgressBar() {
            return progressBar;
        }

        //TODO public void setProgressBarColor(int Color){
        //     progressBar.getProgressDrawable().setColorFilter(Color, PorterDuff.Mode.SRC_IN);
        // }


    }

}
