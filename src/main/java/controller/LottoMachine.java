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
        checkLottoNumber();

        calculateProfitRate();
    }

    public void inputCash() {
        InputGuideData.printData("INPUT_MONEY");
        LottoMaker cashReader = new LottoMaker(inputRawData());
        lottos = cashReader.publishLotto();
    }


    public void inputWinningNumbers() {
        InputGuideData.printData("INPUT_NUMBER");
        numberParser.setWinningNumbers(inputRawData());
    }

    public void inputBonusNumber() {
        InputGuideData.printData("INPUT_BONUS");
        numberParser.setBonusNumber(inputRawData());
    }

    public String inputRawData(){
        String rawData = Console.readLine();
        return rawData;
    }

    /**
     * 로또 당첨 번호 개수 계산
     */
    public void checkLottoNumber() {

    }

    /**
     * 수익률 계산
     */
    public void calculateProfitRate(){
        int money = 0;
    }
}
