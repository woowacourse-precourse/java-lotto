package lotto;

import java.util.List;
import lotto.domain.Calculator;
import lotto.domain.Lottery;
import lotto.input.BonusNumber;
import lotto.input.Input;
import lotto.input.Purchase;
import lotto.input.WinningNumber;
import lotto.output.BuyList;
import lotto.output.Summary;

public class Application {
    public static void main(String[] args) {
        try {
            String inputAmount = Input.askAmount();
            Purchase pc = new Purchase(inputAmount);
            Lottery lottery = new Lottery(pc.getAmount());
            BuyList.show(lottery.getLotteryNumbers(), pc.getAmount());

            String inputWinningNumbers = Input.askWinningNumbers();
            WinningNumber wn = new WinningNumber(inputWinningNumbers);
            List<Integer> winningNumbers = wn.getWinningNumbers();

            String inputBonusNumber = Input.askBonusNumber();
            BonusNumber bn = new BonusNumber(inputBonusNumber, winningNumbers);
            int bonusNumber = bn.getBonusNumber();

            Calculator cal = new Calculator();
            for (int i = 0; i < lottery.getLotteryNumbers().size(); i++) {
                List<Integer> lotto = lottery.getLotteryNumbers().get(i).getLottoNumbers();
                cal.updateResult(lotto, winningNumbers, bonusNumber);
            }

            Summary.showResult(cal.firstWin, cal.secondWin, cal.thirdWin, cal.fourthWin, cal.fifthWin);
            Summary.showEarning(pc.getAmount(), cal.firstWin, cal.secondWin, cal.thirdWin, cal.fourthWin, cal.fifthWin);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
