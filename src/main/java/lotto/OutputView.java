package lotto;

import java.util.List;

public class OutputView {
    private static final String ERRORINPUTMONEY = "[ERROR] 구입금액은 1000원 단위로 입력되어야 합니다.";
    private static final String ERRORINPUTLOTTONUMBER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERRORINPUTCOUNTLOTTONUMBER = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";
    private static final String ERRORINPUTOVERLAPNUMBER ="[ERROR] 중복 번호는 입력할 수 없습니다.";
    private static final String COUNTLOTTO = "개를 구매했습니다.";
    private static final String INPUTMONEY = "구입금액을 입력해 주세요.";
    private static final String INPUTLOTTONUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUTBONUSNUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINRESULT = "당첨 통계";
    private static final String DIVISION = "---";
    public void printInputMoney() {
        System.out.println(INPUTMONEY);
    }
    public void printInputLottoNumber() {
        System.out.println(INPUTLOTTONUMBER);
    }
    public void printInputBonusNumber() {
        System.out.println(INPUTBONUSNUMBER);
    }
    public void printErrorInputMoney() {
        System.out.println(ERRORINPUTMONEY);
    }

    public void printErrorInputLottoNumber() {
        System.out.println(ERRORINPUTLOTTONUMBER);
    }

    public void printErrorInputOverlapNumber() {
        System.out.println(ERRORINPUTOVERLAPNUMBER);
    }

    public void printErrorInputCountLottoNumber() {
        System.out.println(ERRORINPUTCOUNTLOTTONUMBER);
    }

    public void printBuyCountLotto(int countLotto) {
        System.out.println(countLotto + COUNTLOTTO);
    }

    public void printRandomLottoNumber(List<List<Integer>> randomBoxNumbers) {
        for (int i=0;i<randomBoxNumbers.size();++i) {
            System.out.println(randomBoxNumbers.get(i));
        }
    }

    public void printWinResultLotto(List<Integer> countWin) {
        System.out.println(WINRESULT);
        System.out.println(DIVISION);
    }
}