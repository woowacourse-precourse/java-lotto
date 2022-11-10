package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstPlaceTest {

    @DisplayName("객체 생성 테스트1")
    @Test
    void createFirstPlace() {
        String firstPlace = "1,2,3,4,5,6";
        assertThat(new FirstPlace(firstPlace)).isEqualTo(new FirstPlace("1,2,3,4,5,6"));
    }

    @DisplayName("객체 생성 테스트2")
    @Test
    void createFirstPlace2() {
        String firstPlace = "10,21,31,45,15,36";
        assertThat(new FirstPlace(firstPlace)).isEqualTo(new FirstPlace("10,21,31,45,15,36"));
    }


    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다.")
    @Test
    void createFirstPlaceByNotDivideCommas1(){
        String firstPlace = "1,2,3,4,5,6,,,";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Please DIVIDE Number With Commas");
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 쉼표랑 다른 구분자 있을 때")
    @Test
    void createFirstPlaceByNotDivideCommas2() {
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

    @DisplayName("유요 숫자 범위 내 숫자를 입력하지 않으면 예외가 발생한다. 0 포함")
    @Test
    void createFirstPlaceByOutBoundNumber1() {
        String firstPlace = "0,1,2,3,4,5";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Have Out Bound Number.");
    }

    @DisplayName("유요 숫자 범위 내 숫자를 입력하지 않으면 예외가 발생한다. 46이상 포함")
    @Test
    void createFirstPlaceByOutBoundNumber2() {
        String firstPlace = "3,1,46,7,4,5";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Have Out Bound Number.");
    }

    @DisplayName("중복된 숫자를 입력하면 예외가 발생한다.")
    @Test
    void createFirstPlaceByDuplicateNumber() {
        String firstPlace = "1,2,3,4,4,5";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] Lotto Number Have Duplicate Number.");
    }
}