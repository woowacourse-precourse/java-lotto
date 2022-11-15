package controller;

import lotto.Lotto;
import lotto.LottoFactory;
import lotto.LottoMoney;
import lotto.WinningNumbers;
import lotto.result.LotteryResult;
import utils.Util;
import view.Input;
import view.Output;

import java.util.List;

public class LotteryController {

    private LotteryController() {
    }

    public static LotteryController create() {
        return new LotteryController();
    }

    public void run() {
        // 구입 금액
        LottoMoney lottoMoney = makeLottoMoney();
        int count = lottoMoney.lotteryCount();
        List<Lotto> lottoTickets = makeLottos(count);
        // x개를 구매 했습니다.
        Output.printBoughtLotteryNumber(count);
        // 랜덤 번호 출력
        Output.printRandomLotteryNumber(lottos());
        //당첨 번호, 보너스 번호 입력
        WinningNumbers winNumbers = makeWinNums();

        LotteryResult result = LotteryResult.of(lottoTickets, winNumbers);
        end(result, lottoMoney);
    }

}
