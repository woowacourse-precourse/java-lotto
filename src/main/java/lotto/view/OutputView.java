package lotto.view;

public class OutputView {

    private static final String HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE = "개를 구매했습니다.";

    public static void printHowManyLottoUserPurchased(int lottoQuantity) {
        System.out.println(lottoQuantity + HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE);
    }
}
