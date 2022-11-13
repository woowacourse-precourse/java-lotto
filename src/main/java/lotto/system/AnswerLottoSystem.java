package lotto.system;

import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class AnswerLottoSystem {

    private final IoSystem io;

    public AnswerLottoSystem(IoSystem ioSystem) {
        this.io = ioSystem;
    }

    private Lotto generateLotto(final String input) {
        return new Lotto(input);
    }

    public AnswerLotto generateAnswerLotto() {
        return new AnswerLotto(
                this.generateLotto(io.input()),
                new LottoNumber(io.input())
        );
    }

}
