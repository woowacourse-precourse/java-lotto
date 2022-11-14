package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.Application.*;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest2 {

    @DisplayName("수익률 계산 함수 테스트")
    @Test
    void calculateEarningsTest() {
        int rank[] = {0, 0, 0, 1, 0, 0, 0, 0};
        int inputMoney=1000;
        double earning=calculateEarnings(rank, inputMoney);
        assertThat(earning).isEqualTo(500.0);
    }

    @DisplayName("유저 숫자와 로또들 비교 함수 테스트")
    @Test
    void compareUserInputLottosTest() {
        List<Integer> tmpLotto=List.of(1, 2, 3, 4, 5, 6);
        List<Integer> tmpLotto2=List.of(3, 4, 5, 6, 7, 8);
        ArrayList<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(tmpLotto));
        lottos.add(new Lotto(tmpLotto2));
        List<Integer> numbers= List.of(1, 2, 3, 4, 5, 6, 7);
        int result[]=compareUserInputLottos(lottos, numbers);
        assertThat(result[4]).isEqualTo(1);
        assertThat(result[6]).isEqualTo(1);
    }

    @DisplayName("로또 만들기 함수 테스트")
    @Test
    void makeLottoTest() {
        List<Lotto> lottos=makeLotto(3);
        assertThat(lottos).hasSize(3);
        assertThat(lottos.get(0).getNumbers()).hasSize(6);
    }
}