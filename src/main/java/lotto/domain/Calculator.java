package lotto.domain;

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
    public static int revenue = 0;
    public static double yield = 0;

    public static int revenue(int rankOne, int rankTwo, int rankThree, int rankFour, int rankFive) {
        int result = 0;
        result += rankOne * Rank.ONE.getMoney();
        result += rankTwo * Rank.TWO.getMoney();
        result += rankThree * Rank.THREE.getMoney();
        result += rankFour * Rank.FOUR.getMoney();
        result += rankFive * Rank.FIVE.getMoney();
        revenue = result;
        return result;
    }

    public static double yield(double revenue, double coin) {
        double result = (((revenue - coin)/coin) * 100);
        result = Math.round(result * 10)/10.0;
        result = result + 100.0;
        System.out.println("총 수익률은 " + result + "%입니다.");
        return result;
    }
}
