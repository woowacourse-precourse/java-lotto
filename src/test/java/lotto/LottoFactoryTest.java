package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoFactoryTest {
    LottoFactory factory = new LottoFactory();

    @DisplayName("createLottos 메서드로 정해진 갯수만큼 로또 만들기")
    @Test
    public void createLottos_메서드로_정해진_갯수만큼_로또_만들기() throws Exception {
        //given
        int quantity = 4;

        //when
        List<Lotto> lottos = factory.createLottos(quantity);

        //then
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @DisplayName("숫자 리스트를 넘겨 createLotto 메서드로 하나의 로또 만들기")
    @Test
    public void 숫자리스트를_넘겨_createLotto_메서드로_하나의_로또_만들기() throws Exception {
        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        //when
        Lotto lotto = factory.createLotto(numbers);

        //then
        assertThat(lotto).isNotNull();
    }

    public boolean isAscendingOrdered(List<Integer> numbers) {
        int prevNumber = numbers.get(0);
        for (int numbersIndex = 1; numbersIndex < numbers.size(); numbersIndex++) {
            if (numbers.get(numbersIndex) <= prevNumber) {
                throw new IllegalArgumentException();
            }

            if (numbers.get(numbersIndex) > prevNumber) {
                prevNumber = numbers.get(numbersIndex);
            }
        }
        return true;
    }
}