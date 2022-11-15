package Controller;

import Domain.*;
import View.InputView;
import View.OutputView;
import java.util.List;


public class Controller {
    private LottoList lottoList;
    private Winning winning;
    private Bonus bonus;
    public void run(){
        setLottoList();
        setWinning();
        setBonus();

        calculateLottoResult(lottoList, winning, bonus);
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
        this.winning = new Winning(readWinningNumber);
    }

    public void setBonus(){
        InputView.printInputBonusNumberMessage();
        String readBonusNumber = InputView.readInputLine();
        this.bonus = new Bonus(readBonusNumber, winning);
    }


    public void calculateLottoResult(LottoList lottoList, Winning winning, Bonus bonus){
        int income = 0;
        int[] ranking = new int[6];  //상수
        for(Lotto eachLotto : lottoList.getLottoList()){
            int compareLotto = compareMyLottoAndWinningNumber(eachLotto.getLottoNumbers(), winning.getNumbers());
            boolean compareBonus = compareMyLottoAndBonusNumber(eachLotto.getLottoNumbers(), bonus.getBonusNumber());
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
