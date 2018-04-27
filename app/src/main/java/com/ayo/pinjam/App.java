package com.ayo.pinjam;

import android.app.Application;

import com.mob.MobSDK;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.helper.ExceptionHandler;

/**
 * Created by yanshihao on 2018/1/2.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fragmentation.builder()
                // 设置 栈视图 模式为 （默认）悬浮球模式   SHAKE: 摇一摇唤出  NONE：隐藏， 仅在Debug环境生效
                .stackViewMode(Fragmentation.NONE)
                .debug(true) // 实际场景建议.debug(BuildConfig.DEBUG)
                /**
                 * 可以获取到{@link me.yokeyword.fragmentation.exception.AfterSaveStateTransactionWarning}
                 * 在遇到After onSaveInstanceState时，不会抛出异常，会回调到下面的ExceptionHandler
                 */
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {
                        // 以Bugtags为例子: 把捕获到的 Exception 传到 Bugtags 后台。
                        // Bugtags.sendException(e);
                    }
                })
                .install();
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE,"6bfd29b459f643f2874d8e409c1ce3aa");
        MobSDK.init(this);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {

            }
        });
    }
}
