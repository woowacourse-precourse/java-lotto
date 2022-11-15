package controller;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberCreator {
    public Lotto lotto;

    public static final int ONE_THOUSAND = 1000;

    public static int DivideMoneyBy1000(int purchasingMoney) {
        if (purchasingMoney % ONE_THOUSAND != 0) {
            throw new IllegalArgumentException();
        }
        int chance = purchasingMoney / ONE_THOUSAND;
        view.OutputView.showMadePurchase(chance);
        return chance;
    }

    public static List<List<Integer>> MakeRandomNumber(int chance) {
        List<List<Integer>> randomNumbersContainer = new ArrayList<>();
        for (int i = 0; i < chance; i++) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(randomNumbers);
            Lotto lotto = new Lotto(randomNumbers);
            Lotto.isDifferentEachOther(lotto.getNumbers());
            view.OutputView.showRandomLottoNumbers(lotto.getNumbers());
            randomNumbersContainer.add(randomNumbers);
        }
        return randomNumbersContainer;
    }
}
