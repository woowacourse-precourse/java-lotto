package lotto.domain.random;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.jackpot.Jackpot;

import java.util.ArrayList;
import java.util.List;
//예기치 못한 오류 테스트 커밋
public class PickNumber {

    public static List<List<Integer>> purchased_lotto=new ArrayList<>();

    public static void pick_number_of_lotto(int pages_of_lotto){
        StringBuilder sb=new StringBuilder();

        sb.append('\n').append(pages_of_lotto+"개를 구매했습니다.").append('\n');

        for (int i=0;i<pages_of_lotto;i++){
            List<Integer> page_of_lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchased_lotto.add(page_of_lotto);
            sb.append(page_of_lotto).append('\n');
        }

        System.out.println(sb);
        Jackpot.input_jackpot_number();
    }

    public static List<List<Integer>> get_purchased_lotto_list(){
        return purchased_lotto;
    }
}