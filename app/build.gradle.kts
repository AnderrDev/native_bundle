plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "co.corp.pocnativeapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "co.corp.pocnativeapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // AndroidX, Material, etc.
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // React Native core (solo lo necesario para correr el bundle)
    implementation("com.facebook.react:react-android:0.73.0") {
        exclude(group = "com.facebook.fbjni")
    }

    // JavaScriptCore engine (solución al error actual)
    implementation("com.facebook.react:hermes-android:0.73.0")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
