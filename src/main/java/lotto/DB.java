package lotto;

import java.util.ArrayList;


public class DB {
    private static ArrayList<Lotto> table = new ArrayList<>();
    private static long prizeSum =0;
    public static void insert(Lotto lotto){
        table.add(lotto);
    }
    public static Lotto selectAt(int i){
        return table.get(i);
    }
    public static int getTableSize(){
        return table.size();
    }
    public static void updatePrizeSum(int prize){
        DB.prizeSum +=prize;
    }
    public static long getPrizeSum(){
        return DB.prizeSum;
    }
}
