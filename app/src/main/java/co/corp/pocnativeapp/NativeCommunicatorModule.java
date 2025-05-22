package co.corp.pocnativeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import java.util.Map;

public class NativeCommunicatorModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext context;

    public NativeCommunicatorModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    @NonNull
    @Override
    public String getName() {
        return "NativeCommunicator";
    }

    @ReactMethod
    public void sendBackToNative(String message, Callback callback) {
        Toast.makeText(context, "Desde RN: " + message, Toast.LENGTH_LONG).show();
        callback.invoke("Mensaje recibido correctamente en nativo");
    }

    @ReactMethod
    public void finishActivity() {
        if (getCurrentActivity() != null) {
            getCurrentActivity().finish(); // ✅ cerrar como si se presionara "atrás"
        }
    }

    @ReactMethod
    public void navigateToBundle(String bundleName, String moduleName, ReadableMap props) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Intent intent = new Intent(currentActivity, PoCModuleActivity.class);
            intent.putExtra("bundleName", bundleName);
            intent.putExtra("moduleName", moduleName);

            Bundle propsBundle = Arguments.toBundle(props); // ✅ Usa utilidad segura de React Native
            intent.putExtra("props", propsBundle);

            currentActivity.startActivity(intent);
        }
    }


}
