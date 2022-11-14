package lotto;

import java.util.*;

public class WinningStats {
    static double earningRate;
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
            new Winning(5,0,5000, 3, null, PrintMessage.fifthResult),
            new Winning(4,0,50000,4, null,PrintMessage.forthResult),
            new Winning(3,0,1500000,5,false,PrintMessage.thirdResult),
            new Winning(2,0,30000000,5,true,PrintMessage.secondResult),
            new Winning(1,0,2000000000, 6, null, PrintMessage.firstResult)
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
        System.out.println(PrintMessage.winningStats);
        System.out.println(PrintMessage.underLine);
        for(Winning c : collection){
            System.out.println(String.format(c.print, c.number));
        }
    }
    public void PrintEarningRate(){
        System.out.println(String.format(PrintMessage.earningRate, earningRate));
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
