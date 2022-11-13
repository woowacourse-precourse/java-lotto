package lotto.view;

import lotto.domain.Lotto;

import static lotto.constant.GameConstants.*;
import static lotto.constant.OutputConstants.*;

public class OutputView {

    public static void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println();
        System.out.printf(PURCHASE_QUANTITY.toString(), purchaseQuantity);
        System.out.println();
    }

    public static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printStatistics() {
        System.out.println();
        System.out.println(STATISTICS);
    }

    public static void printFifthPlace(int fifthPlaceCount) {
        System.out.printf(FIFTH_PLACE.toString(), FIFTH_PRIZE, fifthPlaceCount);
        System.out.println();
    }

    public static void printFourthPlace(int fourthPlaceCount) {
        System.out.printf(FOURTH_PLACE.toString(), FOURTH_PRIZE, fourthPlaceCount);
        System.out.println();
    }

    public static void printThirdPlace(int thirdPlaceCount) {
        System.out.printf(THIRD_PLACE.toString(), THIRD_PRIZE, thirdPlaceCount);
        System.out.println();
    }

    public static void printSecondPlace(int secondPlaceCount) {
        System.out.printf(SECOND_PLACE.toString(), SECOND_PRIZE, secondPlaceCount);
        System.out.println();
    }

    public static void printFirstPlace(int firstPlaceCount) {
        System.out.printf(FIRST_PLACE.toString(), FIRST_PRIZE, firstPlaceCount);
        System.out.println();
    }

    public static void printProfitRate(float profitRate) {
        System.out.printf(PROFIT_RATE.toString(), profitRate);
        System.out.println();
    }
}
