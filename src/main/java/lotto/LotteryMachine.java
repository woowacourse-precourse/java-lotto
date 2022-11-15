package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.User.*;

public class LotteryMachine {
    private List<Integer> winningNumbers;
    private List<List<Integer>> userNumbers;
    public static List<Integer> winningCase;
    private List<Integer> winningPriceByCase;
    private Map<Integer, Integer> settings;

    public LotteryMachine(User user, Lotto lotto){
        this.userNumbers = user.getLotteryOfUser();
        this.winningNumbers = lotto.getNumbers();
    }

    public void countWinningNumber(){
        winningCase = new ArrayList<>();
        for (List<Integer> lottery : userNumbers) {
            winningCase.add(compare(lottery, winningNumbers));
        }
        matchBonusNumber();
    }

    private int compare(List<Integer> lottery, List<Integer> winningNumbers) {
        int count = 0;
        for(int i=0; i<lottery.size(); i++){
            if(lottery.contains(winningNumbers.get(i)))
                count++;
        }
        return count;
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

    private double searchWinningPrice(int num){
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
            sum += searchWinningPrice(winningCase.get(i));
        }
        return sum;
    }
    private void settingFormat(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void statisticsSetting(){
        this.settings = new HashMap<>();
        for (int key : winningCase) {
            settings.put(key, settings.getOrDefault(key, 0) + 1);
        }
        System.out.println(settings);
    }

    private int matchNumber(int number){
        if(!settings.containsKey(number))
            return 0;
        return settings.get(number);
    }

    public void showStatistics(){
        settingFormat();
        statisticsSetting();
        for(WinningStatus status: WinningStatus.values()){
            int result = matchNumber(status.getMatchNumber());
            System.out.println(status.getFormat() + result + "개");
        }
    }

    public void calculateRate(){
        double sum = matchWinningCase();
        sum = (sum/lottoPrice) * 100;
        String rate = String.format("%.1f", sum);
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
