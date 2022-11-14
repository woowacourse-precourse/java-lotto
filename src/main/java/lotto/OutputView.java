package lotto;

import java.util.List;

public class OutputView {
    private static final String COUNTLOTTO = "개를 구매했습니다.";
    private static final String INPUTMONEY = "구입금액을 입력해 주세요.";
    private static final String INPUTLOTTONUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUTBONUSNUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINRESULT = "당첨 통계";
    private static final String DIVISION = "---";
    private static final String THREEWIN = "3개 일치 (5,000원) - ";
    private static final String FOURWIN = "4개 일치 (50,000원) - ";
    private static final String FIVEWIN = "5개 일치 (1,500,000원) - ";
    private static final String BONUSWIN = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIXWIN = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT = "개";
    private static final String RESULTRETURN = "총 수익률은 ";
    private static final String ISPERCENT = "%입니다.";
    public void printInputMoney() {
        System.out.println(INPUTMONEY);
    }
    public void printInputLottoNumber() {
        System.out.println(INPUTLOTTONUMBER);
    }
    public void printInputBonusNumber() {
        System.out.println(INPUTBONUSNUMBER);
    }

    public void printBuyCountLotto(int countLotto) {
        System.out.println(countLotto + COUNTLOTTO);
    }

    public void printRandomLottoNumber(List<List<Integer>> randomBoxNumbers) {
        for (List<Integer> randomBoxNumber : randomBoxNumbers) {
            System.out.println(randomBoxNumber);
        }
    }

    public void printWinResultLotto(int[] resultWin) {
        System.out.println(WINRESULT);
        System.out.println(DIVISION);
        System.out.println(THREEWIN + resultWin[0] + COUNT);
        System.out.println(FOURWIN + resultWin[1] + COUNT);
        System.out.println(FIVEWIN + resultWin[2] + COUNT);
        System.out.println(BONUSWIN + resultWin[3] + COUNT);
        System.out.println(SIXWIN + resultWin[4] + COUNT);
    }

    public void printResultReturn(float ResultReturn) {
        System.out.println(RESULTRETURN + String.format("%.1f", ResultReturn) + ISPERCENT);
    }
}