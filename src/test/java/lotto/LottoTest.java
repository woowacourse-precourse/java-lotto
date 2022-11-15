package lotto;

import lotto.domain.Lotto;
import lotto.serviceImpl.LottoGameServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    private static Lotto basicLotto;

    @BeforeAll
    public static void init(){
        basicLotto = new Lotto("1,2,3,4,5,6");
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("만들어지는 로또 개수만큼 리스트가 반환되야 한다.")
    @Test
    void isUserValidLottoNumbers() {
        // given
        int input = 6;
        int expectSize = 6;
        List<Lotto> result = new LottoGameServiceImpl().makeLottoWinningNumbers(input);

        // when, then
        assertThat(result.size()).isEqualTo(expectSize);
    }

    @DisplayName("1~45 범위가 넘어서면 예외가 발생한다.")
    @Test
    void isIntRange() {
        // given
        int input = 46;

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            basicLotto.isNumberAndInRange(input);
        });
    }

    @DisplayName("로또번호가 담긴 리스트가 반환 되야 한다.")
    @Test
    void getLotto(){
        // given, when, then
        List<Integer> lotto = basicLotto.getNumbers();
    }

    @DisplayName("반환된 로또의 수는 6개여야 한다.")
    @Test
    void isLottoRangeSix(){
        // given
        int expect = 6;
        List<Integer> lotto = basicLotto.getNumbers();

        // when, then
        assertThat(lotto.size()).isEqualTo(expect);
    }
}
