package lotto;

import java.util.List;

public class ShowMessage {

    private static final String INPUT_AMOUNT_BUY_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String HOW_MANY_BUY_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static void showInputAmountBuy() {
        System.out.println(INPUT_AMOUNT_BUY_MESSAGE);
    }

    public static void showHowManyBuy(int number) {
        System.out.println(number + HOW_MANY_BUY_MESSAGE);
    }

    public static void showLottoNumber(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    public static void showInputLottoNumber() {
        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE);
    }

    public static void showInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

}
