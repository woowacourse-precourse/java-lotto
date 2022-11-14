package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

class LottoTest2 {
    @DisplayName("로또 번호의 개수가 6을 넘어가면 예외가 발생한다.")
    @Test
    void createLottoOverSize(){
        assertThatThrownBy(() -> new Lotto(List.of(4,2,3,1,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber(){
        assertThatThrownBy(()->new Lotto(List.of(1,2,3,4,5,5))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 숫자가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void createLottoOverRange(){
        assertThatThrownBy(()-> new Lotto(List.of(-1,1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> new Lotto(List.of(1,2,3,4,5,47))).isInstanceOf(IllegalArgumentException.class);
    }
}