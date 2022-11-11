package lotto;

import camp.nextstep.edu.missionutils.Console;
import data.LottoData;
import input.LottoMaker;
import java.util.List;
import java.util.ArrayList;
import input.NumberParser;

public class LottoMachine {
    private final NumberParser numberParser = new NumberParser();
    private List<Lotto> lottos = new ArrayList<>();
    public void start(){
        inputCash();
        inputWinningNumbers();
        inputBonusNumber();
        drawLottos();
        calculateProfitRate();
    }

    public void inputCash() {
        LottoMaker cashReader = new LottoMaker(inputRawData());
        lottos = cashReader.publishLotto();
    }

    public void inputWinningNumbers() {
        numberParser.setWinningNumbers(inputRawData());
    }

    public void inputBonusNumber() {
        numberParser.setBonusNumber(inputRawData());
    }

    public String inputRawData(){
        String rawData = Console.readLine();
        return rawData;
    }

    public void drawLottos() {
        for(LottoData data : LottoData.values()){
            if(data.getWinningAmount() == 5){
                System.out.println(data.toString());
            }
        }
    }

    public void checkWinningPrize(){
        int count;
        boolean isHavingBonus;
        for(Lotto lotto : lottos){
            count = lotto.getNumberOfWins(numberParser.getWinningNumbers());
            isHavingBonus = lotto.isHavingBonusNumber(numberParser.getBonusNumber());
        }
    }
    public void calculateProfitRate(){

    }
}
