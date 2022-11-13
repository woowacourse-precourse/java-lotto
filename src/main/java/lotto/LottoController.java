package lotto;

import lotto.domain.LottoService;
import lotto.ui.LottoInput;
import lotto.ui.LottoOutput;

import java.util.List;

public class LottoController {
    private LottoInput input = new LottoInput();
    private LottoOutput output = new LottoOutput();
    private LottoService service = new LottoService();

    public void initLotto() {
        List<Integer> winningNumber = input.readWinningNumber();

    }
}
