package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Exceptions;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    public static List<List<Integer>> pickLottoNumbers(int countLotto) {
        List<List<Integer>> lottoList = new ArrayList<>();
        for (int i = 0; i < countLotto; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto.getNumbers());
            lottoList.add(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
        return lottoList;
    }

    public static List<String> getWinningNumbers(String readLine) {
        List<String> winningNumbers;

        winningNumbers = List.of(readLine.split(","));
        Exceptions.excludeNoLottoNumbers(winningNumbers);
        return winningNumbers;
    }

    public static List<String> getBonusNumber(String readLine) {
        List<String> bonusNumber = new ArrayList<>();

        Exceptions.getOutExcludingNumbers(readLine);
        bonusNumber.add(readLine);
        return bonusNumber;
    }

}
