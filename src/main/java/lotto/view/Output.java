package lotto.view;

import static lotto.util.Constant.BUY_MENT;
import static lotto.util.Constant.COUNT_UNIT;
import static lotto.util.Constant.FIFTH_PRICE;
import static lotto.util.Constant.FIRST_PRICE;
import static lotto.util.Constant.FOURTH_PRICE;
import static lotto.util.Constant.GAME_START;
import static lotto.util.Constant.MATCH_BONUS_BALL;
import static lotto.util.Constant.REQUEST_BONUS_NUMBER;
import static lotto.util.Constant.REQUEST_WINNING_NUMBER;
import static lotto.util.Constant.RESULT_OF_ANNOUNCEMENT_BEGIN;
import static lotto.util.Constant.SAME;
import static lotto.util.Constant.SECOND_PRICE;
import static lotto.util.Constant.THIRD_PRICE;
import static lotto.util.Constant.WON;
import static lotto.util.WinnerList.FIFTH_PLACE;
import static lotto.util.WinnerList.FOURTH_PLACE;
import static lotto.util.WinnerList.THIRD_PLACE;
import static lotto.util.WinnerList.SECOND_PLACE;
import static lotto.util.WinnerList.FIRST_PLACE;

import java.text.NumberFormat;
import java.util.List;

public class Output {
    public static void gameStart() {
        System.out.println(GAME_START);
    }

    public static void informationOnPurchasedLottoNumbers(List<List<Integer>> purchasedLotto) {
        System.out.println(String.format(COUNT_UNIT, purchasedLotto.size())+BUY_MENT);
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
        NumberFormat numberFormat = NumberFormat.getInstance();
        String firstPrice = numberFormat.format(FIRST_PRICE)+WON;
        String secondPrice = numberFormat.format(SECOND_PRICE)+WON;
        String thirdPrice = numberFormat.format(THIRD_PRICE)+WON;
        String fourthPrice = numberFormat.format(FOURTH_PRICE)+WON;
        String fifthPrice = numberFormat.format(FIFTH_PRICE)+WON;

        System.out.println(
                String.format(COUNT_UNIT, 3) + SAME + " (" + fifthPrice + ") - " + String.format(COUNT_UNIT, FIFTH_PLACE)
        );
        System.out.println(
                String.format(COUNT_UNIT, 4) + SAME + " (" + fourthPrice + ") - " + String.format(COUNT_UNIT, FOURTH_PLACE)
        );
        System.out.println(
                String.format(COUNT_UNIT, 5) + SAME + " (" + thirdPrice + ") - " + String.format(COUNT_UNIT, THIRD_PLACE)
        );
        System.out.println(
                String.format(COUNT_UNIT, 5) + SAME + MATCH_BONUS_BALL + "("+secondPrice + ") - " + String.format(COUNT_UNIT, SECOND_PLACE)
        );
        System.out.println(
                String.format(COUNT_UNIT, 6) + SAME + " (" + firstPrice + ") - " + String.format(COUNT_UNIT, FIRST_PLACE)
        );

        System.out.printf("총 수익률은 %s%" + "%입니다.", yield);
    }
}
