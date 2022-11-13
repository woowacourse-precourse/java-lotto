package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class PickNumber {
    public static void pick_number_of_lotto(int pages_of_lotto){
        StringBuilder sb=new StringBuilder();
        sb.append('\n').append(pages_of_lotto+"개를 구매했습니다.").append('\n');
        for (int i=0;i<pages_of_lotto;i++){
            List<Integer> page_of_lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            sb.append(page_of_lotto).append('\n');
        }
    }
}