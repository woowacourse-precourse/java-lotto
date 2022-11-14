package lotto;

import java.util.ArrayList;


public class DB {
    private static ArrayList<Lotto> table = new ArrayList<>();
    public static void insert(Lotto lotto){
        table.add(lotto);
    }
    public static Lotto selectAt(int i){
        return table.get(i);
    }
    public static int getTableSize(){
        return table.size();
    }
}
