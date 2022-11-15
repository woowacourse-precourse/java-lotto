package lotto.model;

import java.util.HashMap;
import java.util.List;

public class Compare {
    public static List<Integer> userList ;
    public static HashMap<Integer, List<Integer>> randomLottos;
    public static int correctCount;
    public static HashMap<Integer, Integer> resultCount;

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
}
