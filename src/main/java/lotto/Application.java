package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);
        // System.out.println(lotto.getNumbers());
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int pickNumber = Integer.parseInt(Console.readLine());
        System.out.println(pickNumber);
        if ( pickNumber % 1000 != 0 ){
            throw new IllegalArgumentException("예외");
        }
    }
}
