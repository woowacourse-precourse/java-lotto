package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        Player player = new Player();
        player.buyLotto(money);

        player.printPublishLotto();
    }
}
