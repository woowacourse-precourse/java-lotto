package lotto.Printer;

public class Printer {
    private static final String PURCHASE_AMOUNT_REQUEST_MESSAGE = "구매금액을 입력해 주세요.";
    private static final String PURCHASE_MESSAGE = "%개를 구매했습니다.";
    private static final String LOTTO_NUMBER_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void requestPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_REQUEST_MESSAGE);
    }

    public void printPurchaseMessage(int numberOfLottos){
        System.out.printf(PURCHASE_MESSAGE, numberOfLottos);
    }

    public void requestLottoNumber(){
        System.out.println(LOTTO_NUMBER_REQUEST_MESSAGE);
    }

    public void requestBonusNumber(){
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }
}
