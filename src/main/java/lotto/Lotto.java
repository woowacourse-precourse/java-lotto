package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNumber = null;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }



    public Integer matchWithList(List<Lotto> lottos, Integer matchAmount) {
        Integer matchingLottos = 0;
        for (Lotto lotto : lottos) {
            if (Objects.equals(this.match(lotto), matchAmount) && !bonusMatch(lotto)) {
                matchingLottos++;
            }
        }
        return matchingLottos;
    }

    public Integer matchWihListIncludeBonus(List<Lotto> lottos, Integer matchAmount) {
        Integer matchingLottos = 0;
        for (Lotto lotto : lottos) {
            if (Objects.equals(this.match(lotto), matchAmount) && bonusMatch(lotto)) {
                matchingLottos++;
            }
        }
        return matchingLottos;
    }

    public Integer match(Lotto lotto) {
        Integer matchAmount = 0;

        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            if (this.getNumbers().contains(number)) {
                matchAmount++;
            }
        }

        return matchAmount;
    }

    public boolean bonusMatch(Lotto lotto) {
        checkBonusNumberSet();
        return lotto.getNumbers().contains(this.bonusNumber);
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateBonusNumberDuplicate(bonusNumber);
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
        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR]보너스 번호가 기존 당첨 번호와 중복됩니다.");
        }
    }

    private void checkBonusNumberSet() {
        if (this.bonusNumber == null) {
            throw new IllegalArgumentException("[ERROR]보너스 번호가 입력되어 있지 않습니다.");
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

    public static double calculateBenefit(final Integer payed, final Integer earned) {
        return (double)earned / payed;
    }

    private static void validatePurchaseAmount(final int amount) {
        if (amount % LottoEnum.PURCHASE_UNIT.getValue() != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] %d 단위로 구입이 가능합니다.", LottoEnum.PURCHASE_UNIT.getValue()));
        }
    }
}

