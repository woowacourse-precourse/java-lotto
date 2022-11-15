package lotto;

import java.util.List;

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
    }

    // TODO: 추가 기능 구현
    public List<Integer> winSevenNumber(String bonusNumber) {

        this.numbers.add(Integer.parseInt(bonusNumber));

        return this.numbers;
    }

    public int compareWinNumberAndLottoPaperPoint (List<Integer> LottoPaperLine) {
        int rankNumber = 0;

        for (int i = 0; i < 6; i++) {
            if (LottoPaperLine.contains(numbers.get(i))) {
                rankNumber++;
            }
        }

        if (LottoPaperLine.contains(numbers.get(6))) {
            rankNumber += 100;
        }

        return rankNumber;
    }
}
