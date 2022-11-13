package lotto;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoCalculator {

    LottoConsole lottoConsole = new LottoConsole();

    public List<Integer> checkWinningLotto(List<List<Integer>> totalList) {
        List<Integer> winningList = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        for (int i = 0; i < totalList.get(0).size(); i++) {
            matchLottoCondition(totalList.get(0).get(i),totalList.get(1).get(i), winningList);
        }
        lottoConsole.outputResult(winningList);
        return winningList;
    }

    public void checkNumbers(List<Lotto> lottoList, List<List<Integer>> userLottoList) {
        List<Integer> luckyList = new ArrayList<>();
        List<Integer> bonusList = new ArrayList<>();
        List<List<Integer>> totalList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            List<Integer> winningList = checkWinningLotto(lotto, userLottoList);
            luckyList.add(winningList.get(0));
            bonusList.add(winningList.get(1));
        }

        totalList.add(luckyList);
        totalList.add(bonusList);
        checkWinningLotto(totalList);
    }

    private List<Integer> matchLottoCondition(int luckyNumber,int bonusNumber, List<Integer> winningList) {
        if (luckyNumber == 3) {
            winningList.set(0,winningList.get(0)+1);
        }
        if (luckyNumber == 4) {
            winningList.set(1,winningList.get(1)+1);
        }
        if (luckyNumber == 5 && bonusNumber == 0) {
            winningList.set(2,winningList.get(2)+1);
        }
        if (luckyNumber == 5 && bonusNumber == 1) {
            winningList.set(3,winningList.get(3)+1);
        }
        if (luckyNumber == 6) {
            winningList.set(4,winningList.get(4)+1);
        }
        return winningList;
    }

    private int checkEqualNumbers(int number1, int number2) {
        if (number1 == number2) {
            return 1;
        }
        return 0;
    }

    private List<Integer> checkWinningLotto(Lotto lotto, List<List<Integer>> userLottoList) {
        List<Integer> winningList = new ArrayList<>();
        int luckyCount = 0;
        int bonusCount = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            bonusCount += checkEqualNumbers(lotto.getNumbers().get(i), userLottoList.get(1).get(0));
            for (int j = 0; j < lotto.getNumbers().size(); j++) {
                luckyCount += checkEqualNumbers(lotto.getNumbers().get(i), userLottoList.get(0).get(j));
            }
        }
        winningList.add(luckyCount);
        winningList.add(bonusCount);

        return winningList;
    }


}