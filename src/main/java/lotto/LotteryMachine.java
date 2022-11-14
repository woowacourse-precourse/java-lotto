package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.User.*;

public class LotteryMachine {
    private List<Integer> winningNumbers;
    private List<List<Integer>> userNumbers;
    private List<Integer> winningCase;
    private List<Integer> winningPriceByCase;

    public LotteryMachine(User user, Lotto lotto){
        this.userNumbers = user.getLotteryOfUser();
        this.winningNumbers = lotto.getNumbers();
    }

    public void countWinningNumber(){
        winningCase = new ArrayList<>();
        for (List<Integer> lottery : userNumbers) {
            this.winningCase.add(compare(lottery, winningNumbers));
        }
        matchBonusNumber();
    }

    private int compare(List<Integer> lottery, List<Integer> winningNumbers) {
        int count = 0;
        for(int i=0; i<lottery.size(); i++){
            if(lottery.contains(winningNumbers.get(i)))
                count++;
        }
        if(count>=3)
            return count;
        return 0;
    }

    private boolean isBonusNumber(List<Integer> userNums){
        for(int a: userNums){
            if(a == bonusNumber)
                return true;
        }
        return false;
    }

    private void matchBonusNumber(){
        for(int i=0; i<winningCase.size(); i++){
            if(winningCase.get(i) == 5 && isBonusNumber(userNumbers.get(i))){
                winningCase.set(i, 7);
            }
        }
    }

    public List<Integer> getWinningCase(){
        return this.winningCase;
    }

    public List<Integer> getWinningPriceByCase(){
        return this.winningPriceByCase;
    }

    private double searchWinningCase(int num){
        for(WinningStatus status : WinningStatus.values()){
            if(num == status.getMatchNumber())
                return status.getWinningPrice();
        }
        return 0;
    }

    private double matchWinningCase(){
        winningPriceByCase = new ArrayList<>();
        double sum = 0;
        for(int i=0; i<winningCase.size(); i++){
            sum += searchWinningCase(winningCase.get(i));
        }
        return sum;
    }

    public void calculateRate(){
        double sum = matchWinningCase();
        sum = (sum/lottoPrice) * 100;
        String rate = String.format("%.1f", sum);
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
