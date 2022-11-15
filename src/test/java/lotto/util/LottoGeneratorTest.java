package lotto.util;

import lotto.domain.Lotto;
import lotto.validate.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {

    @DisplayName("로또 번호 갯수 테스트")
    @Test
    void lottoNumberSizeTest() {
        //given
        final int money = 1000;
        //when
        List<Integer> numbers = LottoGenerator.sellLottos(money)
                .get(0)
                .getNumbers();
        //then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 1 ~ 45 범위 테스트")
    @Test
    void lottoNumberRangeTest() {
        //given
        final int money = 1000;
        //when
        List<Integer> numbers = LottoGenerator.sellLottos(money)
                .get(0)
                .getNumbers();
        //then
        assertThat(numbers.stream()
                .allMatch(Validator::isBetween1And45))
                .isTrue();
    }

    @DisplayName("구매금액만큼 로또가 구입됐는지 테스트")
    @Test
    void buyLottoSizeTest() {
        //given
        final int money = 9000;
        //when
        List<Lotto> lottos = LottoGenerator.sellLottos(money);
        //then
        assertThat(lottos.size()).isEqualTo(9);
    }

    @DisplayName("자동 발행된 로또가 오름차순인지 테스트")
    @Test
    void buyLottoSortTest() {
        //given
        final int money = 1000;
        //when
        List<Integer> numbers = LottoGenerator.sellLottos(money)
                .get(0)
                .getNumbers();
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        //then
        assertThat(numbers).isEqualTo(sortedNumbers);
    }
}