package com.fenfei.sandhookdemo;

import android.content.ContextWrapper;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.swift.sandhook.SandHook;
import com.swift.sandhook.annotation.HookClass;
import com.swift.sandhook.annotation.HookMethod;
import com.swift.sandhook.annotation.HookMethodBackup;
import com.swift.sandhook.annotation.MethodParams;
import com.swift.sandhook.annotation.ThisObject;
import com.swift.sandhook.wrapper.HookWrapper;

import java.lang.reflect.Method;

@HookClass(ContextWrapper.class)
public class MainActivityHooker {

    @HookMethodBackup("getPackageName")
    static Method onGetPackageNameBackup;

    @HookMethod("getPackageName")
    public static String onGetPackageName(@ThisObject ContextWrapper thiz) throws Throwable {
        String strPkg = (String)SandHook.callOriginByBackup(onGetPackageNameBackup, thiz);

        // /*
        if (thiz.getClass().equals(MainActivity.class)){
            Log.e("MainActivityHooker", thiz + "hooked getPackageName success rc= com.fenfei.demo");
            return "com.fenfei.demo";
        }else{
            return strPkg;
        }
        // */
    }
}