package lotto.Domain;

import lotto.IO.BonusIOHandler;
import lotto.IO.CashIOHandler;
import lotto.IO.LottoIOHandler;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자로부터 금액을 입력받는다.
        CashIOHandler cashier = new CashIOHandler();
        cashier.setUserCash();

        // 금액만큼의 로또를 발행한다.
        LottoMaker lottoMaker = new LottoMaker(cashier.getLotteryAmount());
        lottoMaker.issueLottoTickets();
        lottoMaker.printLottoTickets();

        // 당첨 번호를 입력받는다.
        LottoIOHandler lottoIOHandler = new LottoIOHandler();
        Lotto lottoAnswer = new Lotto(lottoIOHandler.getLottoAnswer());

        // 보너스 번호를 입력받는다.
        BonusIOHandler bonusIOHandler = new BonusIOHandler();
        Bonus bonus = new Bonus(bonusIOHandler.getBonus());

        // 당첨 결과를 계산한다.
        LottoCalculator calculator = new LottoCalculator();
        List<Rank> rank = calculator.lottoComparator(lottoMaker, lottoAnswer, bonus);
        System.out.println(rank);

        // 수익률을 계산한다.

    }
}