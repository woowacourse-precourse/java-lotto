package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {
    @DisplayName("createLottos 메서드로 정해진 갯수만큼 로또 만들기")
    @Test
    public void createLottos_메서드로_정해진_갯수만큼_로또_만들기() throws Exception {
        //given
        LottoFactory factory = new LottoFactory();
        int quantity = 4;
        //when
        List<Lotto> lottos = factory.createLottos(quantity);

        //then
        assertThat(lottos.size()).isEqualTo(quantity);
    }

    @DisplayName("createLottos 메서드로 만들어진 로또가 오름차순인지 테스트")
    @Test
    public void createLottos_메서드로_만들어진_로또가_오름차순인지_테스트() throws Exception {
        //given
        LottoFactory factory = new LottoFactory();
        int quantity = 4;

        //when
        List<Lotto> lottos = factory.createLottos(quantity);

        //then
        for (Lotto lotto : lottos) {
            assertThat(this.isAscendingOrdered(lotto.getNumbers())).isEqualTo(true);
        }
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