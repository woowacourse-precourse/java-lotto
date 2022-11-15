package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LottosTest {
    @DisplayName("복수개의 로또를 생성한다.")
    @Test
    public void createLottos() {
        List<Integer> lottoOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoTwo = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> lottoThree = Arrays.asList(1, 2, 3, 4, 5, 8);

        Lotto firstLotto = new Lotto(lottoOne);
        Lotto secondLotto = new Lotto(lottoTwo);
        Lotto thirdLotto = new Lotto(lottoThree);

        Lottos lottos = new Lottos(Arrays.asList(firstLotto, secondLotto, thirdLotto));

        assertThat(lottos.getLottos()).contains(firstLotto, secondLotto, thirdLotto);
    }

    @DisplayName("로또의 가격을 반환한다.")
    @Test
    public void getLottoPrice() {
        List<Integer> lottoOne = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoTwo = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> lottoThree = Arrays.asList(1, 2, 3, 4, 5, 8);

        Lotto firstLotto = new Lotto(lottoOne);
        Lotto secondLotto = new Lotto(lottoTwo);
        Lotto thirdLotto = new Lotto(lottoThree);

        Lottos lottos = new Lottos(Arrays.asList(firstLotto, secondLotto, thirdLotto));

        assertThat(lottos.getLottoPrice()).isEqualTo(3000);
    }
}
