package com.kaushik.myredmart.utility;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Kaushik on 18-04-2017.
 */

public class Util {
    public static final String IMG_URL = "http://media.redmart.com/newmedia/200p";
    public static final String ProductId = "productId";

    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
