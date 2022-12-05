package lotto;

import java.util.List;

public class OutputView {
    static final String ENTER_THE_AMOUNT = "구입금액을 입력해 주세요.";
    static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String ERROR_MESSAGE_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final String ERROR_MESSAGE_NUMBER_EXCEPTION = "[ERROR] 숫자를 입력해 주세요.";
    static final String ERROR_MESSAGE_FACTOR_THOUSAND = "[ERROR] 1000의 인수를 입력해 주세요.";
    static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    static final String ANNOUNCEMENT = "당첨 통계\n---";
    static String CLOSING_STATEMENT;


    enum places {
        FIFTH_PLACE(5000, 3, "3개 일치 (5,000원) - "),
        FOURTH_PLACE(50000, 4, "4개 일치 (50,000원) - "),
        THIRD_PLACE(1500000, 5, "5개 일치 (1,500,000원) - "),
        SECOND_PLACE(30000000, Integer.MAX_VALUE, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        FIRST_PLACE(2000000000, 6, "6개 일치 (2,000,000,000원) - ");


        final int numberMatch;
        final int prize;
        final String message;

        places(int prize, int numberMatch, String message) {
            this.prize = prize;
            this.numberMatch = numberMatch;
            this.message = message;
        }
    }

    public static void printTheAmount() {
        System.out.println(ENTER_THE_AMOUNT);
    }

    public static void printWinningNumber() {
        System.out.println(ENTER_WINNING_NUMBER);
    }

    public static void printErrorMessageRange() {
        System.out.println(ERROR_MESSAGE_RANGE);
    }

    public static void printErrorMessageNumberException() {
        System.out.println(ERROR_MESSAGE_NUMBER_EXCEPTION);
    }

    public static void printErrorMessageFactorOfThousand() {
        System.out.println(ERROR_MESSAGE_FACTOR_THOUSAND);
    }

    public static void printBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }


    public static void printAnnouncement() {
        System.out.println(ANNOUNCEMENT);
    }

    public static void printLottoNumbers(int numberOfPurchasedLotto, List<Lotto> purchasedLotto) {
        System.out.println(numberOfPurchasedLotto + LOTTO_PURCHASE_MESSAGE);
        for (int index = 0; index < numberOfPurchasedLotto; index++) {
            purchasedLotto.add(Lotto.generateRandomSixNumbers());
            System.out.println(purchasedLotto.get(index).getNumbers().toString());
        }
    }

    public static void printPlaceMessage(places place, int won) {
        System.out.println(place.message + won + "개");
    }

    public static void printClosingStatement(String percentage) {
        CLOSING_STATEMENT = "총 수익률은 " + percentage + "%입니다.";
        System.out.println(CLOSING_STATEMENT);
    }
}
