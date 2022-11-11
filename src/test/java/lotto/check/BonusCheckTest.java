package lotto.check;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BonusCheckTest {

    @DisplayName("정상적인 보너스 입력 테스트")
    @Test
    void bonusCheckTest(){

        assertThat(BonusCheck.check("42", new Lotto(List.of(1,2,3,4,5,6)))).isEqualTo(42);
    }

    @DisplayName("보너스 중복 테스트")
    @Test
    void bonusDuplicateTest(){
        assertThatThrownBy(()->{
            BonusCheck.check("42", new Lotto(List.of(1,2,3,42,5,6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 아닌 값 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"qw","1q","2e","2  3"})
    void bonusCheckTest(String s){
        assertThatThrownBy(()->{
            BonusCheck.check(s,new Lotto(List.of(1,2,3,4,5,6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값 범위 테스트")
    @ParameterizedTest
    @ValueSource(strings={"49","47","88"})
    void rangeTest(String s){
        assertThatThrownBy(()->{
            BonusCheck.check(s,new Lotto(List.of(1,2,3,4,5,6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}