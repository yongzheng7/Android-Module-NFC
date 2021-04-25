# Android-Module-NFC
一个使用Android NFC的模块
加入步骤
1 在项目根build.gradle中添加
buildscript {
    repositories {
        // 添加maven库，鉴于Jcenter（）即将过期
        mavenCentral()
    }
    allprojects {
    repositories {
        //添加maven库，鉴于Jcenter（）即将过期
        mavenCentral()
    }
  }
}

2 在App模块或者Module模块下的build.gradle中添加依赖

dependencies {
    // 依赖
    implementation 'io.github.yongzheng7:module-nfc:2.0'
}

3 在代码中添加
NFCActivity.start(this, (arrayMsg, values) -> {
    // 点击会出现Dialog提醒,此时,确保手机支持NFC 同时NFC为开启状态
    // 当扫描到NFC消息后,回调该方法
});
