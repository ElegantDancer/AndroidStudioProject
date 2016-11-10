package biz;

/**
 * Created by zhenzhen on 16/8/25.
 */
public interface IUserBiz {

    void login(String userName, String passport, OnLoginListener listener);
}
