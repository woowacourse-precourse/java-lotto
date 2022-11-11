package lotto.view;
public class Output {
    private final String INPUTMONEY_ORDER = "구입금액을 입력해 주세요.";
    private final String PURCHASE_LOTTO_ORDER = "개를 구매했습니다.";

    public void inputMoneyOrder() {
        System.out.println(INPUTMONEY_ORDER);
    }
    public void purchaseLottoOrder(int lottoCount) {
        System.out.println(lottoCount+PURCHASE_LOTTO_ORDER);
    }
}