package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomLottos {
    private List<Lotto> randomLottos;
    public RandomLottos(int money){
        validateMoney(money);
        for(int i = 0; i < money/1000; ++i) {
            List<Integer> list = pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(list);
            randomLottos.add(new Lotto(list));
        }
    }
    private void validateMoney(int money){
        if(money < 0){
            throw new IllegalArgumentException("[ERROR] 음수가 아닌 정수를 입력해야 합니다.");
        }
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }
}
