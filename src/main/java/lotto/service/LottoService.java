package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private static final int LOTTERY_PRICE = 1000;
    List<Lotto> lotto = new ArrayList<>();

    private static void addWinningHistory(int bonusNumber, int[] winningHistory, Lotto lottery) {
        if (lottery.getNumbers().size() == 0) {
            winningHistory[0]++;
        } else if (lottery.getNumbers().size() == 1) {
            if (lottery.getNumbers().contains(bonusNumber)) {
                winningHistory[1]++;
                return;
            }
            winningHistory[2]++;
        } else if (lottery.getNumbers().size() == 2) {
            winningHistory[3]++;
        } else if (lottery.getNumbers().size() == 3) {
            winningHistory[4]++;
        }
    }

    public int[] getWinningHistory(List<Integer> numbers, int bonusNumber) {
        int[] winningHistory = new int[5];
        for (Lotto lottery : lotto) {
            lottery.getNumbers().removeAll(numbers);
            if (lottery.getNumbers().size() >= 3) {
                addWinningHistory(bonusNumber, winningHistory, lottery);
            }
        }
        return winningHistory;
    }

    private List<Integer> setLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public void setLotto(int money) {
        while (money != 0) {
            lotto.add(new Lotto(setLottoNumbers()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList())));
            money -= LOTTERY_PRICE;
        }
    }
}
