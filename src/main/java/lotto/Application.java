package lotto;

import lotto.function.*;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        int lottoNumber = purchase.lottoNumber();
        System.out.println(lottoNumber + "개를 구매했습니다.");
        MakeLotto makelotto = new MakeLotto();

        List<Lotto> lottoList = makelotto.lottoCreate(lottoNumber);
        makelotto.printLottoList();

        SetWinnerNumber setNumber = new SetWinnerNumber();
        setNumber.setWinnerNumber();
        setNumber.setBonusNumber();

        List<Integer> winnerNum = setNumber.getWinnerNumber();
        int bonusNum = setNumber.getBonusNumber();

        CompareLotto compareLotto = new CompareLotto();

        compareLotto.lottoListCompare(lottoList, winnerNum, bonusNum);

        HashMap<Integer, Integer> lottoRate = compareLotto.lottoRate;

        ResultPrint resultPrint = new ResultPrint(lottoRate, lottoNumber);
        resultPrint.printRate();
        resultPrint.totalProfit();

    }
}
