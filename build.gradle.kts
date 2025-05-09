
plugins {
    id("com.android.application") version "8.5.2" apply false
    id("com.android.library") version "8.5.2" apply false // Use the same AGP version for all plugins
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
