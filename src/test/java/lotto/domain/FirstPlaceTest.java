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
        String bonus = "8";
        assertThat(new FirstPlace(firstPlace)).isEqualTo(new FirstPlace("1,2,3,4,5,6"));
    }
}