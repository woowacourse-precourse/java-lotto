package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(
                LottoEnum.MIN_NUMBER.getValue(),
                LottoEnum.MAX_NUMBER.getValue(),
                LottoEnum.WINNING_NUMBERS.getValue()
        ));
    }


    public static List<Lotto> purchase(final int num) {
        validatePurchaseAmount(num);

        List<Lotto> purchasedLotto = new ArrayList<>();

        int amount = num / LottoEnum.PURCHASE_UNIT.getValue();
        for(int i = 0; i < amount; i++){
            purchasedLotto.add(create());
        }
        return purchasedLotto;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private static void validatePurchaseAmount(final int amount) {
        if (amount % LottoEnum.PURCHASE_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] %d 단위로 구입이 가능합니다.", LottoEnum.PURCHASE_UNIT.getValue()));
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}

