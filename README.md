# 推送联盟
alpha阶段，请勿使用

# android

> android/build.gradle
```
buildscript {
    dependencies {
        ...
        classpath 'com.huawei.agconnect:agcp:1.3.1.300'
    }
}

allprojects {
    repositories {
        ...
        // huawei maven
        maven { url 'https://developer.huawei.com/repo/' }
    }
}
```
