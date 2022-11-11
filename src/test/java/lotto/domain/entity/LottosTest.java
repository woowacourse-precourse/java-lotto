package lotto.domain.entity;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("정렬 된 로또 번호 확인 Test")
    @Test
    public void lottosSortedNumbersTest() throws Exception {
        Lottos lottos = Lottos.from(1);
        List<Lotto> lotto = lottos.currentLottos();
        Lotto oneLottoGame = lotto.get(0);

        List<Integer> numbers = oneLottoGame.currentLottoNumbers();
        List<Integer> compareNumbers = new ArrayList<>(numbers);
        Collections.sort(compareNumbers);

        Assertions.assertThat(numbers).isEqualTo(compareNumbers);
    }

    @Test
    public void uniqueRandomNumberSortingTest() throws Exception {
        for (int i = 0; i < 10; i++) {
            List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(integers);
            System.out.println("integers = " + integers);
        }
    }
}
