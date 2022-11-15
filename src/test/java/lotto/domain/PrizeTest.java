package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @DisplayName("prize 찾는것을 확인")
    @ParameterizedTest
    @CsvSource({"6,false,first", "5,true,second", "5,false,third", "4,false,fourth", "3,false,fifth"})
    void findPrize(int catchPoint, boolean bonusPoint, Prize excepted) {
        assertThat(Prize.find(catchPoint, bonusPoint)).isEqualTo(excepted);
    }

}