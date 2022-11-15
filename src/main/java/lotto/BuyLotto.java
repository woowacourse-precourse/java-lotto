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



}
