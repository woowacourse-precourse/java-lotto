package lotto.view;
public class Output {
    private final String INPUTMONEY_ORDER = "구입금액을 입력해 주세요.";
    private final String PURCHASE_LOTTO_ORDER = "개를 구매했습니다.";
    private final String USER_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String BONUS_LOTTO_NUMBER = "보너스 번호를 입력해 주세요.";


    public void inputMoneyOrder() {
        System.out.println(INPUTMONEY_ORDER);
    }

    public void purchaseLottoOrder(int lottoCount) {
        System.out.println(lottoCount+PURCHASE_LOTTO_ORDER);
    }
    public void userLottoNumbersOrder() {
        System.out.println(USER_LOTTO_NUMBERS);
    }
    public void bonusLottoNumberOrder() {
        System.out.println(BONUS_LOTTO_NUMBER);
    }
}