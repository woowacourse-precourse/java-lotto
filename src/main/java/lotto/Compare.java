package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compare {

    public static List<Integer> userList ; //사용자 입력값
    public static HashMap<Integer, List<Integer>> randomLottos; //로또번호들
    public static int correctCount;
    public static HashMap<Integer, Integer> resultCount;
    public static int bonusNumber;
    public static HashMap<Integer, Boolean> hasBonusNumber;
    public static boolean hasOrNot;

    public static void numbers() {
        resultCount = new HashMap<>();
        hasBonusNumber = new HashMap<>();
        for (int i = 0; i < randomLottos.size(); i++) {
            correctCount =0;
            hasOrNot = false;
            List<Integer> check = randomLottos.get(i);
            for (int j = 0; j < userList.size(); j++) {
                if(check.contains(userList.get(j))){
                    correctCount++;
                }
                if(check.contains(bonusNumber)){
                    hasOrNot = true;
                }
            }
            resultCount.put(i,correctCount);
            hasBonusNumber.put(i,hasOrNot);
            System.out.println(i+"번째 "+ resultCount+"개 번호 일치");
            System.out.println(i+"번째 보너스 번호 일치?" + (hasOrNot==true?"o":"x"));


        }


    }

    public static void getResult(){
        for (int i = 0; i < resultCount.size(); i++) {
            Result.getResult(resultCount.get(i), hasBonusNumber.get(i));
        }

    }

}
