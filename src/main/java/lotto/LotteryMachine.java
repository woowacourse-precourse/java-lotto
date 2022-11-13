package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryMachine {
    private List<Integer> winningNumbers;
    private ArrayList<List<Integer>> userNumbers;
    private List<Integer> winningCase;
    public static List<Integer> winningPriceByCase;

    public LotteryMachine(User user, Lotto lotto){
        this.winningNumbers = user.getUserNumbers();
        this.userNumbers = lotto.getLotteryOfUser();
    }

    public void countWinningNumber(){
        for(int i=0; i<userNumbers.size(); i++){
            List<Integer> lottery = userNumbers.get(i);
            this.winningCase.add(compare(lottery, winningNumbers));
        }
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

    public void matchWinningCase(){
        for(WinningStatus status: WinningStatus.values()){
            winningPriceByCase = winningCase.stream()
                            .filter(count -> count == status.getMatchNumber())
                            .map(count -> count * status.getWinningPrice())
                            .collect(Collectors.toList());
        }
    }
}
