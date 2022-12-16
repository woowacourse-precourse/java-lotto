package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public static List<List<Integer>> pickLottoNumbers(int countLotto) {
        List<List<Integer>> totalLotto = new ArrayList<>();
        for (int i = 0; i < countLotto; i++) {
            Lotto getLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            List<Integer> lotto = new ArrayList<>(getLotto.getNumbers());
            Collections.sort(lotto);
            totalLotto.add(lotto);
            System.out.println(lotto);
        }
        return totalLotto;
    }

    public static List<String> getWinningNumbers(String readLine) {
        List<String> winningNumbers;

        winningNumbers = List.of(readLine.split(","));
        Exceptions.excludeNoLottoNumbers(winningNumbers);
        return winningNumbers;
    }

    public static List<String> getBonusNumber(String readLine) {
        List<String> bonusNumber = new ArrayList<>();

        Exceptions.excludeNoBonusNumber(readLine);
        bonusNumber.add(readLine);
        return bonusNumber;
    }

}
