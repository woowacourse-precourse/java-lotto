package lotto;

import controller.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @DisplayName("로또번호를 구매수량만큼 뽑았는지 확인")
    @Test
    void 로또수량에_맞게_뽑았는지_확인하는_테스트(){
        assertThat(Random.getLottoNumber(6).size()).isEqualTo(6);
    }
}
