package myTest;

import lotto.domain.NumberGenerator;
import lotto.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @DisplayName("금액 입력값 검사")
    @Test
    void inputMoneyTest(){
        assertThatThrownBy(()-> new User("100012j"))
                .isInstanceOf(NoSuchElementException.class);

        assertThatThrownBy(()-> new User("10001"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
