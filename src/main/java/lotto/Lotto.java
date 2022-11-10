package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 길이는 6으로 맞추어야 합니다.");
        } else if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다.");
        } else if (numbers.stream().anyMatch(s -> s>45 || s<1)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int purchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        if (amount <= 0) {
            throw new IllegalArgumentException("0보다 같거나 작은 수는 허용되지 않습니다.");
        } else if (amount%1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000 배수여야 합니다.");
        }
        return amount;
    }

    // TODO: 추가 기능 구현
}
