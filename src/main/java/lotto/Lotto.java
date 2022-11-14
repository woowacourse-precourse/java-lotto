package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        checkDuplication(numbers);

        for (Integer number : numbers) {
            checkNumberRange(number);
        }
    }

    public void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력할 수 있습니다.");
        }
    }

    private void checkNumberRange(int n) {
        if (n < 1 || n > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplication(List<Integer> lottoNumbers) {
        HashSet<Integer> hashSet = new HashSet<>(lottoNumbers);

        if (hashSet.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public List<List<Integer>> generateLottoNumber(int theNumberOfLotto) {
        List<List<Integer>> generatedLottoNumber = new ArrayList<>();
        for (int i = 0; i < theNumberOfLotto; i++) {
            generatedLottoNumber.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return generatedLottoNumber;
    }

    public int checkNumberMatch(int target, int inputNumber) {
        if (target == inputNumber) {
            return 1;
        }
        return 0;
    }

    public int getIndividualLottoScore(List<Integer> lotto, int bonus) {
        int matchCount = 0;

        for (int i = 0; i < 6; i++) {
            matchCount += checkNumberMatch(numbers.get(i), lotto.get(i));
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

        return String.format("%.1f", (double) totalPrize / totalPayment);
    }

}
