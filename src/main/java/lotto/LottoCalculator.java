package lotto;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {

    public List<List<Integer>> checkNumbers(List<Lotto> lottoList, List<List<Integer>> userLottoList) {
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
        return totalList;
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