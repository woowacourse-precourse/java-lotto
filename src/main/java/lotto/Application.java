package lotto;

import lotto.model.BonusNumber;
import lotto.model.LottoTickets;
import lotto.model.WinningNumbers;

public class Application {
    public static void main(String[] args) {
        try {
            LottoTickets lottoTickets = Controller.createLottoTickets();
            WinningNumbers winningNumbers = Controller.createWinningLotto();
            BonusNumber bonusNumber = Controller.createBonusNumber(winningNumbers);
            Controller.createSummary(lottoTickets, winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
