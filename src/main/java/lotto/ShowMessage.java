package lotto;

import java.util.List;

public enum ShowMessage {

    INPUT_AMOUNT_BUY_MESSAGE("구입 금액을 입력해 주세요."),
    HOW_MANY_BUY_MESSAGE("개를 구매했습니다."),
    INPUT_LOTTO_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_STATISTICS_MESSAGE("당첨 통계\n---");

    private final String script;

    ShowMessage(String script) {
        this.script = script;
    }

    public static void showInputAmountBuy() {
        System.out.println(INPUT_AMOUNT_BUY_MESSAGE.script);
    }

    public static void showHowManyBuy(long number) {
        System.out.println();
        System.out.println(number + HOW_MANY_BUY_MESSAGE.script);
    }

    public static void showLottoNumber(List<Lotto> lottoNumbers) {
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLottoNumbers());
        }
    }

    public static void showInputLottoNumber() {
        System.out.println();
        System.out.println(INPUT_LOTTO_NUMBER_MESSAGE.script);
    }

    public static void showInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.script);
    }

    public static void showLottoStatistics() {
        System.out.println(LOTTO_STATISTICS_MESSAGE.script);
    }
}
