package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoRaffle {
    private List<Integer> lottodto;
    private List<Integer> countwindto;
    private List<List<Integer>> boxrandomdto;
    private String moneydto;
    private int countdto;
    private int bonusdto;
    private int[] resultwindto;
    public LottoRaffle() {
        readyMoney();
        readyLottoNumber();
        readyBonusNumber();
        outputWin();
    }
    public void setLotto(List<Integer> lottoNumber) { this.lottodto = lottoNumber; }
    public void setMoney(String money) { this.moneydto = money; }
    public void setCount(int count) { this.countdto = count; }
    public void setBoxRandom(List<List<Integer>> randomNumbers) { this.boxrandomdto = randomNumbers; }
    public void setCountWin(List<Integer> countWin) { this.countwindto = countWin; }
    public void setResultWin(int[] resultWin) { this.resultwindto = resultWin; }
    public void setBonus(int bonus) { this.bonusdto = bonus; }
    public void readyMoney() {
        OutputView outputView = new OutputView();
        DataProcessing dataProcessing = new DataProcessing();
        inputMoney();
        countLotto(dataProcessing.conversionMoney(moneydto));
        outputView.printBuyCountLotto(countdto);
        countCreateRandomNumbers(countdto);
        outputView.printRandomLottoNumber(boxrandomdto);
    }
    public void inputMoney() {
        OutputView outputView = new OutputView();
        outputView.printInputMoney();
        setMoney(readLine());
    }
    public void countLotto(int money) { setCount(money / 1000); }
    public void readyLottoNumber() {
        Controller controller = new Controller();
        lottoNumber(controller.inputLottoNumber());
    }

    public void lottoNumber(String lottoNumbers) {
        List<Integer> numbers = new ArrayList<>();
        ErrorUtil errorUtil = new ErrorUtil();
        DataProcessing dataProcessing = new DataProcessing();
        String[] splitNumber = dataProcessing.splitLottoNumber(lottoNumbers);
        for (String s : splitNumber) numbers.add(Integer.parseInt(s));
        errorUtil.errorOverlapLottoNumber(numbers);
        setLotto(numbers);
    }
    public void readyBonusNumber() { inputBonusNumber(lottodto); }
    public void inputBonusNumber(List<Integer> lottoNumber) {
        ErrorUtil errorUtil = new ErrorUtil();
        OutputView outputView = new OutputView();
        outputView.printInputBonusNumber();
        String bonusNumber = readLine();
        lottoNumber.add(Integer.parseInt(bonusNumber));
        errorUtil.errorInputBonusNumber(bonusNumber);
        errorUtil.errorOverlapLottoNumber(lottoNumber);
        lottoNumber.remove(6);
        setBonus(Integer.parseInt(bonusNumber));
    }
    public void outputWin() {
        DataProcessing dataProcessing = new DataProcessing();
        OutputView outputView = new OutputView();
        Lotto lotto = new Lotto(lottodto);
        countWinLotto(lotto.getNumbers(), boxrandomdto, countdto, bonusdto);
        resultWinLotto(countwindto);
        outputView.printWinResultLotto(resultwindto);
        outputView.printResultReturn(dataProcessing.totalReturn(countdto, resultwindto));
    }
    public void countCreateRandomNumbers(int count) {
        List<List<Integer>> boxNumbers = new ArrayList<>();
        DataProcessing dataProcessing = new DataProcessing();
        for (int i=0;i<count;++i) {
            Lotto lotto = new Lotto(dataProcessing.sortLottoNumbers(dataProcessing.lottoRandomNumbers()));
            boxNumbers.add(lotto.getNumbers());
        }
        setBoxRandom(boxNumbers);
    }
    public void countWinLotto(List<Integer> lottoNumber, List<List<Integer>> boxRandomNumber,
                              int count, int bonusNumber) {
        List<Integer> countWinLotto = new ArrayList<>();
        DataProcessing dataProcessing = new DataProcessing();
        for (int i=0;i<count;++i)
            countWinLotto.add(dataProcessing.winLotto(lottoNumber, boxRandomNumber.get(i), bonusNumber));
        setCountWin(countWinLotto);
    }
    public void resultWinLotto(List<Integer> countWin) {
        int[] resultLotto = {0, 0, 0, 0, 0};
        for (Integer integer : countWin) {
            if (integer == 6)
                resultLotto[4] += 1;
            else if (integer == 7)
                resultLotto[3] += 1;
            else if (integer == 5)
                resultLotto[2] += 1;
            else if (integer == 4)
                resultLotto[1] += 1;
            else if (integer == 3)
                resultLotto[0] += 1;
        }
        setResultWin(resultLotto);
    }
}