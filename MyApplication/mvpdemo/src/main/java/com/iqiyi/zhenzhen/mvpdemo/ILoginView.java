package com.iqiyi.zhenzhen.mvpdemo;

/**
 * Created by zhenzhen on 16/8/26.
 */
public interface ILoginView {

    //该view需要什么
    String getUserName();
    String getPassport();

    // 该view操作的结果
    void toMainActivity();
    void showFailError();

    // 该view涉及到的良好的交互
    void showLoading();
    void hideLoading();

    void clearUserName();
    void clearPassport();
}
