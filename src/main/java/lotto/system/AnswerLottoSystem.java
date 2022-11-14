package lotto.system;

import lotto.domain.lotto.AnswerLotto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class AnswerLottoSystem {

    private final String MESSAGE_INPUT_ANSWER_NUMBER = "당첨 번호를 입력해 주세요.";
    private final String MESSAGE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final IoSystem io;

    public AnswerLottoSystem(IoSystem ioSystem) {
        this.io = ioSystem;
    }

    private Lotto generateLotto(final String input) {
        return new Lotto(input);
    }

    public AnswerLotto generateAnswerLotto() {
        this.printInputAnswerLottoMessage();
        var lotto = this.generateLotto(io.input());

        this.printInputBonusNumberMessage();
        var bonusNumber = new LottoNumber(io.input());

        return new AnswerLotto(lotto, bonusNumber);
    }

    private void printInputBonusNumberMessage() {
        io.printBeforeNextLine(MESSAGE_INPUT_BONUS_NUMBER);
        io.println("");
    }

    private void printInputAnswerLottoMessage() {
        io.printBeforeNextLine(MESSAGE_INPUT_ANSWER_NUMBER);
        io.println("");
    }


}
