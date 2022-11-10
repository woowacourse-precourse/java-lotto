package lotto;

import lotto.domain.Input;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * packageName : lotto
 * fileName : InputTest
 * author : gim-yeong-geun
 * date : 2022/11/10
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/10         gim-yeong-geun          최초 생성
 */
public class InputTest {
    @DisplayName("1000원 단위 미만의 금액을 입력시 오류가 발생한다")
    @Test
    void inputCoinTest(){
        assertThatThrownBy(() -> Input.coinError(11100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
