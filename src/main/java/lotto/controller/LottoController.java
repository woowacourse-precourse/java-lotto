package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LuckyNumber;
import lotto.domain.Prize;
import lotto.domain.User;
import lotto.service.LottoService;
import lotto.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import lotto.view.OutView;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoController {
    User user = new User();
    LuckyNumber luckyNumber = new LuckyNumber();

    public void buyLotto(){
        InputView.inputPurchaseAmount();
        user.inputPurchaseAmount(Console.readLine());
    }

    public void purchaseConfirmation(){
        user.setLotteryCount();
        OutView.numberOfPurchases(user.getLotteryCount());

        user.lotteryNumberGenerator();
        List<Lotto> lotteryNumbers = user.getLotteryNumbers();
        for(int i=0; i<user.getLotteryCount(); i++){
            System.out.println(lotteryNumbers.get(i).getNumbers());
        }
    }

    public void setLuckyNumber(){
        InputView.inputLuckyNumber();
        luckyNumber.inputLuckyNumber(Console.readLine());


        InputView.inputBonusNumber();
        luckyNumber.inputBonusNumber(Console.readLine());
    }

    public void winStatisticsCheck(){
        LinkedHashMap<Prize, Integer> history =
                LottoService.lottoNumberComparison(user.getLotteryNumbers(), luckyNumber);
        String yield = LottoService.yieldCalculation(history, user.getPurchaseAmount());
        OutView.winningStatistics(history,yield);

    }
}
