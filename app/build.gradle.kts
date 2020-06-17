import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(29)
    buildToolsVersion("29.0.3")
    defaultConfig {
        applicationId = "com.moonwolf125.android.templates.mvp"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    val versions = object {
        val appCompat     = "1.1.0"
        val coroutines    = "1.3.5"
        val dagger        = "2.28"
        val material      = "1.1.0"
        val okhttp3       = "4.2.1"
        val retrofit      = "2.6.1"
    }

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.appcompat:appcompat:${versions.appCompat}")

    // Coroutines Dependency
    implementation(kotlinx("coroutines-core", versions.coroutines))
    implementation(kotlinx("coroutines-android", versions.coroutines))

    // Dagger Dependencies
    implementation(dagger("dagger", versions.dagger))
    implementation(dagger("dagger-android", versions.dagger))
    kapt(dagger("dagger-compiler", versions.dagger))
    kapt(dagger("dagger-android-processor", versions.dagger))

    // Material Dependencies
    implementation(materialDesign(versions.material))
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")

    // OkHttp Dependency
    implementation(okhttp3("okhttp", versions.okhttp3))

    // Retrofit2 Dependencies
    implementation(retrofit2("retrofit", versions.retrofit))
    implementation(retrofit2("converter-jackson", versions.retrofit))

    // Test Dependencies
    testImplementation("junit:junit:4.13")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}

/**
 * Builds the dependency notation for the named Dagger [module] at the given [version].
 *
 * @param module simple name of the Dagger module, for example "dagger-android".
 * @param version optional desired version, unspecified if null.
 */
fun DependencyHandler.dagger(module: String, version: String): Any = "com.google.dagger:$module:$version"

/**
 * Builds the dependency notation for the Material Design module at the given [version].
 *
 * @param version optional desired version, unspecified if null.
 */
fun DependencyHandler.materialDesign(version: String): Any = "com.google.android.material:material:$version"

/**
 * Builds the dependency notation for the named okhttp3 [module] at the given [version].
 *
 * @param module simple name of the okhttp3 module, for example "okhttp".
 * @param version optional desired version, unspecified if null.
 */
fun DependencyHandler.okhttp3(module: String, version: String): Any = "com.squareup.okhttp3:$module:$version"

/**
 * Builds the dependency notation for the named Retrofit2 [module] at the given [version].
 *
 * @param module simple name of the Retrofit2 module, for example "retrofit".
 * @param version optional desired version, unspecified if null.
 */
fun DependencyHandler.retrofit2(module: String, version: String): Any = "com.squareup.retrofit2:$module:$version"

/**
 * Builds the dependency notation for the named KotlinX [module] at the given [version].
 *
 * @param module simple name of the KotlinX module, for example "coroutines-core".
 * @param version optional desired version, unspecified if null.
 */
fun DependencyHandler.kotlinx(module: String, version: String): Any = "org.jetbrains.kotlinx:kotlinx-$module:$version"