package lotto.domain;

import java.util.List;

/**
 * packageName : lotto.domain
 * fileName : Calculator
 * author : gim-yeong-geun
 * date : 2022/11/09
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/09         gim-yeong-geun          최초 생성
 */
public class Calculator {
    private static int revenue = 0;
    private static double yield = 0.0;
    private static String yieldMessage = "총 수익률은 " + yield + "%입니다.";
    public static void revenue(int rankOne, int rankTwo, int rankThree, int rankFour, int rankFive) {
        revenue += rankOne * Rank.ONE.getMoney();
        revenue += rankTwo * Rank.TWO.getMoney();
        revenue += rankThree * Rank.THREE.getMoney();
        revenue += rankFour * Rank.FOUR.getMoney();
        revenue += rankFive * Rank.FIVE.getMoney();
    }

    public static void yield(int revenue, int coin) {
        yield = ((revenue - coin)/coin*100);
        System.out.println(yieldMessage);
    }
}
