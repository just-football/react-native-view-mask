package com.reactlibrary;

import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.util.Log;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

public class RNViewMaskModule extends ViewGroupManager<RNViewMask> {

    private ReactContext reactContext;

    public RNViewMaskModule(ReactContext context) {
        this.reactContext = context;
    }

    @Override
    public String getName() {
        return "RNViewMask";
    }

    @Override
    protected RNViewMask createViewInstance(ThemedReactContext reactContext) {
        return new RNViewMask(reactContext);
    }
}