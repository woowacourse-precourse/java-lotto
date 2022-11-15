package lotto;

import java.util.List;

public class MatchPrize {
    static int matchNumber(List<Integer> number , List<Integer> answer) {
        int count = 0;

        for(int e : number) {
            if(answer.contains(e)){
                count++;
            }
        }
        return count;
    }
    static boolean matchBonus(List<Integer> number , int bonus) {
        for(int e : number) {
            if(e == bonus){
                return true;
            }
        }
        return false;
    }
}
