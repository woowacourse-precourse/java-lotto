package lotto.domain;

import java.util.List;

public class Statistic {
    private int[] correct;
    private int revenue;

    public int getRevenue() {
        return revenue;
    }

    public int[] getCorrect() {
        return correct;
    }

    public Statistic(int[] correct) {
        this.correct = correct;
        this.revenue = 0;
    }

    private void countCorrect(List<Integer> winNumbers, List<Lotto> lottos, int bonus){
        int totalcnt = 0;
        for (Lotto lotto: lottos){
            int countEach = compare(lotto, winNumbers);
            lottoResult(countEach, correctBonus(bonus, lotto));
        }
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

    private int addRevenue(){
        for (int i=0;i<correct.length;i++){
            revenue += LottoReward.withCorrectNum(i).getReward() * correct[i];
        }
        return revenue;
    }


    private double calculateRevenue(int price){
        return revenue/price;
    }

}
