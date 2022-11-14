package lotto;

import java.util.*;

public class WinningStats {
    static double earningRate;

    public enum Winning{
        FIRST(1, 2000000000, 6, null, PrintMessage.firstResult),
        SECOND(2, 30000000, 5, true, PrintMessage.secondResult),
        THIRD(3, 1500000, 5, false, PrintMessage.thirdResult),
        FORTH(4, 50000, 4, null, PrintMessage.forthResult),
        FIFTH(5, 5000, 3, null, PrintMessage.fifthResult);

        public final int rank;
        public final int reward;
        public final int sameCount;
        public final Boolean bonus;
        public final String printStr;
        public int count;

        Winning(int rank, int reword, int sameCount, Boolean bonus, String printStr) {
            this.rank = rank;
            this.reward = reword;
            this.sameCount = sameCount;
            this.bonus = bonus;
            this.printStr = printStr;
        }

        public void Print(){
            System.out.println(String.format(printStr, count));
        }

        public static void accumulateWinning(int sameCount, Boolean bonus){
            Optional<Winning> target = Arrays.stream(values())
                    .filter(c->c.sameCount == sameCount && c.bonus == bonus).findFirst();

            if(target.isEmpty())
                return;

            target.get().count++;
        }


        public static void Initialize(){
            for(Winning winning : Winning.values()){
                winning.count = 0;
            }
        }
    }

    public WinningStats(List<Lotto> purchase, Lotto winning, int bonus){
        Winning.Initialize();

        for(Lotto selected : purchase){
            int sameCount = GetSameNumber(selected, winning);
            Boolean existBonus = CheckBonus(selected, bonus, sameCount);
            Winning.accumulateWinning(sameCount, existBonus);
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

        for(Winning c : Winning.values()){
            c.Print();
        }
    }
    public void PrintEarningRate(){
        System.out.println(String.format(PrintMessage.earningRate, earningRate));
    }

    public static void CalculateEarningRate(int amount){
        int sum = 0;
        for(Winning winning : Winning.values()){
            sum += winning.count * winning.reward;
        }

        earningRate = (double)sum / amount * 100;
        earningRate = Math.round(earningRate * 10) / 10.0; //소수 둘째 자리에서 반올림
    }
}
