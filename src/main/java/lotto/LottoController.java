package lotto;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class LottoController {
    
    public void run() {
        System.out.println("LottoController.run()");
        LottoMoney lottoMoney = new LottoMoney(InputLotto.inputPurchaseMoney());
        lottoMoney.calculateLottoTicketCount();
        int lottoTicketCount = lottoMoney.getLottoTicketCount();

        // Lotto winningNumber = new Lotto(InputLotto.inputWinningNumber());
        // LottoNumber bonusNumber = new LottoNumber(InputLotto.inputBonusNumber());
        // System.out.println(winningNumber.getLottoNumber());
        // System.out.println(bonusNumber.getLottoNumber());

        // DEBUG
        Lotto winningNumber = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);
        
        Lottos lottos = new Lottos(lottoTicketCount);
        for (Lotto lotto : lottos.getLottos()) {
            // System.out.println(lotto.getLottoNumber());
            // DEBUG
            Lotto numbers = new Lotto(List.of(1,2,3,4,5,7));
            int matchCount = numbers.compareWinningNumbers(winningNumber); // DEBUG: numbers -> lotto
            boolean hasBonusHit = numbers.compareBonusNumber(bonusNumber); // DEBUG: numbers -> lotto
            System.out.println(Rank.of(matchCount, hasBonusHit));
        }
    }
}
