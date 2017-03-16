package com.example.fitit_v1;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by nilofar on 3/5/2017.
 */
public class ActivityLauncher  extends WebViewClient {

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        // TODO Auto-generated method stub
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public boolean shouldOverrideUrlLoading (WebView view, String url) {
        if ("custom://launchActivity?id=1".equals(url)) {
            // TODO Launch your activity
            view.getParent();
            System.out.println("hale");
            return true;
        }
        // Let the WebView handle the url
        return false;
    }
}