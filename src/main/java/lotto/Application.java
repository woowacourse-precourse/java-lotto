package lotto;

import java.util.List;
import lotto.controller.Calculator;
import lotto.model.BonusNumber;
import lotto.model.Lottery;
import lotto.model.Purchase;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.output.BuyListView;
import lotto.view.output.SummaryView;

public class Application {
    public static void main(String[] args) {
        try {
            String inputAmount = InputView.askPurchaseAmount();
            Purchase purchase = new Purchase(inputAmount);
            Lottery lottery = new Lottery(purchase.getAmount());
            BuyListView.show(lottery.getLotteryNumbers(), purchase.getAmount());

            String inputWinningNumbers = InputView.askWinningNumbers();
            WinningNumber wn = new WinningNumber(inputWinningNumbers);
            List<Integer> winningNumbers = wn.getWinningNumbers();

            String inputBonusNumber = InputView.askBonusNumber();
            BonusNumber bn = new BonusNumber(inputBonusNumber, winningNumbers);
            int bonusNumber = bn.getBonusNumber();

            Calculator cal = new Calculator();
            for (int i = 0; i < purchase.getAmount(); i++) {
                List<Integer> lotto = lottery.getLotteryNumbers().get(i).getLottoNumbers();
                cal.updateResult(lotto, winningNumbers, bonusNumber);
            }

            SummaryView.showResult(cal.firstWin, cal.secondWin, cal.thirdWin, cal.fourthWin, cal.fifthWin);
            SummaryView.showEarning(purchase.getAmount(), cal.firstWin, cal.secondWin, cal.thirdWin, cal.fourthWin,
                    cal.fifthWin);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
