package lotto.Domain;

import lotto.IO.BonusIOHandler;
import lotto.IO.CashIOHandler;
import lotto.IO.LottoIOHandler;

public class Application {
    public static void main(String[] args) {
        try {
            CashIOHandler cashier = new CashIOHandler();
            cashier.setUserCash();
            LottoMaker lottoMaker = new LottoMaker(cashier.getLotteryAmount());
            lottoMaker.issueLottoTickets();
            LottoIOHandler lottoIOHandler = new LottoIOHandler();
            Lotto lottoAnswer = new Lotto(lottoIOHandler.getLottoAnswer());
            BonusIOHandler bonusIOHandler = new BonusIOHandler();
            Bonus bonus = new Bonus(bonusIOHandler.getUserBonus(lottoAnswer));
            LottoCalculator calculator = new LottoCalculator();
            lottoIOHandler.printResult(calculator.lottoComparator(lottoMaker, lottoAnswer, bonus), cashier.getPurchaseAmount());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}