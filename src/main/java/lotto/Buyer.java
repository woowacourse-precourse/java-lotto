package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Buyer {

    private ArrayList<ArrayList<Integer>> listOfNumbers;

    public Buyer() {
    }

    public void setListOfLotto(String buyAmount) {
        int amount = stringToInt(buyAmount);
        int count = countCalculation(amount);
        listOfNumbers = new ArrayList<>();
        addLottoNumbers(count);

    }

    public ArrayList<ArrayList<Integer>> getListOfNumbers() {
        return listOfNumbers;
    }

    private void addLottoNumbers(int count) {
        for(int i=0 ; i<count; i++){
            ArrayList<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto);
            listOfNumbers.add(lotto);
        }
    }

    private int stringToInt(String buyAmount) {
        int amount = Integer.parseInt(buyAmount);
        return amount;
    }

    private int countCalculation(int amount) {
        if(!isCollectedAmount(amount)){
            throw new IllegalArgumentException();
        }
        return amount/1000;
    }

    private boolean isCollectedAmount(int amount) {
        if(amount % 1000 == 0){
            return true;
        }
        return false;
    }
}
