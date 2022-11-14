package lotto;

import java.util.*;

public class WinningStats {
    static double earningRate;
    static final String PrintEarningRate = "총 수익률은 %.1f%%입니다.";
    public static class Winning{
        int rank;
        int number;
        int reward;
        int sameCount;
        Boolean existBonus;
        String print;
        public Winning(int rank, int number, int reward,int sameCount, Boolean existBonus, String print){
            this.rank = rank;
            this.number = number;
            this.reward = reward;
            this.sameCount = sameCount;
            this.existBonus = existBonus;
            this.print = print;
        }
    }

    public static List<Winning> collection = new ArrayList<>(Arrays.asList(
            new Winning(5,0,5000, 3, null, "3개 일치 (5,000원) - %d개"),
            new Winning(4,0,50000,4, null,"4개 일치 (50,000원) - %d개"),
            new Winning(3,0,1500000,5,false,"5개 일치 (1,500,000원) - %d개"),
            new Winning(2,0,30000000,5,true,"5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
            new Winning(1,0,2000000000, 6, null,"6개 일치 (2,000,000,000원) - %d개")
    ));

    public WinningStats(List<Lotto> purchase, Lotto winning, int bonus){
        WinningStats.Initialize();

        for(Lotto selected : purchase){
            int sameCount = GetSameNumber(selected, winning);
            Boolean existBonus = CheckBonus(selected, bonus, sameCount);
            AccumulateWinning(sameCount, existBonus);
        }
    }

    public static void Initialize(){
        for(Winning c : collection){
            c.number = 0;
        }
    }
    private Boolean CheckBonus(Lotto lotto, int bonus, int sameCount){
        if(sameCount == 5)
            return Lotto.CheckBonus(lotto, bonus);

        return null;
    }

    private int GetSameNumber(Lotto lotto, Lotto winning){
        return Lotto.CountSameNumber(lotto, winning);
    }

    public void PrintWinningStats(){
        System.out.println("당첨 통계");
        System.out.println("---");
        for(Winning c : collection){
            System.out.println(String.format(c.print, c.number));
        }
    }
    public void PrintEarningRate(){
        System.out.println(String.format(PrintEarningRate, earningRate));
    }

    private void AccumulateWinning(int sameCount, Boolean existBonus){
        Optional<Winning> a = collection.stream().filter(c->c.sameCount == sameCount && c.existBonus == existBonus).findFirst();
        if(a.isEmpty())
            return;

        a.get().number++;
    }

    public void CalculateEarningRate(int amount){
        int sum = 0;
        for(Winning c : collection){
            sum += c.number * c.reward;
        }

        earningRate = (double)sum / amount * 100;
        earningRate = Math.round(earningRate * 10) / 10.0;
    }
}
