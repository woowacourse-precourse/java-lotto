package lotto.view;

public class View {
    // TODO: 숫자가 들어간 메시지는 printf로 리팩토링하는 것 고려
    private static final String GET_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String PURCHASE_INFORMATION_MESSAGE = "개를 구매했습니다.";
    private static final String GET_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String GET_RESULT_MESSAGE = "당첨 통계";
    private static final String GET_PROFIT_RATES_MESSAGE = "총 수익률은 입니다.";

    public static void printInputPurchaseAmount() {
        System.out.println(GET_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printPurchaseInformation() {
        System.out.println(PURCHASE_INFORMATION_MESSAGE);
    }

    public static void printInputLottoNumber() {
        System.out.println(GET_LOTTO_NUMBER_MESSAGE);
    }

    public static void printInputBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
    }

    public static void printResult() {
        System.out.println(GET_RESULT_MESSAGE);
    }

    public static void printProfitRate() {
        System.out.println(GET_PROFIT_RATES_MESSAGE);
    }

}
