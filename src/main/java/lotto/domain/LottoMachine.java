package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachine {
    public static final int MIN_LOTTO_NUM = 1;
    public static final int MAX_LOTTO_NUM = 45;
    public static final int QUANTITY_OF_LOTTO_DIGITS = 6;

    public Lotto generateLotto() {
        List<Integer> winningNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, QUANTITY_OF_LOTTO_DIGITS);

        OutputView outputView = new OutputView();
        outputView.printWinningNumbers(winningNumbers);

        return new Lotto(winningNumbers);
    }
}
