package lotto;

public class Output{
    public static void printCost(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static int printOrder(int cost){
        int cnt = cost/1000;
        System.out.println(cnt+"개를 구매했습니다.");
        return cnt;
    }

}
