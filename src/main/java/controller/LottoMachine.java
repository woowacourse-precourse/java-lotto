package controller;

import camp.nextstep.edu.missionutils.Console;
import data.LottoData;
import controller.LottoMaker;
import java.util.List;
import java.util.ArrayList;
import controller.NumberParser;
import lotto.Lotto;
import data.PrintData;
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
        PrintData.printData("INPUT_MONEY");
        System.out.println();
        LottoMaker cashReader = new LottoMaker(inputRawData());
        lottos = cashReader.publishLotto();
        System.out.print(lottos.size());
        PrintData.printData("BUY_LOTTO");
        System.out.println();
    }

    public void inputWinningNumbers() {
        PrintData.printData("INPUT_NUMBER");
        System.out.println();
        numberParser.setWinningNumbers(inputRawData());
    }

    public void inputBonusNumber() {
        PrintData.printData("INPUT_BONUS");
        System.out.println();
        numberParser.setBonusNumber(inputRawData());
    }

    public String inputRawData(){
        String rawData = Console.readLine();
        return rawData;
    }

    public void drawLottos() {
        for(LottoData data : LottoData.values()){
            //if(data.getWinningAmount() == 5){
                System.out.println(data.toString());
            //}
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
