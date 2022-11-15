package lotto.view;

import static lotto.util.Constant.COUNT_BUY_LOTTO;
import static lotto.util.Constant.FIFTH_PLACE;
import static lotto.util.Constant.FIRST_PLACE;
import static lotto.util.Constant.FOURTH_PLACE;
import static lotto.util.Constant.GAME_START;
import static lotto.util.Constant.REQUEST_BONUS_NUMBER;
import static lotto.util.Constant.REQUEST_WINNING_NUMBER;
import static lotto.util.Constant.RESULT1;
import static lotto.util.Constant.RESULT_OF_ANNOUNCEMENT_BEGIN;
import static lotto.util.Constant.SECOND_PLACE;
import static lotto.util.Constant.THIRD_PLACE;

import java.util.List;
import lotto.util.Constant;

public class Output {
    public static void gameStart() {
        System.out.println(GAME_START);
    }

    public static void informationOnPurchasedLottoNumbers(List<List<Integer>> purchasedLotto) {
        System.out.println(purchasedLotto.size() + COUNT_BUY_LOTTO);
        for (List<Integer> lotto : purchasedLotto) {
            System.out.println(lotto);
        }
    }

    public static void requestInputNumber() {
        System.out.println(REQUEST_WINNING_NUMBER);
    }

    public static void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
    }

    public static void beginAnnouncementOfResult() {
        System.out.println(RESULT_OF_ANNOUNCEMENT_BEGIN);
    }
    public static void resultAnnouncement(String yield) {
        System.out.println( 3 + RESULT1 + " (5,000원) - " +FIFTH_PLACE+"개");
        System.out.println( 4 + RESULT1 + " (50,000원) - " +FOURTH_PLACE+"개");
        System.out.println( 5 + RESULT1 + " (1,500,000원) - " +THIRD_PLACE+"개");
        System.out.println( 5 + RESULT1 + ", 보너스 볼 일치 (30,000,000원) - " +SECOND_PLACE+"개");
        System.out.println( 6 + RESULT1 + " (2,000,000,000원) - " +FIRST_PLACE+"개");
        System.out.printf("총 수익률은 %s%" + "%입니다.", yield);
    }
}
