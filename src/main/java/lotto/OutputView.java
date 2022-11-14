package lotto;

import java.util.List;

public class OutputView {
    public void printInputMoney() {
        System.out.println(PrintUtil.INPUTMONEY.getMassages());
    }
    public void printInputLottoNumber() {
        System.out.println(PrintUtil.INPUTLOTTONUMBER.getMassages());
    }
    public void printInputBonusNumber() {
        System.out.println(PrintUtil.INPUTBONUSNUMBER.getMassages());
    }

    public void printBuyCountLotto(int countLotto) {
        System.out.println(countLotto + PrintUtil.COUNTLOTTO.getMassages());
    }

    public void printRandomLottoNumber(List<List<Integer>> randomBoxNumbers) {
        for (List<Integer> randomBoxNumber : randomBoxNumbers) {
            System.out.println(randomBoxNumber);
        }
    }

    public void printWinResultLotto(int[] resultWin) {
        System.out.println(PrintUtil.WINRESULT.getMassages());
        System.out.println(PrintUtil.DIVISION.getMassages());
        System.out.println(PrintUtil.THREEWIN.getMassages() + resultWin[0] + PrintUtil.COUNT.getMassages());
        System.out.println(PrintUtil.FOURWIN.getMassages() + resultWin[1] + PrintUtil.COUNT.getMassages());
        System.out.println(PrintUtil.FIVEWIN.getMassages() + resultWin[2] + PrintUtil.COUNT.getMassages());
        System.out.println(PrintUtil.BONUSWIN.getMassages() + resultWin[3] + PrintUtil.COUNT.getMassages());
        System.out.println(PrintUtil.SIXWIN.getMassages() + resultWin[4] + PrintUtil.COUNT.getMassages());
    }

    public void printResultReturn(float ResultReturn) {
        System.out.println(PrintUtil.RESULTRETURN.getMassages()
                + String.format("%.1f", ResultReturn) + PrintUtil.ISPERCENT.getMassages());
    }
}