package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compare {

    public static List<Integer> userList ; //사용자 입력값
    public static HashMap<Integer, List<Integer>> randomLottos; //로또번호들
    public static int correctCount;
    public static HashMap<Integer, Integer> resultCount;

    public static void numbers() {
        resultCount = new HashMap<>();
        for (int i = 0; i < randomLottos.size(); i++) {
            correctCount =0;
            List<Integer> check = randomLottos.get(i);
            for (int j = 0; j < userList.size(); j++) {
                if(check.contains(userList.get(j))){
                    correctCount++;
                }
            }
            resultCount.put(i,correctCount);
            System.out.println(i+"번째 "+ resultCount+"개 번호 일치");
        }
    }
}
