package lotto;

import device.input.Input;
import device.output.Output;
import lotto.lotto.Lotto;
import lotto.message.InputRequestMessage;
import lotto.reward.RewardCoordinator;
import lotto.setting.LottoApplicationSetting;
import lotto.winningnumber.WinningNumber;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {

    private final Input input;
    private final Output output;
    private final LottoApplicationSetting setting;

    LottoApplication(Input input, Output output, LottoApplicationSetting setting) {
        this.input = input;
        this.output = output;
        this.setting = setting;
    }

    public void run() {
        try {
            runApplication();
        } catch (IllegalArgumentException exception) {
            output.print(exception.getMessage());
        }
    }

    private void runApplication() {
        Integer purchasePrice = inputInteger(InputRequestMessage.PURCHASE_AMOUNT);

        List<Lotto> lottos = setting.createLottoShop().buyLottoCreatedAuto(purchasePrice);
        printLottos(lottos);

        List<Integer> winningNumbers = inputIntegerList(InputRequestMessage.WINNING_NUMBER);
        List<Integer> bonusNumbers = inputIntegerList(InputRequestMessage.BONUS_NUMBER);

        WinningNumber winningNumber = setting.createWinningNumber(winningNumbers, bonusNumbers);
        RewardCoordinator rewardCoordinator = setting.createRewardCoordinator(winningNumber, purchasePrice);
        String result = rewardCoordinator.getRewardResult(lottos);
        printResults(result);
    }

    private Integer inputInteger(InputRequestMessage message) {
        output.print(message);
        return input.enterInteger();
    }

    private List<Integer> inputIntegerList(InputRequestMessage message) {
        output.print(message);
        return input.enterIntegerList();
    }

    private void printLottos(List<Lotto> lottos) {
        String lottosNumber = lottos.stream()
                .map(lotto -> lotto.getNumbers())
                .collect(Collectors.joining("\n"));

        output.print("\n" + lottos.size() + "개를 구매했습니다.");
        output.print(lottosNumber);
    }

    private void printResults(String result) {
        output.print("\n당첨통계\n---");
        output.print(result);
    }
}
