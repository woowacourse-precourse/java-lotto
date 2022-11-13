package lotto.exception;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OverlapsNumberExceptionTest {
    String[] testInputValue = new String[]{"1", "2", "3", "4", "5", "6"};
    List<String> testResult = new ArrayList<String>(Arrays.asList(testInputValue));
    String bonusNumber1 = "1";
    String bonusNumber9 = "9";

    @Test
    void overlapsCheckTest() {
        assertThat(OverlapsNumberException.overlapsCheck(testInputValue)).isEqualTo(testResult);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> OverlapsNumberException.overlapsCheck(new String[]{"1", "2", "3", "4", "5", "1"}));
    }//overlapsCheckTest

    @Test
    void bonusOverlapsCheckTest() {
        assertThat(OverlapsNumberException.bonusOverlapsCheck(testResult, bonusNumber9)).isEqualTo(bonusNumber9);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> OverlapsNumberException.bonusOverlapsCheck(testResult, bonusNumber1));
    }// bonusOverlapsCheckTest
}// end class
