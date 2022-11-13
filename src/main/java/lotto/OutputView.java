package lotto;

public class OutputView {
    private static final String ERRORINPUTMONEY = "[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.";
    private static final String ERRORINPUTLOTTONUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERRORINPUTCOUNTLOTTONUMBER = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";
    private static final String ERRORINPUTBONUSNUMBER = "[ERROR] 보너스 번호는 1개의 숫자여야 합니다.";
    private static final String COUNTLOTTO = "개를 구매했습니다.";
    public void printErrorInputMoney() {
        System.out.println(ERRORINPUTMONEY);
    }

    public void printErrorInputLottoNumber() {
        System.out.println(ERRORINPUTLOTTONUMBER);
    }

    public void printErrorInputCountLottoNumber() {
        System.out.println(ERRORINPUTCOUNTLOTTONUMBER);
    }

    public void printErrorInputCountBonusNumber() {
        System.out.println(ERRORINPUTBONUSNUMBER);
    }

    public void printBuyCountLotto(int countLotto) {
        System.out.println(countLotto + COUNTLOTTO);
    }
}