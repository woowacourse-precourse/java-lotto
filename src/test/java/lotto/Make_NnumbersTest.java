package lotto;

import lotto.domain.Lotto;
import lotto.model.Make_Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Make_NnumbersTest {
    @DisplayName("제대로 랜덤한 로또를 만들었는지 확인")
    @Test
    void 랜덤한_로또생성_확인() {
        int lottoCnt = Constant.LOTTO_NUMBER_CNT.getNum();
        List<Lotto> test_Lotto = new Make_Numbers().make_RandomLotto(lottoCnt);
        int[] check_arr = new int[lottoCnt];
        for (int i = 0; i < lottoCnt; i++) {
            check_arr[i] = test_Lotto.get(i).getNumbers().size();
        }
        assertThat(check_arr).containsExactly(6, 6, 6, 6, 6, 6);
    }
}
