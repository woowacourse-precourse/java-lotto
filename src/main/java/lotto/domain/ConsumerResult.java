package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ConsumerResult {

    public int compareLotto(List<Integer> myLotto, List<Integer> lottoNumber){
        int count=0;
        for (int index=0; index< lottoNumber.size();index++){
            if (lottoNumber.contains(myLotto.get(index))){
                count++;
            }
        }
        return count;
    }

    public int compareBonus(List<Integer> myLotto, int bonusNumber){
        if(myLotto.contains(bonusNumber)){
            return 1;
        }
        return 0;
    }

    //6
    public void printProfit(int money,List<Integer> totalResult){
        int income = 0;
        List<Integer> winmoney=List.of(5000,50000,1500000,30000000,2000000000);
        for(int index=0;index<5;index++){
            income+= totalResult.get(index)*winmoney.get(index);
        }
        System.out.printf("총 수익률은 %f%입니다.\n",myIncome(money,income));
    }

    public float profit(int money, int income){
        return (income*100.0f)/money;
    }

    private List<Integer> myIncome(int lottoCount, int bonusCount){
        List<Integer> income = new ArrayList<>(5);
        if(lottoCount==3){
            income.set(0,income.get(0)+1);
        }if(lottoCount==4){
            income.set(1,income.get(1)+1);
        }if(lottoCount==5){
            income.set(2,income.get(2)+1);
        }if(lottoCount==5 && bonusCount==1){
            income.set(3,income.get(3)+1);
        }if(lottoCount==6){
            income.set(4,income.get(4)+1);
        }
        return income;
    }
    public List<Integer> winLotto(List<Integer> jionCount){
        int lottoCount=jionCount.size()/2;
        List<Integer> totalResult = new ArrayList<>(5);
        for(int count=0;count<lottoCount;count++){
            totalResult.set(count,myIncome(jionCount.get(count),jionCount.get(count+lottoCount)).get(count));
        }
        return totalResult;
    }
    //5
    public void printResult(List<Integer> totalResult){
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n",totalResult.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n",totalResult.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",totalResult.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",totalResult.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",totalResult.get(4));
    }
}
