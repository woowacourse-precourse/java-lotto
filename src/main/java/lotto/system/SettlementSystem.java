package lotto.system;

import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.LotteryGroup;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.money.Money;

public class SettlementSystem {
   private final static String MESSAGE_ALL_PROFITS = "총 수익률은 %.1f%%입니다.";
    private final static String MESSAGE_WINNING_STATISTICS = "당첨 통계";
    private final static String MESSAGE_HYPHEN = "---";
    private final IoSystem io;

    private final LotteryGroup lotteryGroup;
    public SettlementSystem(IoSystem ioSystem) {
        this.io = ioSystem;
        this.lotteryGroup = new LotteryGroup();
    }

    public void printCalculateProfits(Money money) {
        Money profits = lotteryGroup.calculateProfits();
        io.printBeforeNextLine(String.format(MESSAGE_ALL_PROFITS, money.calculateROI(profits)));
    }


    public void printSettlementResult(LottoBundle lottoBundle, AnswerLotto answerLotto) {
        String result = lotteryGroup.settleResult(lottoBundle, answerLotto);

        io.printBeforeNextLine(MESSAGE_WINNING_STATISTICS);
        io.printBeforeNextLine(MESSAGE_HYPHEN);
        io.printBeforeNextLine(result);
    }




}
