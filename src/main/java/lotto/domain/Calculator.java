package lotto.domain;

import java.util.List;
import java.util.regex.Matcher;

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
    private static double yield = 0;
    public static void revenue(int rankOne, int rankTwo, int rankThree, int rankFour, int rankFive) {
        revenue += rankOne * Rank.ONE.getMoney();
        revenue += rankTwo * Rank.TWO.getMoney();
        revenue += rankThree * Rank.THREE.getMoney();
        revenue += rankFour * Rank.FOUR.getMoney();
        revenue += rankFive * Rank.FIVE.getMoney();
    }

    public static void yield(double revenue, double coin) {
        double result = (((revenue - coin)/coin) * 100);
        yield = Math.round(result * 10)/10.0;
        System.out.println(yield);
    }
}
