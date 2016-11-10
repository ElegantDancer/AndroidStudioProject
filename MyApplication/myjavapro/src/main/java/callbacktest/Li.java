package callbacktest;

/**
 * Created by zhenzhen on 16/8/5.
 */
public class Li implements ICallback{


    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.answerQus("1+1 = ?");
    }


    @Override
    public void obtainResult(String result) {
        System.out.println("result = [" + result + "]");
    }
}
