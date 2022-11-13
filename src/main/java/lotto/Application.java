package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    static int pay = 0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        buyLotto();
        //List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    public static void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        pay = Integer.parseInt(Console.readLine());
    }

}
