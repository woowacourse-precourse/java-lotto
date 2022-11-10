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
    public static int revenue(int rankOne, int rankTwo, int rankThree, int rankFour, int rankFive) {
        revenue += rankOne * Rank.ONE.getMoney();
        revenue += rankTwo * Rank.TWO.getMoney();
        revenue += rankThree * Rank.THREE.getMoney();
        revenue += rankFour * Rank.FOUR.getMoney();
        revenue += rankFive * Rank.FIVE.getMoney();
        return revenue;
    }

    public static double yield(int revenue) {
        return 0;
    }
}
