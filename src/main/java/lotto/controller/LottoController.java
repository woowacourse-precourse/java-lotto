package lotto.controller;

import lotto.model.Issue.LottoIssue;
import lotto.model.Issue.LottoIssueImpl;
import lotto.model.Issue.WinningNumbersIssue;
import lotto.model.Issue.WinningNumbersIssueImpl;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.model.statistics.Matcher;
import lotto.model.statistics.MatcherImpl;
import lotto.utils.EventMessage;
import lotto.view.input.Input;
import lotto.view.input.InputImpl;
import lotto.view.output.Output;
import lotto.view.output.OutputImpl;

import java.math.BigDecimal;
import java.util.List;

public class LottoController {

    private final Input input;
    private final Output output;

    public LottoController(){
        this.input = new InputImpl();
        this.output = new OutputImpl();
    }

    public void run(){
        try {
            String money = purchaseStep();
            List<Lotto> issuedLotto = issueStep(money);
            WinningNumbers winningNumber = setWinningNumbers();
            statisticsStep(issuedLotto, winningNumber, money);
        }catch (IllegalArgumentException exception){
            output.printErrorMessage(exception);
        }
    }

    private String purchaseStep(){
        output.printEventMessage(EventMessage.PURCHASE_AMOUNT);
        return input.moneyInput();
    }

    private List<Lotto> issueStep(String money){
        LottoIssue lottoIssue = new LottoIssueImpl(money);
        List<Lotto> issuedLotto = lottoIssue.getLotto();
        output.printPurchaseMessage(lottoIssue.getCount());
        output.printIssuedLotto(issuedLotto);
        return issuedLotto;
    }

    private WinningNumbers setWinningNumbers(){
        output.printEventMessage(EventMessage.WINNING_NUMBERS);
        String winningNumbers = input.winningNumbersInput();
        output.printEventMessage(EventMessage.BONUS_NUMBERS);
        String bonusNumber = input.BonusNumberInput();

        WinningNumbersIssue winningNumbersIssue = new WinningNumbersIssueImpl(winningNumbers,bonusNumber);
        return winningNumbersIssue.getWinningNumbers();
    }
    private void statisticsStep(List<Lotto> issuedLotto,WinningNumbers winningNumber,String money){
        Matcher matcher = new MatcherImpl(issuedLotto,winningNumber, new BigDecimal(money));
        output.printStatistics(matcher.getStatistics());
    }
}
