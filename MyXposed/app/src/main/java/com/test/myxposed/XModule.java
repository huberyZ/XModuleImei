package com.test.myxposed;


import android.telephony.TelephonyManager;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XModule implements IXposedHookLoadPackage {

        @Override
        public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {

            XposedHelpers.findAndHookMethod(TelephonyManager.class.getName(), loadPackageParam.classLoader, "getDeviceId", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("hook ---getDeviceId***after " + param.getResult());
                    param.setResult("11111111111111");

                }
            });

    }

}
