package lotto.domain;

import java.util.List;

import static java.lang.String.valueOf;

/**
 * packageName : lotto.domain
 * fileName : Output
 * author : gim-yeong-geun
 * date : 2022/11/09
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/09         gim-yeong-geun          최초 생성
 */
public class Output {

    public static void outputRandomNumber(List<Integer> createRandomNumber) {

    }

    public static void outputLottoRank(int rankOne, int rankTwo, int rankThree, int rankFour, int rankFive) {
        System.out.println(Rank.FIVE.getCompare() + "개 일치 " + "(" + Rank.FIVE.getMoney() + "원)" + " - " + rankFive + "개");
        System.out.println(Rank.FOUR.getCompare() + "개 일치 " + "(" + Rank.FOUR.getMoney() + "원)" + " - " + rankFour + "개");
        System.out.println(Rank.THREE.getCompare() + "개 일치 " + "(" + Rank.THREE.getMoney() + "원)" + " - " + rankThree + "개");
        System.out.println(Rank.TWO.getCompare() + "개 일치 " + "(" + Rank.TWO.getMoney() + "원)" + " - " + rankTwo + "개");
        System.out.println(Rank.ONE.getCompare() + "개 일치 " + "(" + Rank.ONE.getMoney() + "원)" + " - " + rankOne + "개");
    }
}
