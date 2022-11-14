package lotto.system;

import lotto.calculation.Winning;
import lotto.generation.Lotto;
import lotto.generation.LottoGenerator;

import javax.swing.*;
import java.util.List;

public class Program {

    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final Parser parser = new Parser();

    public void startProgram() {
        int purchaseAmount = SystemUi.getPurchaseAmount();
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        SystemUi.printLotto(lottos);
    }

    public void winningProgram() {
        String winningNumber = SystemUi.getWinningNumber();
        Winning winning = new Winning(parser.parseWinningNumbers(winningNumber));
    }
}
