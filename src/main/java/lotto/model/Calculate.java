package lotto.model;

import lotto.utils.Result;
import lotto.view.FinalResult;

import java.util.HashMap;

public class Calculate {

    public static void getResult(){
        HashMap<Integer, Boolean> hasBonusNumber = BonusNumber.hasBonusNumber;
        HashMap<Integer, Integer> resultCount = Compare.resultCount;

        for (int i = 0; i < resultCount.size(); i++) {
            Result result = Result.getResult(resultCount.get(i), hasBonusNumber.get(i));
            String re = String.valueOf(result);
            if(re.equals("FIRST")){
                FinalResult.first++;
            }
            if(re.equals("SECOND")){
                FinalResult.second++;
            }
            if(re.equals("THIRD")){
                FinalResult.third++;
            }if(re.equals("FOURTH")){
                FinalResult.fourth++;
            }
            if(re.equals("FIFTH")){
                FinalResult.fifth++;
            }
        }
    }
}
