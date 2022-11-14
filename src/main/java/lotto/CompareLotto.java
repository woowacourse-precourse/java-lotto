package lotto;

import java.util.ArrayList;
import java.util.List;

public class CompareLotto {
    public int one=0,second=0,third=0,fourth=0,fifth=0;
    public List<Integer> correctcount(List<List<Integer>> buynumbers, List<Integer> winningnumbers, int bonus){
        List<Integer> correctcount = new ArrayList<>();

        for(List<Integer>buynumber : buynumbers){
            int cnt=0;

            for(int number:buynumber){
                if(winningnumbers.contains(number))
                    cnt++;
            }

            if(cnt==6){
                one++;
            } else if(cnt==5){
                if(buynumber.contains(bonus))
                    second++;
                else
                    third++;
            } else if(cnt==4){
                fourth++;
            } else if(cnt==3){
                fifth++;
            }
        }

        return correctcount;
    }
}
