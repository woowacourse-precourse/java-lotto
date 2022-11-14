package lotto.validate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoValidateTest {

    private LottoValidate lottoValidate;

    @BeforeEach
    void setUp(){
        lottoValidate = new LottoValidate();
    }

    @DisplayName("로또 번호의 개수가 6보다 작으면 예외발생")
    @Test
    void 로또_번호_개수가_5개일때(){
        assertThatThrownBy(() -> lottoValidate.validate(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6보다 크면 예외발생")
    @Test
    void 로또_번호_개수가_7개일때(){
        assertThatThrownBy(() -> lottoValidate.validate(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복이 있으면 예외발생")
    @Test
    void 로또_번호에_중복이_있을때(){
        assertThatThrownBy(() -> lottoValidate.validate(List.of(1,2,3,4,5,1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 범위는 1~45이다. 벗어나면 예외 발생")
    @Test
    void 로또_번호_범위_테스트(){
        assertThatThrownBy(() -> lottoValidate.validate(List.of(1,2,3,4,5,111)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}