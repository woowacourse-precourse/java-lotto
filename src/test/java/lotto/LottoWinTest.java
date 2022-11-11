package lotto;

import java.util.List;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinTest {

    @DisplayName("중복된 보너스 번호가 들어오면 에러가 발생한다")
    @Test
    void duplicatedBonusNumber(){
        assertThatThrownBy(() -> new LottoWin(List.of(List.of(1,2,3,4,5,6)),List.of(1,2,3,4,5,6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1~45 범위에서 벗어난 보너스 번호가 들어오면 에러가 발생한다")
    @Test
    void outOfBoundBonusNumber(){
        assertThatThrownBy(() -> new LottoWin(List.of(List.of(1,2,3,4,5,6)),List.of(1,2,3,4,5,6), 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoWin(List.of(List.of(1,2,3,4,5,6)),List.of(1,2,3,4,5,6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("1등 출력 확인")
    @Test
    void firstPrize(){
        LottoWin lottoPrizes = new LottoWin(List.of(List.of(1,2,3,4,5,6)),List.of(1,2,3,4,5,6),7);
        assertThat(lottoPrizes.getPrizesMap()).contains(entry("1st",1));

    }

}
