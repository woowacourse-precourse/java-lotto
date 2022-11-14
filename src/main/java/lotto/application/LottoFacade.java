package lotto.application;

import lotto.domain.Lotto;

import java.util.List;


public interface LottoFacade {
     List<Lotto> buyLotto(Integer money);

     Lotto registerWinLotto(String input);

     String getMargin(Integer before, Integer after);

     List<Integer> checkWinning(Lotto winLotto, List<Lotto> clientLotto, Integer bonus);
}
