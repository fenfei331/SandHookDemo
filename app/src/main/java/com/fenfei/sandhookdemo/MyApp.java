package com.fenfei.sandhookdemo;

import android.app.Application;
import com.swift.sandhook.SandHook;
import com.swift.sandhook.SandHookConfig;
import com.swift.sandhook.wrapper.HookErrorException;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            SandHook.addHookClass(
                    MainActivityHooker.class);
        } catch (HookErrorException e) {
            e.printStackTrace();
        }

    }
}