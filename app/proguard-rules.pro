# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/akshaymahajan/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# Retrofit
-dontwarn retrofit2.**
-keepattributes Signature
-keepattributes Exceptions
-keep class retrofit2.** { *; }

# Okio
-dontwarn okio.**

# OkHttp3
-keep class okhttp3.** { *; }

# Stetho
-keep class com.facebook.** { *; }