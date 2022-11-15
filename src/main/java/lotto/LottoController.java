package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Person;
import lotto.domain.WinningLotto;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final Person person;

    public LottoController(LottoMachine lottoMachine, Person person) {
        this.lottoMachine = lottoMachine;
        this.person = person;
    }

    public void runLotto() {
        person.buyLottos(lottoMachine);
        WinningLotto winningLotto = WinningLotto.getInstance();

    }

}
