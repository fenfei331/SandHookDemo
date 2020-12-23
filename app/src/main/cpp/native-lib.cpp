#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_fenfei_sandhookdemo_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject obj) {
    jclass cls = env->GetObjectClass(obj);
    jmethodID mid = env->GetMethodID(cls, "getPackageManager",
                                     "()Landroid/content/pm/PackageManager;");

    mid = env->GetMethodID(cls, "getPackageName", "()Ljava/lang/String;");//
    jstring packageName = (jstring) env->CallObjectMethod(obj, mid);

    const char* str;
    str = env->GetStringUTFChars(packageName, NULL);
    env->ReleaseStringUTFChars(packageName, str);

    std::string strRc = "ok";
    if( strcmp(str,"com.fenfei.demo") != 0){
        strRc = "OMG";
    }

    return env->NewStringUTF(strRc.c_str());
}