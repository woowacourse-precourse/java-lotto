package lotto.Domain;

import lotto.IO.BonusIOHandler;
import lotto.IO.CashIOHandler;
import lotto.IO.LottoIOHandler;

public class LottoController {
    private LottoController(){}
    private static CashIOHandler cashier;
    private static LottoMaker lottoMaker;
    private static LottoIOHandler lottoIOHandler;
    private static Lotto lottoAnswer;
    private static Bonus bonus;


    private static class LottoConstructor {
        private static final LottoController INSTANCE = new LottoController();
    }
    public static LottoController getInstance(){
        return LottoConstructor.INSTANCE;
    }

    public void run(){
        pay();
        issueLotto();
        inputLottoAnswerBonus();
        printOutcome();
    }

    private void pay(){
        cashier = new CashIOHandler();
        cashier.setUserCash();
    }

    private void issueLotto(){
        lottoMaker = new LottoMaker(cashier.getLotteryAmount());
        lottoMaker.issueLottoTickets();
    }

    private void inputLottoAnswerBonus(){
        lottoIOHandler = new LottoIOHandler();
        lottoAnswer = new Lotto(lottoIOHandler.getLottoAnswer());

        BonusIOHandler bonusIOHandler = new BonusIOHandler();
        bonus = new Bonus(bonusIOHandler.getUserBonus(lottoAnswer));
    }
    private void printOutcome(){
        LottoCalculator calculator = new LottoCalculator();
        lottoIOHandler.printResult(calculator.lottoComparator(lottoMaker,lottoAnswer,bonus), cashier.getPurchaseAmount());
    }

}
