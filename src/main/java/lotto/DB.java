package lotto;

import java.util.ArrayList;
import java.util.List;


public class DB {
    private static List<Lotto> table = new ArrayList<>();
    private static long prizeSum =0;
    private static double yeild=0;
    private static List<Integer> statistics = new ArrayList<>(List.of(0,0,0,0,0));

    public static void init(){
        DB.table.clear();
    }

    public static void insert(Lotto lotto){
        table.add(lotto);
    }
    public static Lotto selectAt(int i){
        return table.get(i);
    }
    public static int getTableSize(){
        return table.size();
    }
    public static void setPrizeSum(int prize){
        DB.prizeSum =prize;
    }
    public static long getPrizeSum(){
        return DB.prizeSum;
    }

    public static List<Integer> getStatistics(){
        return statistics;
    }
    public static void setStatistics(List<Integer> statistics){
        DB.statistics=statistics;
    }

    public static void setYeild(double yeild){
        DB.yeild=yeild;
    }
    public static double getYeild(){
        return DB.yeild;
    }
}
