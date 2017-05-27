package com.example.mvplibrary;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatDialog;

/**
 * @author mayong
 * @function IDialog
 * @time 2016/11/11 10:40
 **/
public class IDialog extends AppCompatDialog {
    public IDialog(Context context) {
        super(context);
    }

    public IDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected IDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


}
