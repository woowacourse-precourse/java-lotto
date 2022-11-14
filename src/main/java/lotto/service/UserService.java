package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Prize;

import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console.*;
public class UserService {

    private final static ArrayList<Prize> PRIZE_TYPE = new ArrayList<>(Arrays.asList(
            Prize.FIRST_PLACE,
            Prize.SECOND_PLACE,
            Prize.THIRD_PLACE,
            Prize.FOURTH_PLACE,
            Prize.FIFTH_PLACE));

    public String calculateTheRateOfReturn(int prizeMoney, int purchaseMoney) {
        float rateOfReturn = ((float) prizeMoney / (float) purchaseMoney) * 100;
        return String.format("%.1f", rateOfReturn);
    }

    public int calculateUserPrize(ArrayList<Integer> numberOfWins) {
        int totalPrizeMoney = 0;
        for (int i = 0; i < 5; i++) {
            totalPrizeMoney += PRIZE_TYPE.get(i).getPrizeMoney() * numberOfWins.get(i);
        }
        return totalPrizeMoney;
    }

    public int checkTheNumberOfWinsInOne(Lotto winningNumbers,
                                         Lotto checkingNumbers){
        int count = 0;
        for (int number : checkingNumbers.getNumbers()){
            if (winningNumbers.getNumbers().contains(number)){
                count += 1;
            }
        }
        return count;
    }

    public ArrayList<Integer> checkTheNumberOfWinsInAll(Lotto winningNumbers, ArrayList<Lotto> lotties,int bonusNumber) {
        ArrayList<Integer> numberOfWinningTypes = new ArrayList<>(Arrays.asList(0,0,0,0,0));
        for (Lotto lotto : lotties) {
            int count = checkTheNumberOfWinsInOne(winningNumbers,lotto);
            if (count == 6) {
                numberOfWinningTypes.set(0,numberOfWinningTypes.get(0)+1);
            }else if (count == 5 && lotto.getNumbers().contains(bonusNumber)) {
                numberOfWinningTypes.set(1,numberOfWinningTypes.get(1)+1);
            }else if (count == 5) {
                numberOfWinningTypes.set(2,numberOfWinningTypes.get(2)+1);
            }else if (count == 4) {
                numberOfWinningTypes.set(3,numberOfWinningTypes.get(3)+1);
            }else if (count == 3) {
                numberOfWinningTypes.set(4,numberOfWinningTypes.get(4)+1);
            }
        }
        return numberOfWinningTypes;
    }

    public String enterPurchaseAmount () {
        return Console.readLine();
    }

    public String enterWinningNumbers() {
        return Console.readLine();
    }

    public String enterBonusNumber() {
        return Console.readLine();
    }

    public int findTheNumberOfLotteryTicketsPurchased(String purchaseAmount){
        int amount = Integer.parseInt(purchaseAmount);
        return amount / 1000;
    }
}
