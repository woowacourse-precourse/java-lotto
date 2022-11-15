package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Check {
    private int money;
    private List<Integer> lotto;
    private int bonusNumber;
    private int result[]=new int[5];
    public Check(List<Integer> lotto, int bonusNumber, int money) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.money = money;
    }
    private void compareLotto(List<Integer> myLottoNumbers){
        int count=0;
        int bonus=0;
        for(int n:myLottoNumbers){
            if(this.lotto.contains(n)) count++;
            if(n==bonusNumber) bonus++;
        }
        if(count==6) result[0]++;
        else if(count==5 && bonus==1) result[1]++;
        else if(count==5) result[2]++;
        else if(count==4) result[3]++;
        else if(count==3) result[4]++;
    }
    public void LottoResult(ArrayList<ArrayList<Integer>> numbers){
        for(List<Integer> myLottoNumbers:numbers){
            compareLotto(myLottoNumbers);
        }
    }
    public void print(){
        System.out.println("당첨통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n",result[4]);
        System.out.printf("4개 일치 (50,000원) - %d개\n",result[3]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n",result[2]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n",result[1]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n",result[0]);
    }
    public void printPercent(){
        int sum=0;
        sum+=2000000000*result[0];
        sum+=30000000*result[1];
        sum+=1500000*result[2];
        sum+=50000*result[3];
        sum+=5000*result[4];
        System.out.printf("총 수익률은 %.1f",(sum*100.0f)/money);
        System.out.println("%입니다.");
    }
}
