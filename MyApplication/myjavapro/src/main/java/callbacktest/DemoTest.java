package callbacktest;

/**
 * Created by zhenzhen on 2016/11/12.
 */

public class DemoTest {

    public static void main(String[] args){
        int a = 1;
        int b = 2;
        int sum = a + b;
        int sum2 = b - a;
        if(sum < sum2){
            System.out.print("sum 比 sum2 小");
        }else {
            System.out.print("sum 比 sum2 大");
        }
    }
}
