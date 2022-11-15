package lotto;

import lotto.domain.RandomLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomLottoTest {

    @Test
    void 로또_번호_생성_확인() {
        int money = 8;
        RandomLotto randomLotto = new RandomLotto(money);
        final List<List<Integer>> lottos = randomLotto.getLottos();

        System.out.println(lottos);
    }
}
