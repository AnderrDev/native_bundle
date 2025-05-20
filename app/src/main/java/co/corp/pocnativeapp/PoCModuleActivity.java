package co.corp.pocnativeapp;

import android.os.Bundle;

import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactRootView;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.common.LifecycleState;

public class PoCModuleActivity extends ReactActivity {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(this);

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setCurrentActivity(this)
                .setBundleAssetName("red.bundle")
                .setJSMainModulePath("index") // puedes omitir si solo usas bundle local
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(false)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .setJavaScriptExecutorFactory(new HermesExecutorFactory()) // ✅ esta línea es clave
                .build();



        mReactRootView.startReactApplication(mReactInstanceManager, "PoCModule", null);
        setContentView(mReactRootView);
    }
}
