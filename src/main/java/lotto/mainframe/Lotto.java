package lotto.mainframe;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[Error] 발행된 로또 번호는 6개로 이루어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void addLotto() {
        User.setLotteries(numbers);
    }
}
