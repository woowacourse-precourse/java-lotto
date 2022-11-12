package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoVandingMachine lottoVM = new LottoVandingMachine();
        LottoMain lottoMain = new LottoMain();
        LottoWinning lottoWinning = new LottoWinning();

        //로또 구매
        List<List<Integer>> lottoList = lottoVM.buyLotto();

        //로또 추첨
        List<Integer> lottoAnswer = lottoMain.getLottoAnswer();

        int[] result = new int[5];
        //로또 추첨 결과
        for(List<Integer> lotto : lottoList)
        {
            int matchCount = lottoWinning.compareLotto(lotto, lottoAnswer);
            result = lottoWinning.getResult(result, matchCount);
        }

        //결과 출력
        lottoWinning.printResult(result);
    }
}
