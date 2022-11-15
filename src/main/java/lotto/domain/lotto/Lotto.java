package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자로 이루어져야 합니다.");
        }

        for (int i = 0; i < 5; i++) {
            int cur = numbers.get(i);
            int next = numbers.get(i + 1);

            if (cur == next) {
                throw new IllegalArgumentException("[ERROR] 로또의 수에는 중복이 있을 수 없습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoPrize play(List<Integer> winningNumbers) {
        long count = 0;
        boolean bonus = false;

        for (int i = 0; i < winningNumbers.size(); i++) {
            int cur = winningNumbers.get(i);

            if (numbers.contains(cur)) {
                count += 1;

                if (i == winningNumbers.size() - 1) {
                    bonus = true;
                }
            }
        }

        return LottoPrize.checkPrize(count, bonus);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lotto) {
            Lotto lotto = (Lotto) obj;

            if (Objects.equals(numbers, lotto.numbers)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        StringBuilder lotteryPrinter = new StringBuilder();

        lotteryPrinter.append("[");

        for (Integer number : numbers) {
            lotteryPrinter.append(number);

            if (!isLastNumber(number)) {
                lotteryPrinter.append(", ");
            }
        }

        lotteryPrinter.append("]");

        return lotteryPrinter.toString();
    }

    private boolean isLastNumber(Integer number) {
        int LAST_LOTTO_NUMBER = 6;
        return number.equals(numbers.get(LAST_LOTTO_NUMBER - 1));
    }
}
