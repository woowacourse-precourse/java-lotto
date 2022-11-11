package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLottos {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int PRICE = 1000;

    private List<Lotto> lottos;

    public PurchasedLottos(int purchasePrice) {
        validate(purchasePrice);
        int count = getCount(purchasePrice);
        createLottos(count);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    private void createLottos(int count) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottos.add(lotto);
        }
    }

    private void validate(int purchasePrice) {
        if (purchasePrice % PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
        }
    }

    private int getCount(int purchasePrice) {
        return purchasePrice / 1000;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, 6);
        sortRandomNumbers(randomNumbers);
        return randomNumbers;
    }

    private void sortRandomNumbers(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
    }
}
