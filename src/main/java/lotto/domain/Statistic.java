package lotto.domain;

import lotto.enums.LottoReward;
import lotto.enums.Range;

import java.util.List;

public class Statistic {
    private final int[] correct;
    private int revenue;

    public double getRevenue(int price) {
        addRevenue();
        return calculateRevenue(price);
    }

    public int[] getCorrect() {
        return correct;
    }

    public Statistic() {
        this.correct = new int[]{0,0,0,0,0};
        this.revenue = 0;
    }

    public void countCorrect(List<Integer> winNumbers, List<Lotto> lottos, int bonus){
        for (Lotto lotto: lottos){
            int countEach = compare(lotto, winNumbers);
            lottoResult(countEach, correctBonus(bonus, lotto));
        }
        addRevenue();

    }

    private int compare(Lotto lotto, List<Integer> winNumbers){
        int cnt = 0;
        for (int n: winNumbers){
            if(lotto.getNumbers().contains(n)){
                cnt++;
            }
        }
        return cnt;
    }

    private boolean correctBonus(int b, Lotto lotto){
        return lotto.getNumbers().contains(b);
    }

    private void lottoResult(int n, boolean bonus){
        if (n==3){
            correct[0] +=1;
        }if (n==4){
            correct[1] += 1;
        }if (n==5){
            correct[2] +=1;
            if (bonus){
                correct[3] += 1;
            }
        }if(n==6){
            correct[4] +=1;
        }
    }

    private void addRevenue(){
        for (int i=0;i<correct.length;i++){
            revenue += LottoReward.withIndex(i).getReward() * correct[i];
        }
    }


    public double calculateRevenue(int price){
        return (double)revenue/price;
    }

}
