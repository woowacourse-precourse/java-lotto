package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BuyLotto {
    private final int buyNum;
    private static List<List<Integer>> Lotto_Random_arr = new ArrayList<>();

    BuyLotto(String buyNumber) {
        int buyNum = valid_BuyNum(buyNumber);
        this.buyNum = buyNum;
        buyCount();

    }

    public static int valid_BuyNum(String BuyNum) {
        int num =0;
        try {
            num = Integer.parseInt(BuyNum);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
        }
        return num;
    }

    private void buyCount() {
        int buyCount = buyNum/1000;
        System.out.println(buyCount+"개를 구매했습니다.");
        randomPick(buyCount);
    }

    private static void randomPick(int buyCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < buyCount; i++) {
            List<Integer>numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto_Random_arr.add(sortNumbers(numbers));
        }
    }

    private static List<Integer> sortNumbers(List<Integer>numbers) {
        System.out.println(numbers);
        return numbers;
    }

    public  List<List<Integer>> getLotto_all() {
        return Lotto_Random_arr;
    }

    public int getBuyNum() {
        return buyNum;
    }
}
