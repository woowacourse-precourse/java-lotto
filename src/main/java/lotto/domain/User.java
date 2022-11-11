package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoError;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int purchaseAmount;
    private int earnedAmouont;
    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getEarnedAmouont() {
        return earnedAmouont;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    /**
     * 도메인 로직
     */
    public void inputPurchaseAmount(String input) {
        validate(input);
        this.purchaseAmount = Integer.parseInt(input);
    }

    public void createLottos() {
        int count = purchaseAmount / 1000;

        while (count-- > 0) {
            List<Integer> randoms = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randoms));
        }
    }

    private void validate(String input) {
        long numericLength = input.chars().filter(Character::isDigit).count();
        if (numericLength != input.length())
            throw new IllegalArgumentException(LottoError.NOT_NUMERIC.getErrorMessage());

        int money = Integer.parseInt(input);
        if (money % 1000 != 0)
            throw new IllegalArgumentException(LottoError.WRONG_UNIT_OF_WON.getErrorMessage());
    }
}
