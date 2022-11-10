package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstPlaceTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void createFirstPlace() {
        String firstPlace = "1,2,3,4,5,6";
        assertThat(new FirstPlace(firstPlace)).isEqualTo(new FirstPlace("1,2,3,4,5,6"));
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 쉼표랑 다른 구분자 있을 때")
    @Test
    void createFirstPlaceByNotDivideCommas() {
        String firstPlace = "1,2,3,4/5/6";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Please DIVIDE Number With Commas");
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 쉼표가 없을 때")
    @Test
    void createFirstPlaceByNotExistCommas() {
        String firstPlace = "1/2/3/4/5/6";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Please DIVIDE Number With Commas");
    }
}