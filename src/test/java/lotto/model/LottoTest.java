package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    static Lotto lotto;

    @BeforeAll
    static void initAll() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        lotto = new Lotto(numbers);
    }

    @DisplayName("Lotto 객체 생성 시 매개변수로 입력한 리스트를 getNumber로 불러올 수 있다.")
    @Test
    void getNumberTest() {
        List<Integer> expect = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).isEqualTo(expect);
    }

    @DisplayName("Lotto 객체에 addPrize 로 1 추가시 prize가 1로 업데이트 되며, getPrize로 불러올 수 있다.")
    @Test
    void addPrizeTestTest() {
        lotto.addPrize(1);
        assertThat(lotto.prize).isEqualTo(1);
        assertThat(lotto.getPrize()).isEqualTo(1);
    }

    @DisplayName("Lotto 객체에 addPrizeMoney로 5000 추가시 prizeMoney가 5000으로 업데이트 되며, getPirzeMoney로 불러올 수 있다.")
    @Test
    void addPrizeMoneyTest() {
        lotto.addPrizeMoney(5000);
        assertThat(lotto.prizeMoney).isEqualTo(5000);
        assertThat(lotto.getPrizeMoney()).isEqualTo(5000);
    }
}