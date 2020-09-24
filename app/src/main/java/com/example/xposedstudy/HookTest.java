package com.example.xposedstudy;

import android.widget.Toast;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 创 建 人： PeaceJay_Home
 * 创建时间： 2020/9/24 0024
 * 类 描 述：
 */

public class HookTest implements IXposedHookLoadPackage {

    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (loadPackageParam.packageName.equals("com.example.xposedstudy")) {

            XposedBridge.log(" has Hooked!");
            Class clazz = loadPackageParam.classLoader.loadClass(
                    "com.example.xposedstudy.MainActivity");
            XposedHelpers.findAndHookMethod(clazz, "getTTAd", new XC_MethodHook() {
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                    //XposedBridge.log(" has Hooked!");
                }

                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult("拦截广告成功");
                }
            });

        }

    }

}
