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
}
