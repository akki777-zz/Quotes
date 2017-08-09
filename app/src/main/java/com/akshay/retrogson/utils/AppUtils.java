package com.akshay.retrogson.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.akshay.retrogson.R;

/**
 * Created by akshaymahajan on 09/08/17.
 */

public class AppUtils {
    public static void shareQuote(Context context, String quoteText, String quoteAuthor){
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        StringBuilder shareBody = new StringBuilder(quoteText);
        if (!TextUtils.isEmpty(quoteAuthor)) {
            shareBody.append("\n\n");
            shareBody.append(quoteAuthor);
        }
        shareBody.append("\n\n");
        shareBody.append(context.getResources().getString(R.string.app_share_text));
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody.toString());
        context.startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }

    public static ProgressDialog showProgressDialog(Context context, String title) {
        ProgressDialog progress = new ProgressDialog(context);
        progress.setMessage("Please Wait");
        progress.setTitle(title);
        progress.setCanceledOnTouchOutside(false);
        progress.show();
        return progress;
    }
}
