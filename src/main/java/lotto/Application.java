package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.LottoException;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.LottoGenerator;
import lotto.model.Winner;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        LottoException exception = new LottoException();
        OutputView outputView = new OutputView();
        Winner winner = new Winner();
        winner.checkLottoWinningNumber("46,2,3,4,5,6");
    }
}
