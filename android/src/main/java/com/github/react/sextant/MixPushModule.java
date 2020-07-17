package com.github.react.sextant;


import android.content.Context;
import android.text.TextUtils;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.huawei.hms.aaid.HmsInstanceId;

public class MixPushModule extends ReactContextBaseJavaModule {

    public Context reactContext;
    private String pushtoken;

    public MixPushModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @ReactMethod
    private void getToken(final String app_id, final Promise promise) {
        // get token
        new Thread() {
            @Override
            public void run() {
                try {
                    pushtoken = HmsInstanceId.getInstance(getReactApplicationContext().getBaseContext()).getToken(app_id, "HCM");
                    if(!TextUtils.isEmpty(pushtoken)) {
                        promise.resolve(pushtoken);
                    }else {
                        promise.reject("");
                    }
                } catch (Exception e) {
                    promise.reject(e.getMessage());
                }
            }
        }.start();
    }

    @Override
    public String getName() {
        return "RNMixPush";
    }
}
