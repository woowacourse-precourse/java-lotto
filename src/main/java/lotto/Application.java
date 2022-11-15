package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Player;
import lotto.domain.PlusLotto;
import lotto.exception.CustomException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int money = Integer.parseInt(Console.readLine());

            Player player = new Player();
            List<Lotto> playerLottos = player.buyLotto(money);

            player.printPublishLotto();

            System.out.println("당첨 번호를 입력해 주세요.");
            String[] inputNumbers = Console.readLine().split(",");
            List<Integer> pickNumbers = Arrays.stream(inputNumbers).map(Integer::parseInt).collect(Collectors.toList());
            Lotto pickLotto = new Lotto(pickNumbers);

            System.out.println("보너스 번호를 입력해 주세요.");
            int inputPlusNumber = Integer.parseInt(Console.readLine());
            PlusLotto pickPlusLotto = new PlusLotto(inputPlusNumber);

            HashMap<LottoResult, Integer> lottoResults =
                    player.compareLottos(playerLottos, pickLotto.getNumbers(), pickPlusLotto.getPlusNumber());

            player.printRankYield(lottoResults, money);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(CustomException.INVALID.getMessage());
        }
    }
}
