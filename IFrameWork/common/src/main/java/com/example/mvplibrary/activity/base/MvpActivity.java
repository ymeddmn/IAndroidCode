package com.example.mvplibrary.activity.base;
/**
 * @function MvpActivity
 * @author mayong
 * @time 2016/9/28 13:48
 **/

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.mvplibrary.utils.StatusBarUtil;
import com.example.mvplibrary.utils.ToastUtils;
import com.example.mvplibrary.view.IBaseView;
import com.example.mvplibrary.zpresenter.base.BaseActivityPresenter;
import com.example.mvplibrary.zview.base.BaseView;

import java.lang.ref.WeakReference;


public abstract class MvpActivity<P extends BaseActivityPresenter> extends BaseActivity implements BaseView {
    P presenter;
    private IBaseView rootView;
//    private CommonDialog dialog;
    private BroadcastReceiver mBroadcastReceiver;
    private boolean can;
    private boolean shouldDelay = true;
    private long currentMillis;
    private boolean shouldShowAgain = true;
    private boolean canReach = true;
    private MyHandler handler = new MyHandler(this);

    public P getPresenter() {
        if(presenter == null) {
            presenter = createPresenter();

        }
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ActivityCollector.addActivity(this);
        rootView = new IBaseView(this);
        setContentView(rootView);
        StatusBarUtil.set(this);
        getPresenter().attachView();
        initLoginInvalidReceiver();
    }

    public void cannotInterplatorTheRequest() {
        this.can = true;
    }

    /**
     * 初始化登录过期广播接收者
     */
    private void initLoginInvalidReceiver() {
        if(can) {
            return;
        }
//        mBroadcastReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(final Context context, Intent intent) {
//                if(intent.getAction().equals(NetCode.LOGIN_INVALID)) {
//                    Message msg = handler.obtainMessage();
//                    msg.arg1 = 2;
//                    handler.sendMessage(msg);
//
//                }
//            }
//        };
//        this.registerReceiver(mBroadcastReceiver, new IntentFilter(NetCode.LOGIN_INVALID));
    }

    protected abstract P createPresenter();

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getPresenter().onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getPresenter().onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        canReach = false;
        getPresenter().onDestroy();
        getPresenter().deattachView();
        if(mBroadcastReceiver != null) {
            this.unregisterReceiver(mBroadcastReceiver);
        }
//        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getPresenter().onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getPresenter().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {

        if(!getPresenter().onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        getPresenter().onKeyDown(keyCode, event);
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
        getPresenter().onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
        getPresenter().onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getPresenter().onRestart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
//        getPresenter().onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        getPresenter().onAttachFragment(fragment);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        getPresenter().onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void showProgress() {
       /* if ((System.currentTimeMillis() - currentMillis) < 200) {
            return;
        }
        if (shouldDelay) {
            Message msg = handler.obtainMessage();
            msg.arg1 = 1;
            handler.sendMessageDelayed(msg, 200);
            currentMillis = System.currentTimeMillis();
            shouldDelay = false;
            return;
        }
        if (!shouldShowAgain) {
            shouldShowAgain = true;
            return;
        }*/
       /* if(dialog == null) {
            dialog = new CommonDialog(this, dialog);
        }

        if(!dialog.isShowing()) {
            dialog.show();
        }*/
    }

    public void hidProgress() {
      /*  if ((System.currentTimeMillis() - currentMillis) < 200) {
            shouldShowAgain = false;
        }
        shouldDelay = true;*/
       /* if(dialog != null && isShowing()) {
            dialog.dismiss();
        }*/
    }

    @Override
    public void showDialog(String msg) {
        if(canReach) {
            showProgress();
        }
    }

    @Override
    public void hideDialog() {
        if(canReach) {
            hidProgress();
        }
    }

    public boolean isShowing() {
//        return dialog.isShowing();
        return true;
    }

    public void toast(String toast) {
        ToastUtils.show(this, toast);
    }

    public void toast(int resId) {
        ToastUtils.show(this, this.getResources().getText(resId), Toast.LENGTH_SHORT);
    }

    public void toast(int resId, int duration) {
        ToastUtils.show(this, this.getResources().getText(resId), duration);
    }

    public void toast(CharSequence text) {
        ToastUtils.show(this, text, Toast.LENGTH_SHORT);
    }

    public void toast(int resId, Object... args) {
        ToastUtils.show(String.format(this.getResources().getString(resId), args),
                Toast.LENGTH_SHORT);
    }

    public void toast(String format, Object... args) {
        ToastUtils.show(String.format(format, args), Toast.LENGTH_SHORT);
    }

    public void toast(int resId, int duration, Object... args) {
        ToastUtils.show(String.format(this.getResources().getString(resId), args),
                duration);
    }

    public void toast(String format, int duration, Object... args) {
        ToastUtils.show(String.format(format, args), duration);
    }

    public void addSuccessView(View view) {
        this.rootView.addView(view);
    }

    public void addSuccessView(@LayoutRes int id) {
        addSuccessView(LayoutInflater.from(this).inflate(id, null));
    }

    public void addErrorView(View view) {
        this.rootView.addView(view);
    }

    public void addLoadingView(View view) {
        this.rootView.addView(view);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    static class MyHandler extends Handler {
        WeakReference<MvpActivity> mActivity;

        MyHandler(MvpActivity activity) {
            mActivity = new WeakReference<MvpActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            int arg = msg.arg1;
            if(arg == 1) {
                mActivity.get().showDialog(null);
            } else if(arg == 2) {
                mActivity.get().hideDialog();
            }
        }
    }

}
