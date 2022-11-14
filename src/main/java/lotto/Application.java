package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = -1;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR]");
            return ;
        }

        validate(money);

        int numberOfLotto = money / 1000;

        List<Lotto> lottos = perChaseLotto(numberOfLotto);

    }

    public static void validate(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static List<Lotto> perChaseLotto(int numberOfLotto) {
        List<Lotto> result = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            result.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return result;
    }
}
