package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String money = Console.readLine();
            buyLotto(money);

//        System.out.println("당첨 번호를 입력해 주세요.");
//        String winningNumber = Console.readLine();
//
//        System.out.println("보너스 번호를 입력해 주세요.");
//        String bonusNumber = Console.readLine();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    static void buyLotto(String money) {
        int numberOfLotto = calculate(money);
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        Set<Lotto> playerLotto = new HashSet<>();
        for(int i=0; i< numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            playerLotto.add(new Lotto(numbers));
        }

        for(Lotto lotto : playerLotto) {
            lotto.printLotto();
        }
    }

    static int calculate(String money) throws IllegalArgumentException {
        int numberOfLotto = 0;
        try {
            numberOfLotto = Integer.parseInt(money) / 1000;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
        if (numberOfLotto % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return numberOfLotto;
    }

}
