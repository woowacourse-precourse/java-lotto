package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ComparingMachine {
    private List<Integer> containNumberList = new ArrayList<>();

    public void countContainNumber(List<Integer> winningNumber, List<List<Integer>> lotto){
        for(int i = 0; i < lotto.size(); i++){
            int containNumber = 0;
            for(int j = 0; j < winningNumber.size(); j++){
                if(lotto.get(i).contains(winningNumber.get(j))){
                    containNumber++;
                }
            }
            containNumberList.add(containNumber);
        }
    }

    public List<Integer> getContainNumberList() {
        return containNumberList;
    }
}
