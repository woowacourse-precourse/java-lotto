package lotto.view;

import static lotto.util.Constant.COUNTBUYLOTTO;
import static lotto.util.Constant.FIFTHPLACE;
import static lotto.util.Constant.FIRSTPLACE;
import static lotto.util.Constant.FOURTHPLACE;
import static lotto.util.Constant.REQUESTBONUSNUMBKER;
import static lotto.util.Constant.REQUESTWINNINGNUMBER;
import static lotto.util.Constant.RESULT1;
import static lotto.util.Constant.RESULTOFANNOUNCEMENTBEGIN;
import static lotto.util.Constant.SECONDPLACE;
import static lotto.util.Constant.THIRDPLACE;

import java.util.List;
import lotto.util.Constant;

public class Output {
    public static void gameStart() {
        System.out.println(Constant.GAMESTART);
    }

    public static void informationOnPurchasedLottoNumbers(List<List<Integer>> purchasedLotto) {
        System.out.println(purchasedLotto.size() + COUNTBUYLOTTO);
        for (List<Integer> lotto : purchasedLotto) {
            System.out.println(lotto);
        }
    }

    public static void requestInputNumber() {
        System.out.println(REQUESTWINNINGNUMBER);
    }

    public static void requestBonusNumber() {
        System.out.println(REQUESTBONUSNUMBKER);
    }

    public static void beginAnnouncementOfResult() {
        System.out.println(RESULTOFANNOUNCEMENTBEGIN);
    }

    public static void announcementScore() {
        System.out.println(RESULTOFANNOUNCEMENTBEGIN);
    }

    public static void resultAnnouncement(String yield) {
        System.out.println( 3 + RESULT1 + "(5,000원) -" +FIFTHPLACE+"개");
        System.out.println( 4 + RESULT1 + "(50,000원) -" +FOURTHPLACE+"개");
        System.out.println( 5 + RESULT1 + "(1,500,000원) -" +THIRDPLACE+"개");
        System.out.println( 5 + RESULT1 + "(30,000,000원) -" +SECONDPLACE+"개");
        System.out.println( 6 + RESULT1 + "(2,000,000,000원) -" +FIRSTPLACE+"개");
        System.out.printf("총 수익률은 %s%" + "%입니다", yield);
    }
}
