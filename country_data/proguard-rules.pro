# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-injars in.jar
-outjars out.jar
-libaryjars <java.home>/jmods/java.base.jmod(!**.jar;!module-info.class)
-printmapping out.map
-keep class com.blongho.country_data* {
   *;
  }

-keepparameternames
-renamesourcefileattribute SourceFile
-keepattributes Exceptions,InnerClasses,Signature,Deprecated, SourceFile,LineNumberTable,*Annotation*,EnclosingMethod
-keepclasseswithmembers, allowoptimization enum * {
                             public static **[] values();
                             public static ** valueOf(java.lang.String);
                         }
-keepclasseswithmembernames, includedescriptorclasses class * {
                                 native <methods>;
                             }