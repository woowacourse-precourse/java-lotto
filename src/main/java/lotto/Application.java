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
            Player player = new Player();
            System.out.println("구입금액을 입력해 주세요.");
            String money = Console.readLine();
            Set<Lotto> playerLotto = player.buyLotto(money);

            System.out.println("당첨 번호를 입력해 주세요.");
            String numbers = Console.readLine();
            List<Integer> winningNumber = player.split(numbers);

            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = Console.readLine();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

}
