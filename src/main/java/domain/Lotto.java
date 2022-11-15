package domain;

import java.util.ArrayList;
import java.util.List;

import Utils.Validator;
import camp.nextstep.edu.missionutils.Randoms;

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

    public static List<List<Integer>> generateLottoNumber(int totalPayment) {
        int theNumberOfLotto = totalPayment / 1000;
        List<List<Integer>> generatedLottoNumber = new ArrayList<>();
        for (int i = 0; i < theNumberOfLotto; i++) {
            generatedLottoNumber.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return generatedLottoNumber;
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
        List<Integer> prizeValues = new ArrayList<>(List.of(5000, 50000, 1500000, 2000000000, 30000000));
        int totalPrize = 0;

        for (int i = 0; i < 5; i++) {
            totalPrize += prizeValues.get(i) * result.get(i);
        }
        return String.format("%.1f", (double) totalPrize / totalPayment * 100);
    }
}
