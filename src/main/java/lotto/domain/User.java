package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final List<Lotto> lottos = new ArrayList<>();
    private int purchaseAmount;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void inputPurchaseAmount(String input) {
        validate(input);
        this.purchaseAmount = Integer.parseInt(input);
    }

    public List<Lotto> createLottos() {
        int count = purchaseAmount / 1000;

        while (count-- > 0) {
            List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randoms));
        }

        return lottos;
    }

    private void validate(String input) throws RuntimeException {
        long numericLength = input.chars()
                .filter(Character::isDigit)
                .count();
        if (numericLength != input.length())
            throw new IllegalArgumentException(LottoError.NOT_NUMERIC.getErrorMessage());

        int money = Integer.parseInt(input);
        if (money % 1000 != 0)
            throw new IllegalArgumentException(LottoError.WRONG_UNIT_OF_WON.getErrorMessage());
    }

}
