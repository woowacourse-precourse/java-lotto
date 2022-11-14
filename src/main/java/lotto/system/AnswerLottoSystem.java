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
        io.printBeforeNextLine("당첨 번호를 입력해 주세요.");
        io.println("");
        var lottoInput = io.input();

        io.printBeforeNextLine("보너스 번호를 입력해 주세요");
        io.println("");

        var bonusInput = io.input();

        return new AnswerLotto(
                this.generateLotto(lottoInput),
                new LottoNumber(bonusInput)
        );
    }

}
