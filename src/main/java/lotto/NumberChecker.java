package lotto;

import java.util.ArrayList;
import java.util.List;

public class NumberChecker {
    
    //몇개가 일치하는지 계산
    public static List<Integer> winningNumber= new ArrayList<>();
    public static int bonusNumber;
    public static List<List<Integer>> myNumber= new ArrayList<>();
    public static List<Integer> numberOfCorrectNumbers = new ArrayList<>();
    public static List<Integer> ranks = new ArrayList<>();
    NumberChecker(List<Integer> winningNumber, int bonusNumber, List<List<Integer>> myNumber){
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.myNumber = myNumber;
    }

    public static List<Integer> compareNumber() {
        for (int i = 0;i<myNumber.size();i++){
            List<Integer> compareTemp = new ArrayList<>();
            compareTemp.addAll(winningNumber);
            compareTemp.retainAll(myNumber.get(i));
            numberOfCorrectNumbers.add(compareTemp.size());

        }
        System.out.println(myNumber.toString());
        System.out.println(winningNumber);
        System.out.println(numberOfCorrectNumbers.toString());
        return numberOfCorrectNumbers;
    }

    public static List<Integer> getRanks(){
        PrizeResult[] values = PrizeResult.values();
        for(int i = 0; i< values.length; i++) {
            values[i].plusCount(numberOfCorrectNumbers);
        }
        for(int i = 0; i< values.length; i++) {
            System.out.println(values[i].getCount());
        }
        return ranks;
    }

    public static boolean checkBonusNumber(int order){
        return myNumber.get(order).contains(bonusNumber);
    }
}
