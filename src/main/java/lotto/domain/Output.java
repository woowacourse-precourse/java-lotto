package lotto.domain;

import java.util.List;


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

    public static void outputLottoRank(int rankOne, int rankTwo, int rankThree, int rankFour, int rankFive) {
        System.out.println(Rank.FIVE.getCompare() + "개 일치 " + "(" + Rank.FIVE.getMoneyWon() + ")" + " - " + rankFive + "개");
        System.out.println(Rank.FOUR.getCompare() + "개 일치 " + "(" + Rank.FOUR.getMoneyWon() + ")" + " - " + rankFour + "개");
        System.out.println(Rank.THREE.getCompare() + "개 일치 " + "(" + Rank.THREE.getMoneyWon() + ")" + " - " + rankThree + "개");
        System.out.println(Rank.TWO.getCompare() + "개 일치, 보너스 볼 일치 " + "(" + Rank.TWO.getMoneyWon() + ")" + " - " + rankTwo + "개");
        System.out.println(Rank.ONE.getCompare() + "개 일치 " + "(" + Rank.ONE.getMoneyWon() + ")" + " - " + rankOne + "개");
    }
}
