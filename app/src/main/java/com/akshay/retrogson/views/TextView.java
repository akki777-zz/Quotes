package com.akshay.retrogson.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.akshay.retrogson.R;
import com.akshay.retrogson.RetroApp;
import com.akshay.retrogson.utils.Constants;

/**
 * Created by akshaymahajan on 08/08/17.
 */

public class TextView extends AppCompatTextView {
    public TextView(Context context) {
        super(context);
    }

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TextView);
        String typeface = array.getString(R.styleable.TextView_typeface);

        switch (typeface) {
            case Constants.Fonts.CAKE:
                this.setTypeface(RetroApp.CAKE);
                break;
            case Constants.Fonts.INDIE:
                this.setTypeface(RetroApp.INDIE);
                break;
        }
        array.recycle();
    }
}
