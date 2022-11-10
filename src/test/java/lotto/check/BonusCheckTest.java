package lotto.check;

import lotto.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BonusCheckTest {
    BonusCheck bonusCheck;
    @BeforeEach
    void setUp() {
        bonusCheck = new BonusCheck();
    }

    @Test
    void bonusCheckTest(){
        assertThat(bonusCheck.check("42", new Lotto(List.of(1,2,3,4,5,6)))).isEqualTo(42);
    }

    @Test
    void bonusDuplicateTest(){
        assertThatThrownBy(()->{
            bonusCheck.check("42", new Lotto(List.of(1,2,3,42,5,6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"qw","1q","2e","2  3"})
    void bonusCheckTest(String s){
        assertThatThrownBy(()->{
            bonusCheck.check(s,new Lotto(List.of(1,2,3,4,5,6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings={"49","47","88"})
    void rangeTest(String s){
        assertThatThrownBy(()->{
            bonusCheck.check(s,new Lotto(List.of(1,2,3,4,5,6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}