package lotto.view;

import java.util.List;
import lotto.model.WinnerInfo;
import lotto.util.Convertor;

public class View {
    private static final String GET_MONEY_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_INFORMATION_MESSAGE = "%n%d개를 구매했습니다.%n";
    private static final String GET_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBERS_MESSAGE = "%n보너스 번호를 입력해 주세요.%n";
    private static final String RESULT_TITLE = "%n당첨 통계%n---%n";
    private static final String GET_RESULT_MESSAGE = "%s - %d개%n";
    private static final String GET_PROFIT_RATES_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INPUT_IS_EMPTY_MESSAGE = ERROR_MESSAGE + "입력된 값이 없습니다. 게임이 종료됩니다.";
    private static final String NOT_INTEGER_MESSAGE = ERROR_MESSAGE + "숫자만 입력 가능합니다. 게임이 종료됩니다.";
    private static final String NOT_POSITIVE_MONEY = ERROR_MESSAGE + "%d 이상의 숫자만 입력 가능합니다. 게임이 종료됩니다.%n";
    private static final String NOT_PURCHASE_MESSAGE = ERROR_MESSAGE + "로또를 구매하지 않아 게임이 종료됩니다.";
    private static final String NOT_LOTTO_PRICE_MESSAGE = ERROR_MESSAGE + "%d단위로만 입력 가능합니다. 게임이 종료됩니다.%n";
    private static final String NOT_SEPARATED_BY_COMMA_MESSAGE = ERROR_MESSAGE + "숫자는 콤마로 구분해 주세요. 게임이 종료됩니다.";
    private static final String NOT_LOTTO_SIZE_MESSAGE = ERROR_MESSAGE + "%d개의 숫자만 입력 가능합니다. 게임이 종료됩니다.%n";
    private static final String NOT_LOTTO_NUMBER_MESSAGE = ERROR_MESSAGE + "%d ~ %d 사이의 숫자만 입력 가능합니다. 게임이 종료됩니다.%n";
    private static final String NOT_UNIQUE_NUMBER_MESSAGE = ERROR_MESSAGE + "중복된 숫자는 입력할 수 없습니다. 게임이 종료됩니다.";

    public static void printInputMoney() {
        System.out.println(GET_MONEY_MESSAGE);
    }

    public static void printPurchaseInformation(int lottoAmount, List<List<Integer>> lottoNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.printf(PURCHASE_INFORMATION_MESSAGE, lottoAmount);

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> lotto = Convertor.ExtractList(lottoNumbers, i);
            stringBuilder.append(lotto).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void printInputLottoNumbers() {
        System.out.println(GET_LOTTO_NUMBERS_MESSAGE);
    }

    public static void printInputBonusNumber() {
        System.out.printf(GET_BONUS_NUMBERS_MESSAGE);
    }

    public static void printResult(int[] lottoResult) {
        System.out.printf(RESULT_TITLE);

        for (int i = 0; i < lottoResult.length; i++) {
            String winningMessage = WinnerInfo.values()[i].getWinningMessage();
            int count = lottoResult[i];
            System.out.printf(GET_RESULT_MESSAGE, winningMessage, count);
        }
    }

    public static void printProfitRates(double profitRates) {
        System.out.printf(GET_PROFIT_RATES_MESSAGE, profitRates);
    }

    public static void printInputIsEmpty() {
        System.out.println(INPUT_IS_EMPTY_MESSAGE);
    }

    public static void printNotInteger() {
        System.out.println(NOT_INTEGER_MESSAGE);
    }

    public static void printNotPositiveMoney(int lottoPrice) {
        System.out.printf(NOT_POSITIVE_MONEY, lottoPrice);
    }

    public static void printNotPurchase() {
        System.out.println(NOT_PURCHASE_MESSAGE);
    }

    public static void printNotLottoPrice(int lottoPrice) {
        System.out.printf(NOT_LOTTO_PRICE_MESSAGE, lottoPrice);
    }

    public static void printNotSeparatedByComma() {
        System.out.println(NOT_SEPARATED_BY_COMMA_MESSAGE);
    }

    public static void printNotLottoSize(int lottoSize) {
        System.out.printf(NOT_LOTTO_SIZE_MESSAGE, lottoSize);
    }

    public static void printNotLottoNumber(int lottoStartNumber, int lottoEndNumber) {
        System.out.printf(NOT_LOTTO_NUMBER_MESSAGE, lottoStartNumber, lottoEndNumber);
    }

    public static void printNotUniqueNumber() {
        System.out.println(NOT_UNIQUE_NUMBER_MESSAGE);
    }

}
