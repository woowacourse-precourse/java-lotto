package lotto;

import java.util.ArrayList;
import java.util.List;

public class CompareLotto {
    public List<Integer> correctcount(List<List<Integer>> buynumbers, List<Integer> winningnumbers, int bonus){
        List<Integer> correctcount = new ArrayList<>();

        for(List<Integer>buynumber : buynumbers){
            int cnt=0;

            for(int number:buynumber){
                if(winningnumbers.contains(number))
                    cnt++;
            }

            if(cnt==6){

            } else if(cnt==5){

            } else if(cnt==4){

            } else if(cnt==3){

            }
        }

        return correctcount;
    }
}
