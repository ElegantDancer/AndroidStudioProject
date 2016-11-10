package presenter;

import android.os.Handler;

import com.iqiyi.zhenzhen.mvpdemo.ILoginView;


import biz.IUserBiz;
import biz.OnLoginListener;
import biz.UserBiz;

/**
 * Created by zhenzhen on 16/8/26.
 */
public class UserLoginPresenter {

    ILoginView iloginView;
    IUserBiz iUserBiz;
    Handler mHandler = new Handler();

    public UserLoginPresenter(ILoginView iloginView) {
        this.iloginView = iloginView;
        this.iUserBiz = new UserBiz();
    }

    public void login(){
        iloginView.showLoading();
        iUserBiz.login(iloginView.getUserName(), iloginView.getPassport(), new OnLoginListener() {
            @Override
            public void loginSuccess() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iloginView.toMainActivity();
                        iloginView.hideLoading();

                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iloginView.showFailError();
                        iloginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear(){
        iloginView.clearUserName();
        iloginView.clearPassport();
    }

}
