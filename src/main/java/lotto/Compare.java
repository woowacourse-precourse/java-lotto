package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Result;
import lotto.view.FinalResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compare {

    public static List<Integer> userList ; //사용자 입력값
    public static HashMap<Integer, List<Integer>> randomLottos; //로또번호들
    public static int correctCount;
    public static HashMap<Integer, Integer> resultCount;

    public static ArrayList<Integer> finalResult;

    public static void numbers() {
        resultCount = new HashMap<>();
        for (int i = 0; i < randomLottos.size(); i++) {
            correctCount =0;
            correctCount = checkCount(i);
            resultCount.put(i,correctCount);
            System.out.println(i+"번째 "+ resultCount+"개 번호 일치");
        }
    }

    public static int checkCount(int index){
        List<Integer> check = randomLottos.get(index);
        for (int j = 0; j < userList.size(); j++) {
            if(check.contains(userList.get(j))){
                correctCount++;
            }
        }
        return correctCount;
    }
/*
    public static void getResult(){
        HashMap<Integer, Boolean> hasBonusNumber = BonusNumber.hasBonusNumber;
        for (int i = 0; i < resultCount.size(); i++) {
            System.out.println("aa" + Result.getResult(resultCount.get(i), hasBonusNumber.get(i)));
            Result result = Result.getResult(resultCount.get(i), hasBonusNumber.get(i));
            System.out.println(result);
            String re = String.valueOf(result);
            System.out.println(result);
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

 */


}
