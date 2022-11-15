package lotto;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoFactory;
import domain.Lottos;
import domain.Result;
import domain.WinningNumber;
import dto.LottosDto;
import dto.WinningNumberDto;
import view.InputUtil;
import view.OutputUtil;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static Lottos buyLottos() {
        OutputUtil.noticePurchase();
        Integer purchase = InputUtil.inputNumber();
        Lottos lottos = LottoFactory.makeLottos(purchase);
        LottosDto lottosDto = lottos.sendDto();
        OutputUtil.showPurchaseResult(lottosDto);
        return lottos;
    }
    public static WinningNumber inputWinningNumbers(){
        OutputUtil.winningNumberNotice();
        List<Integer> mainNumbers = InputUtil.inputWinningNumbers();
        OutputUtil.noticeBonus();
        Integer bonus = InputUtil.inputNumber();
        return new WinningNumber(mainNumbers,bonus);
    }

    public static void main(String[] args) {
        Lottos lottos = buyLottos();
        WinningNumberDto winningNumberDto = inputWinningNumbers().sendDTO();
        Result result = lottos.totalResult(winningNumberDto);
        OutputUtil.showResult(result);
    }
}
