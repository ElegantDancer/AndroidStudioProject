package callbacktest;

/**
 * Created by zhenzhen on 16/8/5.
 */
public class Wang {

    ICallback callback;
    public Wang(Li li){
        this.callback = li;
    }

    public void answerQus(String qus){
        System.out.printf("Question is" + qus);
        callback.obtainResult("---->" + "Wang给出的答案");
    }
}
