package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
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

    public static int buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        String Money = readLine();
        int numBuy = Integer.valueOf(Money)/1000;
        return numBuy;
    }
}
