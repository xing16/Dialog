package com.xing.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by Administrator on 2016/6/28.
 */
public class CustomDialog extends Dialog {

    private Button cancelBtn, okBtn;

    public CustomDialog(Context context) {
        this(context, R.style.CustomDialog);
    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
        init();
    }

    private void init() {
        View view = View.inflate(getContext(), R.layout.layout_dialog, null);

        super.setContentView(view);

    }


    @Override
    public void show() {
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams attributes = dialogWindow.getAttributes();
        int width = attributes.width = (int) (getScreenWidth() * 7 / 8);
        attributes.height = (int) (width * 3.0 / 5);
        dialogWindow.setAttributes(attributes);
        super.show();
    }

    private int getScreenWidth() {
        WindowManager windowManager = getWindow().getWindowManager();
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

}
