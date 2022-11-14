package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest extends NsTest {

    @Test
    void notThousandException() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {

                    assertThatThrownBy(()->run("1500")).isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void winnerOutOfRangeException(){
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(()->run("1000","1,2,3,4,5,46")).isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    assertThatThrownBy(()->run("1000","0,2,3,4,5,6")).isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
    @Test
    void duplicatedInputException() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {

                    assertThatThrownBy(()->run("1000","1,1,3,4,5,6")).isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void bonusNumberOutOfRangeException() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {

                    assertThatThrownBy(()->run("1000","1,2,3,4,5,6","0")).isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );

        assertRandomUniqueNumbersInRangeTest(
                () -> {

                    assertThatThrownBy(()->run("1000","1,2,3,4,5,6","46")).isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }

    @Test
    void inputNotNumberException() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {

                    assertThatThrownBy(()->run("a","1,2,3,4,5,6")).isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
        assertRandomUniqueNumbersInRangeTest(
                () -> {

                    assertThatThrownBy(()->run("1000","a,1,3,4,5,6")).isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
        assertRandomUniqueNumbersInRangeTest(
                () -> {

                    assertThatThrownBy(()->run("1000","1,2,3,4,5,6","~")).isInstanceOf(IllegalArgumentException.class);
                },
                List.of(1, 2, 3, 4, 5, 6)
        );
    }
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
