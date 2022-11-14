package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.platform.commons.logging.*;

public class Buyer {
    private static final String BLANK = "";

    private ArrayList<ArrayList<Integer>> listOfNumbers;

    public Buyer() {
    }

    public void setListOfLotto(String buyAmount) {
        if(isBlank(buyAmount)) {
            throw new IllegalArgumentException("[ERROR] 공백 입력");
        }
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
        try {
            return Integer.parseInt(buyAmount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return 0;
    }

    public int countCalculation(int amount) {
        if(!isCollectedAmount(amount)){
            throw new IllegalArgumentException("[ERROR] 1000 단위가 아님");
        }
        return amount/1000;
    }

    private boolean isCollectedAmount(int amount) {
        if(amount % 1000 == 0){
            return true;
        }
        return false;
    }

    private boolean isBlank(String buyAmount) {
        if(buyAmount.equals(BLANK)) {
            return true;
        }
        return false;
    }
}
