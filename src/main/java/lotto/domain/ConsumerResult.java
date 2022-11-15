package lotto.domain;

import static lotto.domain.Ranking.DEFAULT;
import static lotto.domain.Ranking.FIFTH;
import static lotto.domain.Ranking.FIRST;
import static lotto.domain.Ranking.FOURTH;
import static lotto.domain.Ranking.SECOND;
import static lotto.domain.Ranking.THIRD;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Arrays;

public class ConsumerResult {

    public static int compareLotto(List<Integer> myLotto, List<Integer> lottoNumber){
        int count=0;
        for (int index=0; index< lottoNumber.size();index++){
            if (lottoNumber.contains(myLotto.get(index))){
                count++;
            }
        }
        return count;
    }

    public static int compareBonus(List<Integer> myLotto, int bonusNumber){
        if(myLotto.contains(bonusNumber)){
            return 1;
        }
        return 0;
    }

    //6
    public void printProfit(int money,List<Integer> totalResult){
        int income = totalResult.get(0)*FIRST.prize+totalResult.get(1)*SECOND.prize+totalResult.get(2)*THIRD.prize+totalResult.get(3)*FOURTH.prize+totalResult.get(4)*FIFTH.prize;
        System.out.printf("총 수익률은 %3.1f",profit(money,income));
        System.out.println("%입니다.");
    }

    public float profit(int money, int income){
        return (income*100.0f)/money;
    }
    //5
    public void printResult(List<Integer> totalResult){
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n",totalResult.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n",totalResult.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",totalResult.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",totalResult.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",totalResult.get(0));
    }
    public static Ranking matchLotto(List<Integer> myLotto ,List<Integer> lottoNumber, int bonus) {
        int matches = compareLotto(myLotto, lottoNumber);
        int matchBonus = compareBonus(myLotto,bonus);

        for(Ranking r : Ranking.values()) {
            if(r.lottoCount == matches && r.bonusCount == matchBonus) {
                return r;
            }
        }
        return DEFAULT;
    }
    private List<Integer> generateWinCount(){
        List<Integer> winCount= new ArrayList<>();
        for (int i=0;i<5;i++){
            winCount.add(0);
        }
        return winCount;
    }
    public List<Integer> winLotto(List<List<Integer>> totalLotto,List<Integer> lottoNumber, int bonus){
        List<Integer> winCount=generateWinCount();
        for(int index=0;index<totalLotto.size();index++){
            if (matchLotto(totalLotto.get(index),lottoNumber,bonus)==FIRST){
                winCount.set(0, winCount.get(0)+1);
            }if (matchLotto(totalLotto.get(index),lottoNumber,bonus)==SECOND){
                winCount.set(1, winCount.get(1)+1);
            }if (matchLotto(totalLotto.get(index),lottoNumber,bonus)==THIRD){
                winCount.set(2, winCount.get(2)+1);
            }if (matchLotto(totalLotto.get(index),lottoNumber,bonus)==FOURTH){
                winCount.set(3, winCount.get(3)+1);
            }if (matchLotto(totalLotto.get(index),lottoNumber,bonus)==FIFTH){
                winCount.set(4, winCount.get(4)+1);
            }
        }
        return winCount;
    }

}
