package lotto;

import java.util.*;

public class printResults {

    private static int[] buildCount(){
        int[] counts = new int[6];
        for(int i=0;i<6;i++){
            counts[i] = 0;
        }
        return counts;
    }

    private static int[] countPrizes(int[] counts, List<String> prizes){
        for(String prize: prizes){
            if(prize.matches("FIRST")){
                counts[5] += 1;
            } else if(prize.matches("SECOND")){
                counts[4] += 1;
            } else if(prize.matches("THIRD")){
                counts[3] += 1;
            } else if(prize.matches("FOURTH")){
                counts[2] += 1;
            } else if(prize.matches("FIFTH")){
                counts[1] += 1;
            } else if(prize.matches("NOTHING")){
                counts[0] += 1;
            }
        }
        return counts;
    }
    private static String matchMoney(int i){
        switch (i){
            case 1: return "5,000";
            case 2: return "50,000";
            case 3: return "1,500,000";
            case 4: return "30,000,000";
            case 5: return "2,000,000,000";
            default: return "";
        }
    }
    public static void total(List<String> prizes){
        int[] counts = buildCount();
        int[] results = countPrizes(counts, prizes);

        for(int i=1;i<results.length;i++){
//            System.out.println(i+":"+results[i]);
            if(results[i] > 0){
                System.out.println((i+2)+"개 일치 ("+matchMoney(i)+"원) -"+results[i]+"개");
            }
        }

    }
}
