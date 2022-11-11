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
        drawLottos();
        printProfitRate();
    }

    public void inputCash() {
        LottoMaker cashReader = new LottoMaker(inputRawData());
        lottos = cashReader.publishLotto();
    }

    public void inputWinningNumbers() {
        winningNumbers = numberParser.getWinningNumbers(inputRawData());
    }

    public void inputBonusNumber() {
        bonusNumber = numberParser.getBonusNumber(inputRawData());
    }

    public String inputRawData(){
        String rawData = Console.readLine();
        return rawData;
    }

    public void drawLottos(){

    }

    public void printProfitRate(){

    }
}
