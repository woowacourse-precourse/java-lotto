package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = readLine();

        LottoMachine game = new LottoMachine();
        List<List<Integer>> LottoPaper = game.makeBuyLottoPaper(inputMoney);
        Display.displayLottoPaper(LottoPaper);
    }
}
