package lotto;

import java.util.ArrayList;
import java.util.List;

public class NumberChecker {
    
    //몇개가 일치하는지 계산
    public static List<Integer> winningNumber= new ArrayList<>();
    public static List<List<Integer>> myNumber= new ArrayList<>();
    public static List<Integer> numberOfCorrectNumbers = new ArrayList<>();
    NumberChecker(List<Integer> winningNumber, List<List<Integer>> myNumber){
        this.winningNumber = winningNumber;
        this.myNumber = myNumber;
    }

    public static List<Integer> compareNumber() {
        List<List<Integer>> myNumberTmp = myNumber;
        for (int i = 0; i < myNumber.size(); i++) {
            myNumberTmp.get(i).retainAll(winningNumber);
            numberOfCorrectNumbers.add(myNumberTmp.get(i).size());
        }
        return numberOfCorrectNumbers;
    }
}
