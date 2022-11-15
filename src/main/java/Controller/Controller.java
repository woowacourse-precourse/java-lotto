package Controller;

import Domain.*;
import View.InputView;
import View.OutputView;
import java.util.List;


public class Controller {
    private LottoList lottoList;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    public void run(){
        setLottoList();
        setWinning();
        setBonus();

        calculateLottoResult(lottoList, winningNumbers, bonusNumber);
    }

    public void setLottoList(){
        InputView.printBuyingLottoMessage();
        String readMoneyValue = InputView.readInputLine();
        this.lottoList = new LottoList(readMoneyValue);
        OutputView.printNumberOfLotto(lottoList.getLottoPlayNumber(), lottoList.getLottoList());
    }

    public void setWinning(){
        InputView.printInputWinningNumberMessage();
        String readWinningNumber = InputView.readInputLine();
        this.winningNumbers = new WinningNumbers(readWinningNumber);
    }

    public void setBonus(){
        InputView.printInputBonusNumberMessage();
        String readBonusNumber = InputView.readInputLine();
        this.bonusNumber = new BonusNumber(readBonusNumber, winningNumbers);
    }


    public void calculateLottoResult(LottoList lottoList, WinningNumbers winningNumbers, BonusNumber bonusNumber){
        int income = 0;
        int[] ranking = new int[6];  //상수
        for(Lotto eachLotto : lottoList.getLottoList()){
            int compareLotto = compareMyLottoAndWinningNumber(eachLotto.getLottoNumbers(), winningNumbers.getNumbers());
            boolean compareBonus = compareMyLottoAndBonusNumber(eachLotto.getLottoNumbers(), bonusNumber.getBonusNumber());
            int getPrizeMoney = Prize.convertCountToPrizeMoney(compareLotto, ranking, compareBonus);
            income += getPrizeMoney;
        }
        OutputView.printLottoResult(ranking, lottoList, income);
    }

    public int compareMyLottoAndWinningNumber(List<Integer> myLottoNumber, List<Integer> winningNumber){
        int countSameNumber = 0;
        for(int eachWinningNumber : winningNumber){
            if(myLottoNumber.contains(eachWinningNumber)){
                countSameNumber += 1;
            }
        }
        return countSameNumber;
    }

    public boolean compareMyLottoAndBonusNumber(List<Integer> myLottoNumber, int bonusNumber){
        return myLottoNumber.contains(bonusNumber);
    }
}
