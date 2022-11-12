package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNumber;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }


    public void sort() {
        numbers.sort(Comparator.naturalOrder());
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.WINNING_NUMBERS.getValue()) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호 개수는 %d 개만 가능합니다.", LottoEnum.WINNING_NUMBERS.getValue()));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR]중복되는 번호는 입력할 수 없습니다.");
        }
    }

    private void validateBonusNumberDuplicate(Integer bonusNumber) {
        if (this.numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR]보너스 번호가 기존 당첨 번호와 중복됩니다.");
        }
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
        for (int i = 0; i < amount; i++) {
            purchasedLotto.add(create());
        }
        return purchasedLotto;
    }

    private static void validatePurchaseAmount(final int amount) {
        if (amount % LottoEnum.PURCHASE_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] %d 단위로 구입이 가능합니다.", LottoEnum.PURCHASE_UNIT.getValue()));
        }
    }
}

