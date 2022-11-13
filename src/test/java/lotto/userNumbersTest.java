package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class userNumbersTest {

    @Test
    void getNumbers() {
        userNumbers userNumbers=new userNumbers("1,2,3,4,5,6");
        assertThat(userNumbers.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void addBonusNumber() {
        userNumbers userNumbers=new userNumbers("1,2,3,4,5,6");
        assertThat(userNumbers.getNumbers().size()).isEqualTo(6);
        userNumbers.addBonusNumber(7);
        assertThat(userNumbers.getNumbers().size()).isEqualTo(7);
    }
    @Test
    void testErrorCheck(){
        assertThatThrownBy(() -> new userNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new userNumbers("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}