package lotto.domain;

import lotto.verifier.LottoVerifier;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int compareWithAnotherLotto(Lotto another) {
        return another.compareWithNumberList(this.numbers);
    }

    public int compareWithNumberList(List<Integer> anotherNumbers) {
        return (int) numbers.stream()
                        .filter(old -> anotherNumbers.stream()
                        .anyMatch(Predicate.isEqual(old)))
                        .count();
    }


    public void printLottoInfo() {
        OutputView.printLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        String forCheck = numbers.toString();
        forCheck = forCheck.substring(1, forCheck.length() - 1);
        forCheck = forCheck.replaceAll(" ", "");
        new LottoVerifier().check(forCheck.strip());
    }
}
