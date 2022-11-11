package lotto;

import camp.nextstep.edu.missionutils.Console;
import input.LottoMaker;
import java.util.List;
import java.util.ArrayList;
import input.NumberParser;

public class LottoMachine {
    private final NumberParser numberParser = new NumberParser();
    private List<Lotto> lottos = new ArrayList<>();
    private List<Integer> winningNumbers;
    private int bonusNumber;
    public void start(){
        inputCash();
        inputWinningNumbers();
        inputBonusNumber();
    }

    public void inputCash() {
        String rawMoney = Console.readLine();
        LottoMaker cashReader = new LottoMaker(Integer.parseInt(rawMoney));
        lottos = cashReader.publishLotto();
    }

    public void inputWinningNumbers() {
        winningNumbers = numberParser.getWinningNumbers();
    }

    public void inputBonusNumber() {
        bonusNumber = numberParser.getBonusNumber();
    }
}
