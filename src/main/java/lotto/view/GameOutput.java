package lotto.view;

import lotto.utils.RewardType;

import java.util.Arrays;
import java.util.List;

public class GameOutput {
    private static final String lotto_num = "개를 구매했습니다.";
    private static final String count = "개";
    private static final String fifth_result = "3개 일치 (5,000원) - ";
    private static final String fourth_result = "4개 일치 (50,000원) - ";
    private static final String third_result = "5개 일치 (1,500,000원) - ";
    private static final String second_result = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String first_result = "6개 일치 (2,000,000,000원) - ";
    private static final String rating_result1 = "총 수익률은 ";
    private static final String rating_result2 = "%입니다.";


    public static void getLottoNum(int n){
        System.out.println(n+"개를 구매했습니다.");
    }
    public static void getDetailResults(int money, List<Integer> RewardList){
        getDetailResult1(RewardList);
        getDetailResult2(money, RewardList);

    }
    public static void getDetailResult1(List<Integer> RewardList){
        if (RewardList.subList(1,6)!=Arrays.asList(0,0,0,0,0)){
            System.out.println(first_result+RewardList.get(5)+count);
            System.out.println(second_result+RewardList.get(4)+count);
            System.out.println(third_result+RewardList.get(3)+count);
            System.out.println(fourth_result+RewardList.get(2)+count);
            System.out.println(fifth_result+RewardList.get(1)+count);
        }
    }
    public static void getDetailResult2(int money,List<Integer> RewardList){
        double totalmoney=0;
        totalmoney+=RewardList.get(5)*RewardType.FIRST.getreward();
        totalmoney+=RewardList.get(4)*RewardType.SECOND.getreward();
        totalmoney+=RewardList.get(3)*RewardType.THIRD.getreward();
        totalmoney+=RewardList.get(2)*RewardType.FOURTH.getreward();
        totalmoney+=RewardList.get(1)*RewardType.FIFTH.getreward();
        System.out.println(rating_result1+String.format("%.1f", (double) totalmoney / money * 100)+rating_result2);
    }
}