package lotto.domain.result;

import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResult {
    public static List<Integer> getMatchingCountOfAllLottos(List<Lotto> lottos, List<Integer> winningNumbers) {
        List<Integer> matchingCountOfAllLottos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            List<Integer> eachLotto = lotto.getNumbers();

            int cnt = getEachLottoMatchingCount(eachLotto, winningNumbers);

            matchingCountOfAllLottos.add(cnt);
        }

        return matchingCountOfAllLottos;
    }

    public static List<Boolean> getBonusNumberMatchingOfAllLottos(List<Lotto> lottos, int bonusNumber) {
        List<Boolean> bonusNumberMatchingOfAllLottos = new ArrayList<>();

        for (Lotto lotto : lottos) {
            List<Integer> eachLotto = lotto.getNumbers();

            if (eachLotto.contains(bonusNumber)) {
                bonusNumberMatchingOfAllLottos.add(true);
                continue;
            }

            bonusNumberMatchingOfAllLottos.add(false);
        }

        return bonusNumberMatchingOfAllLottos;
    }

    public static int getEachLottoMatchingCount(List<Integer> lotto, List<Integer> winningNumbers) {
        List<Integer> matchingElements = winningNumbers.stream()
                .filter(lotto::contains)
                .collect(Collectors.toList());

        return matchingElements.size();
    }
}
