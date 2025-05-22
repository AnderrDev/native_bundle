package co.corp.pocnativeapp;

import android.os.Bundle;

import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactRootView;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.common.LifecycleState;
// PoCModuleActivity.java
public class PoCModuleActivity extends ReactActivity {

    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String bundleName = getIntent().getStringExtra("bundleName");
        String moduleName = getIntent().getStringExtra("moduleName");
        Bundle props = getIntent().getBundleExtra("props");

        mReactRootView = new ReactRootView(this);

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setCurrentActivity(this)
                .setBundleAssetName(bundleName) // Ejemplo: red.bundle
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .addPackage(new CustomPackage())
                .setUseDeveloperSupport(false)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .setJavaScriptExecutorFactory(new HermesExecutorFactory())
                .build();

        mReactRootView.startReactApplication(mReactInstanceManager, moduleName, props);
        setContentView(mReactRootView);
    }
}
