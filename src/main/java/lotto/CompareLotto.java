package lotto;

import java.util.ArrayList;
import java.util.List;

public class CompareLotto {
    public int countwin[] = new int[5];
    public int[] correctcount(List<List<Integer>> buynumbers, List<Integer> winningnumbers, int bonus){

        for(List<Integer>buynumber : buynumbers)
            compare(buynumber,winningnumbers,bonus);

        return countwin;
    }
    public void compare(List<Integer> buynumber, List<Integer> winningnumbers, int bonus){
        int cnt=0;

        for(int number:buynumber){
            if(winningnumbers.contains(number))
                cnt++;
        }

        if(cnt==6){
            countwin[4]++;
        } else if(cnt==5){
            if(buynumber.contains(bonus))
                countwin[3]++;
            else
                countwin[2]++;
        } else if(cnt==4){
            countwin[1]++;
        } else if(cnt==3){
            countwin[0]++;
        }
    }
}
