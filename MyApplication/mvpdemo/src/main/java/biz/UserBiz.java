package biz;

/**
 * Created by zhenzhen on 16/8/25.
 */
public class UserBiz implements IUserBiz {


    @Override
    public void login(final String userName, final String passport, final OnLoginListener listener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 模拟登录成功
                if("zzz".equals(userName) && "123".equals(passport)){
                    listener.loginSuccess();
                }else {
                    listener.loginFailed();
                }
            }
        }.start();
    }
}
