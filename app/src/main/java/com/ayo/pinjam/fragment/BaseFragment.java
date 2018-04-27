package com.ayo.pinjam.fragment;

import android.widget.Toast;

import com.ayo.pinjam.R;
import com.ayo.pinjam.utils.SpUtils;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by yanshihao on 2018/1/2.
 */

public class BaseFragment extends SupportFragment {
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, R.string.define_angin, Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public void setLogin(boolean b){
        SpUtils.setBooleanPreferences(_mActivity,"isLogin",b);
    }

}
