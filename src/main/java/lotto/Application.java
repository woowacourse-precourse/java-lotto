package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.generator.RandomsNumberGenerator;
import lotto.manager.LottoManager;
import lotto.result.RewardEnum;
import lotto.ui.Input.ConsoleParameterInput;
import lotto.ui.text.DynamicText;

public class Application {
    public static void main(String[] args) {
        try {
            scenario();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Arrays.stream(e.getStackTrace()).forEach(System.out::println);
        }
    }

    private static void scenario() {
        LottoManager manager = new LottoManager(new RandomsNumberGenerator(), new ConsoleParameterInput());
        int lottoQuantity = manager.getQuantity();
        System.out.println();

        List<Lotto> lottoList = manager.buyLotto(lottoQuantity);
        System.out.println(DynamicText.totalQuantity(lottoQuantity));
        System.out.println(DynamicText.totalLotto(lottoList));
        System.out.println();

        WinningNumber winningNumber = manager.getWinningNumber();
        System.out.println();

        Map<RewardEnum, Integer> statistics = manager.makeStatistics(lottoList, winningNumber);
        System.out.println(DynamicText.statistics(statistics));
    }
}
