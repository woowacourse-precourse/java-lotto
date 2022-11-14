package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGameTest {

    @ParameterizedTest
    @ValueSource(ints = {8000, 7000, 6000, 5000})
    void 가격에_맞는_로또_발행_테스트(int price) {
        //given
        int lotto_number = price / 1000;

        //when
        LottoGame lottoGame = new LottoGame(price);

        //then
        assertEquals(lotto_number, lottoGame.getUserLottos().size());
    }
}
