package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Person;
import lotto.domain.WinningLotto;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final Person person;
    private final WinningLotto winningLotto;

    public LottoController(LottoMachine lottoMachine, Person person, WinningLotto winningLotto) {
        this.lottoMachine = lottoMachine;
        this.person = person;
        this.winningLotto = winningLotto;
    }

}
