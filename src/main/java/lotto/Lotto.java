package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
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
    }

    // TODO: 추가 기능 구현
    public void getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());
        if (price % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
    }
}
