package lotto.object;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.input_output.Input;

import java.util.ArrayList;
import java.util.List;

public class User extends Input {
    /*
    ### User

- [ ] 구입 금액 입력
- [ ] 1000원 당 6자리 로또 발행
- [ ] 발행한 로또 추가하는 함수

     */
    private List<List<Integer>> lottery_nums = new ArrayList<>();
    private Integer lottery_count;

    public void pay_Money(){// 구입 금액 입력
        int money = returnInt();
        this.lottery_count = money / 1000;
    }

}
