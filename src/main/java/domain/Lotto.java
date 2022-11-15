package domain;

import java.util.ArrayList;
import java.util.List;

import Utils.Validator;

public class Lotto {
    private final List<Integer> numbers;
    private final Validator validator = new Validator();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        validator.sizeValidator(numbers);

        validator.checkDuplication(numbers);

        for (Integer number : numbers) {
            validator.checkNumberRange(number);
        }
    }

    public int getIndividualLottoScore(List<Integer> lotto, int bonus) {
        int matchCount = 0;

        for (int i = 0; i < 6; i++) {
            if (numbers.contains(lotto.get(i))) {
                matchCount += 1;
            }
        }

        if (matchCount < 3) {
            matchCount = -1;
        }

        if (matchCount == 5 && lotto.contains(bonus)) {
            matchCount = 7;
        }

        return matchCount;
    }

    public List<Integer> calculateLottoResult(List<List<Integer>> generatedLottoNumber, int bonus) {
        List<Integer> result = new ArrayList<>(List.of(0, 0, 0, 0, 0)); // 3, 4, 5, 6, 5 + b

        for (List<Integer> lotto : generatedLottoNumber) {
            int index = getIndividualLottoScore(lotto, bonus) - 3;
            if (index < 0) {
                continue;
            }
            result.set(index, result.get(index) + 1);
        }

        return result;
    }

    public String calculateYield(List<Integer> result, int totalPayment) {
        int totalPrize = 0;

        totalPrize += Prize.FIFTH.getPrize() * result.get(0);
        totalPrize += Prize.FOURTH.getPrize() * result.get(1);
        totalPrize += Prize.THIRD.getPrize() * result.get(2);
        totalPrize += Prize.SECOND.getPrize() * result.get(4);
        totalPrize += Prize.FIRST.getPrize() * result.get(3);

        return String.format("%.1f", (double) totalPrize / totalPayment * 100);
    }
}
