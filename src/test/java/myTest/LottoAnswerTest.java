package myTest;

import lotto.domain.LottoAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAnswerTest {

    @DisplayName("입력값 검사")
    @Test
    void inputTest(){
        assertThatThrownBy(()-> new LottoAnswer("1,2,3,4,5","7"))
                .isInstanceOf(NoSuchElementException.class);

        assertThatThrownBy(()-> new LottoAnswer("1,2,3,4,5,47","7"))
                .isInstanceOf(NoSuchElementException.class);

        assertThatThrownBy(()-> new LottoAnswer("1,2,3,4,5,6","5"))
                .isInstanceOf(NoSuchElementException.class);
    }

}
