package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Judgement {
    private List<HashMap<Integer, Boolean>> resultTable;
    private float returnRate;
    private List<Integer> lotto;
    private int bonusNumber;


    public Judgement(List<Integer> lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        this.resultTable = new ArrayList<>();
        this.returnRate = 0.00F;
    }

    private void compare(List<Integer> lotteryNumbers) {
        int count = 0;
        boolean bonusFlag = false;
        HashMap<Integer, Boolean> tableValue = new HashMap<>();

        for(int number : lotteryNumbers) {
            if (this.lotto.contains(number)) count++;
        }

        if(lotteryNumbers.contains(bonusNumber)) {
            count++;
            bonusFlag = true;
        }

        tableValue.put(count, bonusFlag);
        resultTable.add(tableValue);
    }

    public void informLottoResult(ArrayList<ArrayList<Integer>> lotteryNumbers) {
        for(List<Integer> lotteryNumber : lotteryNumbers){
            compare(lotteryNumber);
        }

    }
}
