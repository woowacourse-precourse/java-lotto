package lotto.domain;

public class Yield {

    public Yield(int money, int count){
        this.yield(money,count);
    }
    private void yield(int money, int count){
        double lottoYield = ((double)money/((double)count*1000)) * 100;

        System.out.println("총 수익률은 "+Math.round(lottoYield * 10)/ 10.0 +"%입니다.");
    }

}
