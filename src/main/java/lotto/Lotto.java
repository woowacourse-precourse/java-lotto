package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private int lottoMoney = 0;
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
    // 로또 구입 금액을 입력한다
    // 입력했을 때, 1000원 단위가 맞는지 확인한다.
    public int inputLottoPurchaseMoney(){
        lottoMoney = Integer.parseInt(Console.readLine());
        return lottoMoney;
    }
}
