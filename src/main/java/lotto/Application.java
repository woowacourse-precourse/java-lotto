package lotto;

import camp.nextstep.edu.missionutils.Console;
import domain.LottoFactory;
import domain.Lottos;
import domain.WinningNumber;
import dto.LottosDto;
import view.InputUtil;
import view.OutputUtil;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void buyLottos() {
        OutputUtil.noticePurchase();
        Integer purchase = InputUtil.inputNumber();
        Lottos lottos = LottoFactory.makeLottos(purchase);
        LottosDto lottosDto = lottos.sendDto();
        OutputUtil.showPurchaseResult(lottosDto);
    }
    public static void inputWinningNumbers(){
        OutputUtil.winningNumberNotice();
        List<Integer> mainNumbers = InputUtil.inputWinningNumbers();
        OutputUtil.noticeBonus();
        Integer bonus = InputUtil.inputNumber();
        WinningNumber winningNumber = new WinningNumber(mainNumbers,bonus);
    }
    public static void main(String[] args) {
        buyLottos();
        inputWinningNumbers();
    }
}
