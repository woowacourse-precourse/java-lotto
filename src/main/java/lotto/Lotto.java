package lotto;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
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

    public static void game(){
        int cost;
        Output.printCost();
        cost = Integer.parseInt(Console.readLine());
        int cnt = Output.printOrder(cost);
        MakeLotto.totallotto(cnt);

        //로또 생성



    }
    // TODO: 추가 기능 구현
}
