package com.github.bkhezry.persianner.util;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import com.github.bkhezry.persianner.R;

public class AppUtil {
  private static final Long timeDiff = 1800000L;

  public static boolean isTokenExpire(Long storeTimestamp) {
    return System.currentTimeMillis() - storeTimestamp > timeDiff;
  }

  public static Dialog getLoadingDialog(Context context) {
    Dialog dialog = new Dialog(context);
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    dialog.setContentView(R.layout.dialog_full_screen_loading);
    dialog.setCancelable(false);
    WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
    lp.copyFrom(dialog.getWindow().getAttributes());
    lp.width = WindowManager.LayoutParams.MATCH_PARENT;
    lp.height = WindowManager.LayoutParams.MATCH_PARENT;
    dialog.getWindow().setAttributes(lp);
    return dialog;
  }
}