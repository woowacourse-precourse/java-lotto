package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @DisplayName("사용자 입력값이 1,000의 배수가 아니라면 예외가 발생한다.")
    @Test
    public void userAmount_test(){
        assertThatThrownBy(()->new Money(123456)).isInstanceOf(IllegalArgumentException.class);
    }

}