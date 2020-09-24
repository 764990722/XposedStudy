
新手使用XPosed的Demo

教程链接：https://www.cnblogs.com/albertzhangyu/p/12656588.html

第一步：
        使用Root过的手机安装XPosed框架，直接夜神模拟器测试；
        模拟器是自带root权限的，下面下载xposed框架.apk
        链接: https://pan.baidu.com/s/1QjQ2CG1Br2SUoGbgHoRfTA 密码: imt4!

第二步：
        新建一个Android studio项目

        在 AndroidManifest application中写入
        <!-- 告诉这是一个xposed模块-->
        <meta-data
            android:name="xposedmodule"
            android:value="true" />
        <!-- 模块描述-->
        <meta-data
            android:name="xposeddescription"
            android:value="示例拦截广告" />
        <!-- 模块支持的最低版本-->
        <meta-data
            android:name="xposedminversion"
            android:value="53" />

第三步：
        在app的build.gradle中引入
        compileOnly 'de.robv.android.xposed:api:82'
        compileOnly 'de.robv.android.xposed:api:82:sources'

        在main目录新建assets文件夹，创建文本xposed_init
        写入：com.example.xposedstudy.HookTest   （com.example.xposedstudy为目录，HookTest为拦截的自定义类）
        代码省略，做一个记录；

第四步：
        运行项目后，打开安装的XPosed框架，点开菜单选择模块，勾选测试的apk，如果未生效重启模拟器。


