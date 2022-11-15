package controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;
import lotto.Lotto;
import data.InputGuideData;
import data.WinningData;

/**
 * 로또 프로그램의 전체적인 진행을 맡는 클래스
 */
public class LottoMachine {
    private final NumberParser numberParser = new NumberParser();
    private List<WinningData> winningData = new ArrayList<>(); // 몇개의 숫자가 일치하고 보너스 숫자가 있는지 확인하는 리스트
    private List<Lotto> lottos = new ArrayList<>();
    public void start(){
        inputCash();
        inputWinningNumbers();
        inputBonusNumber();
        countLottoNumber();
        printWinningDataToPrize();
    }

    public void inputCash() {
        InputGuideData.INPUT_MONEY.printData();
        LottoMaker cashReader = new LottoMaker(inputRawData());
        lottos = cashReader.publishLotto();
    }


    public void inputWinningNumbers() {
        InputGuideData.INPUT_NUMBER.printData();
        numberParser.setWinningNumbers(inputRawData());
    }

    public void inputBonusNumber() {
        InputGuideData.INPUT_BONUS.printData();
        numberParser.setBonusNumber(inputRawData());
    }

    public String inputRawData(){
        String rawData = Console.readLine();
        rawData = rawData.replaceAll("\\s", ""); // 공백 제거
        return rawData;
    }

    /**
     * 로또 당첨 번호 개수, 보너스 있는지 체크
     */
    public void countLottoNumber() {
        int winningCount;
        boolean isHavingBonus;
        for(Lotto lotto : lottos){
            winningCount = lotto.getNumberOfWins(numberParser.getWinningNumbers()); // 당첨번호와 일치하는 로또 번호 갯수 저장
            isHavingBonus = lotto.isHavingBonusNumber(numberParser.getBonusNumber()); // 보너스번호와 일치하는지 여부 저장
            winningData.add(new WinningData(winningCount, isHavingBonus));
        }
    }

    /**
     * 당첨 내역을 출력
     */
    public void printWinningDataToPrize(){

    }
    /**
     * 수익률 계산
     */
    public void printProfitRate(){
        int money = 0;
    }
}
