package Controller;

import Domain.*;
import View.InputView;
import View.OutputView;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Controller {
    static final int LOTTO_PRICE = 1000;
    public void run(){
        InputView.printBuyingLottoMessage();
        String readMoneyValue = InputView.readInputLine();
        LottoList lottoList = new LottoList(readMoneyValue);
        OutputView.printNumberOfLotto(lottoList.getLottoPlayNumber(), lottoList.getLottoList());

        InputView.printInputWinningNumberMessage();
        String readWinningNumber = InputView.readInputLine();
        Winning winning = new Winning(readWinningNumber);


        Bonus bonus = new Bonus(winning);

        calculateLottoResult(lottoList, winning, bonus);

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
