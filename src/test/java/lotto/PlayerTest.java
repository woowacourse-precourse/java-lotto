package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 에러가 발생한다. ")
    @Test
    void createLottoCashBy1000(){
        User.putMoney()
        assertThatThrownBy(()-> User.)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 구입 입력이 정수가 아니면 에러가 발생한다. ")
    @Test
    void createLottoCashByInteger(){
        assertThatThrownBy(()-> new Lotto(List.of(1, 2, 3 ,4, 55, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
