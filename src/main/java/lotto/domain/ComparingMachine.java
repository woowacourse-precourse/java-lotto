package lotto.domain;

import java.util.*;

public class ComparingMachine {
    private List<Integer> containNumberList = new ArrayList<>();
    private List<Integer> containBonusNumber = new ArrayList<>();
    private Map<Integer,Integer> result = new HashMap<>();

    int third = 0;
    int fourth = 0;
    int fifth = 0;
    int fifth_bonus = 0;
    int sixth = 0;

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

    public void countWinResult(){
        for(int i = 0; i < containNumberList.size(); i++){
            if(containNumberList.get(i) == 3){third++;}
            if(containNumberList.get(i) == 4){fourth++;}
            if(containNumberList.get(i) == 5 && containBonusNumber.get(i) == 0){fifth++;}
            if(containNumberList.get(i) == 5 && containBonusNumber.get(i) == 1){fifth_bonus++;}
            if(containNumberList.get(i) == 6){sixth++;}
        }
        result.put(5000,third);
        result.put(50000,fourth);
        result.put(1500000,fifth);
        result.put(30000000,fifth_bonus);
        result.put(2000000000,sixth);
    }


    public List<Integer> getContainNumberList() {
        return containNumberList;
    }

    public List<Integer> getContainBonusNumber() {
        return containBonusNumber;
    }

    public Map<Integer, Integer> getResult() {
        return result;
    }
}
