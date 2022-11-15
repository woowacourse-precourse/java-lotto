package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ComparingMachine {
    private List<Integer> containNumberList = new ArrayList<>();
    private List<Integer> containBonusNumber = new ArrayList<>();

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

    public void countContainBonusNumber(int bonusNumber, List<List<Integer>> lotto){
        for(List<Integer> lottoList : lotto){
            if(lottoList.contains(bonusNumber)){
                containBonusNumber.add(1);
            }

            if(!lottoList.contains(bonusNumber)){
                containBonusNumber.add(0);
            }
        }
    }

    public List<Integer> getContainNumberList() {
        return containNumberList;
    }

    public List<Integer> getContainBonusNumber() {
        return containBonusNumber;
    }
}
