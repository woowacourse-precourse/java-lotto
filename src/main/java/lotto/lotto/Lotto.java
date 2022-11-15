package lotto.lotto;

import java.util.LinkedList;
import java.util.List;
import lotto.user.User;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    public void setBonusNumber(String input) {
        LottoValidator.validateLottoNumber(input);
        numbers.add(Integer.parseInt(input));
        LottoValidator.validateDuplicateNumbers(numbers);
    }

    public void printResult(List<Lotto> lottos) {
        LottoPrinter printer = new LottoPrinter();
        for(Lotto lotto: lottos) {
            int matchedBalls = LottoComparator.getMatchedNumbers(numbers, lotto.getNumbers());
            boolean bonusMatched = LottoComparator.isBonusMatched(numbers, lotto.getNumbers());

            printer.addResult(matchedBalls, bonusMatched);
        }

        printer.printLottoResult();
    }
}
