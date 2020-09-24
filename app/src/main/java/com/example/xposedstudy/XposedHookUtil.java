package com.example.xposedstudy;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * 创 建 人： PeaceJay_Home
 * 创建时间： 2020/9/23 0023
 * 类 描 述：
 */
public class XposedHookUtil implements IXposedHookLoadPackage {
    String class_name = "com.example.xposedstudy.MainActivity";
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {

        Class clazz = loadPackageParam.classLoader.loadClass(class_name);
        XposedHelpers.findAndHookMethod(clazz, "getTTAd", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                return "广告被拦截了";
            }
        });
    }
}

