package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            startMessage();
            Money money = new Money(Console.readLine());

            LottoGenerator lottoList = new LottoGenerator(money.getLottoCount());
            getLottosMessage();
            Lotto lotto = new Lotto(Arrays.asList(Console.readLine().split(",")).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()));

            getBonusNumberMessage();
            Integer bonus = Integer.parseInt(Console.readLine());

            getWinningStatusMessage();
            LottoWinning winningList = new LottoWinning(lotto.getLottoNumber(),bonus,lottoList.getLottoList(),money.getMoney());

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
        }
    }

    public static void startMessage() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void getLottosMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void getBonusNumberMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void getWinningStatusMessage() {
        System.out.println();
        System.out.println("당첨 통계\n"+"---");
    }
}
