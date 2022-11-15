package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculate {
    private final int[] matchCount = new int [Constants.MATCH_TABLE_LENGTH];
    private final List<Integer> userNumber;
    private int bonusNumber = 0;
    private final List<List<Integer>> totalNumbers;

    Calculate(List<Integer> userNumber, int bonusNumber, List<List<Integer>> totalNumbers){
        this.userNumber = userNumber;
        this.bonusNumber = bonusNumber;
        this.totalNumbers = totalNumbers;
    }

    void compareNumber(){
        for(int i = 0;i<totalNumbers.size();i++){

            int match;

            match = countNumber(totalNumbers.get(i));
            if(checkBonus(match,totalNumbers.get(i))){
                matchCount[match+Constants.FIVE_ADD_BONUS] = Constants.FLAG;
            };
            matchCount[match] = Constants.FLAG;
        }
    }

    int countNumber(List<Integer> totalNumber){
        int match = 0;
        for(int i=0;i<totalNumber.size();i++) {
            for(int j = 0;j<userNumber.size();j++) {
                match += compare(totalNumber.get(i), userNumber.get(j));
            }
        }
        return match;
    }

    int compare(int total, int user){
        if(total == user){
            return 1;
        }
        return 0;
    }
    boolean checkBonus(int match, List<Integer>totalNumber){
        if(match == Constants.BONUS){
            if(totalNumber.contains(match)){
                return true;
            }
        }
        return false;
    }

    public int[] getMatchCount() {
        return matchCount;
    }

    public void rateOfReturn(int totalPrice,int investMoney){
        System.out.printf("총 수익률은 %.1f%%입니다.",(totalPrice/(float)investMoney)*100);
    }
}

