package lotto;

import device.input.Input;
import device.output.Output;
import lotto.lotto.Lotto;
import lotto.lotto.LottoShop;
import lotto.message.InputRequestMessage;
import lotto.reward.RewardCoordinator;
import lotto.setting.LottoApplicationSetting;
import lotto.winningnumber.WinningNumber;
import java.util.List;

public class LottoApplication {

    private final Input input;
    private final Output output;
    private final LottoApplicationSetting setting;

    private Integer purchasePrice;
    private List<Lotto> lottos;

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
        buyLotto();
        showRewardResult();
    }

    private void buyLotto() {
        purchasePrice = inputInteger(InputRequestMessage.PURCHASE_AMOUNT);

        LottoShop lottoShop = setting.createLottoShop();
        lottos = lottoShop.buyLotto(purchasePrice);

        String lottosInfo = lottoShop.getLottoInfo(lottos);
        output.print(lottosInfo);
    }

    private void showRewardResult() {
        List<Integer> winningNumbers = inputIntegerList(InputRequestMessage.WINNING_NUMBER);
        List<Integer> bonusNumbers = inputIntegerList(InputRequestMessage.BONUS_NUMBER);

        WinningNumber winningNumber = setting.createWinningNumber(winningNumbers, bonusNumbers);
        RewardCoordinator rewardCoordinator = setting.createRewardCoordinator(winningNumber, purchasePrice);
        String rewardResult = rewardCoordinator.getRewardResult(lottos);
        output.print(rewardResult);
    }

    private Integer inputInteger(InputRequestMessage message) {
        output.print(message);
        return input.enterInteger();
    }

    private List<Integer> inputIntegerList(InputRequestMessage message) {
        output.print(message);
        return input.enterIntegerList();
    }
}
