plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.abouttime.wearos"

    compileSdk = 35

    defaultConfig {

    applicationId =
        "com.abouttime.wearos"

    minSdk =
        30

    targetSdk =
        35

    versionCode =
        1

    versionName =
        "1.0.0"
}

   buildTypes {

    release {

        isMinifyEnabled = false

    }


    debug {

        applicationIdSuffix =
            ".debug"

    }

}

    compileOptions {

        sourceCompatibility = JavaVersion.VERSION_17

        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {

        jvmTarget = "17"
    }
}


dependencies {

    implementation(
        "androidx.core:core-ktx:1.15.0"
    )


    implementation(
        "androidx.wear:wear:1.3.0"
    )


    implementation(
        "androidx.wear.watchface:watchface:1.1.1"
    )


}
