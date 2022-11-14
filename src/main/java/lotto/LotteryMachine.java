package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.User.bonusNumber;

public class LotteryMachine {
    private List<Integer> winningNumbers; //Lotto numbers와 같은 역할임
    private ArrayList<List<Integer>> userNumbers;
    private List<Integer> winningCase;
    public static List<Integer> winningPriceByCase;

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
            if(winningNumbers.get(i) == lottery.get(i))
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

    public void matchWinningCase(){
        for(WinningStatus status: WinningStatus.values()){
            winningPriceByCase = winningCase.stream()
                            .filter(count -> count == status.getMatchNumber())
                            .map(count -> count * status.getWinningPrice())
                            .collect(Collectors.toList());
        }
    }

    public void calculateRate(){
        double sum = 0;
        for(int a: winningPriceByCase){
            sum += a;
        }
        sum /= lottoEA*1000;
        String rate = String.format("%.2f", sum);
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
