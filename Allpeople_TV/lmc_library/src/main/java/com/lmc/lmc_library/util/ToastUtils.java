package com.lmc.lmc_library.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：Created by ${李泰亲} on 2017/1/13 10:34.
 * 邮箱：15711299361@163.com
 * 模块：非阻塞试显示Toast,防止出现连续点击Toast时的显示问题
 */

public class ToastUtils {
    private static Toast mToast;

    public static void showToast(Context context, CharSequence text, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }

    public static void showToast(Context context, CharSequence text) {
        showToast(context, text, Toast.LENGTH_SHORT);
    }
}
