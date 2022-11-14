package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.WinningType.*;

public class calculation {

    public static List<WinningType> calculateResultAll(List<Lotto> lottoList, List<Integer> answerList, int bonusNumber){
        List<WinningType> result = new ArrayList<>();
        for(WinningType wt : WinningType.values()) result.add(wt);
        for(int i=0; i<lottoList.size(); i++){
            List<Integer> userList = lottoList.get(i).getNumbers();
            int value = calculateResultByOne(userList, answerList, bonusNumber);
            WinningType wt = WinningType.getType(value);
            wt.increaseValue();
        }
        return result;
    }

    public static int calculateResultByOne(List<Integer> userList, List<Integer> answerList, int bonusNumber){
        int count = 0;
        for(int i=0; i<answerList.size(); i++){
            int answer = answerList.get(i);
            if(userList.contains(answer)) count++;
        }
        if(count == 5 && userList.contains(bonusNumber)) return MATCH5WITHBONUS.key;
        if(count >= 3 && count <= 6) return count;
        return NOTHING.key;
    }

    public static double calculateReturnRate(int budget, List<WinningType> result){
        int totalPrice = 0;
        for(WinningType wt : result){
            int price = wt.value * wt.price;
            totalPrice += price;
        }
        double returnRate = ((double)totalPrice/(double)budget)*100;
        returnRate = Math.round((returnRate*10))/10.0;
        return returnRate;
    }

}
