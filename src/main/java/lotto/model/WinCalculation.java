package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinCalculation {

    private static int count=0;
    private static boolean bonusCheck = true;
    static List<List<Object>> rank = new ArrayList<>();

    public static int winCount(List<Integer> win, List<Integer> number){
        for(Integer winIndex : win) {
            checkEqualNumber(winIndex,number);
        }
        return count;
    }

    private static void checkEqualNumber(int winIndex, List<Integer> number){
        for(Integer numIndex:number){
            if(winIndex == numIndex){
                countAdd();
            }
        }
    }

    private static void countAdd(){
        count++;
    }

    public WinCalculation() {
        this.count = 0;
        this.bonusCheck = true;
    }

    public static boolean bonusNumber(int bonus, List<Integer> number) {
        for(Integer numIndex : number) {
            if(numIndex == bonus) {
                return true;
            }
        }
        return false;
    }

    public static List<List<Object>> winCal(List<Integer> win, List<List<Integer>> lottos, int bonus) {
        for (List<Integer> lotto : lottos) {
            new WinCalculation();
            winCount(win, lotto);
            if (count == 5) {
                bonusCheck = bonusNumber(bonus, lotto);
            }
            rank(count, bonusCheck);
        }
        return rank;
    }

    private static void rank(int count, boolean bonusCheck){
        rank.add(new ArrayList<>(Arrays.asList(count,bonusCheck)));
    }

    public static List<WinDetail> rankResult(List<List<Object>> rank){
        List<WinDetail> result = new ArrayList<>();
        for (List<Object> objects : rank) {
            int match = (int) objects.get(0);
            boolean bonus = (boolean) objects.get(1);

            result.add(findRank(match, bonus));
        }
        return result;
    }

    private static WinDetail findRank(int match, boolean bonus){
        return WinDetail.findRankBy(match,bonus);
    }
}
