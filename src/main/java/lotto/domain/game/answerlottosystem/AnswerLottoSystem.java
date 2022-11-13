package lotto.domain.game.answerlottosystem;

import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.system.IoSystem;

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
