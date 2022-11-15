package lotto;

import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningNumber;
import lotto.dto.LottosDto;
import lotto.dto.WinningNumberDto;
import lotto.view.InputUtil;
import lotto.view.OutputUtil;

import java.util.List;

public class Application {
    public static Lottos buyLottos() {
        OutputUtil.noticePurchase();
        Integer purchase = 0;
        purchase = InputUtil.inputNumber();
        Lottos lottos = LottoFactory.makeLottos(purchase);
        LottosDto lottosDto = lottos.sendDto();
        OutputUtil.showPurchaseResult(lottosDto);
        return lottos;
    }

    public static WinningNumber inputWinningNumbers() {
        OutputUtil.winningNumberNotice();
        List<Integer> mainNumbers = InputUtil.inputWinningNumbers();
        OutputUtil.noticeBonus();
        Integer bonus = InputUtil.inputNumber();
        return new WinningNumber(mainNumbers, bonus);
    }

    public static void main(String[] args) {
        try {
            Lottos lottos = buyLottos();
            WinningNumberDto winningNumberDto = inputWinningNumbers().sendDTO();
            Result result = lottos.totalResult(winningNumberDto);
            OutputUtil.showResult(result);
        } catch (IllegalArgumentException e) {
            OutputUtil.printError(e.getMessage());
        }

    }
}
