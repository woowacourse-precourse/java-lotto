package lotto;

import exception.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ViewerTest {
        @Test
    public void numberValidationTest() {
        Viewer viewer = new Viewer();
            ;

        assertThatThrownBy(() -> viewer.numberValidation("1,2,3,4,5,6,7"))
                .isInstanceOf(InputSizeException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> viewer.numberValidation("1,2,3,4,5,-1"))
                .isInstanceOf(OutOfRangeInputException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> viewer.numberValidation("1,2,3,4,5,d"))
                .isInstanceOf(InputParsingException.class)
                .hasMessageContaining("[ERROR]");

    }

    @Test
    public void bonusValidationTest() {
        Viewer viewer = new Viewer();

        assertThatThrownBy(() -> viewer.bonusValidation("1,"))
                .isInstanceOf(InputParsingException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> viewer.bonusValidation("-1"))
                .isInstanceOf(OutOfRangeInputException.class)
                .hasMessageContaining("[ERROR]");

    }

    @Test
    public void purchaseValidation() {
        Viewer viewer = new Viewer();

        assertThatThrownBy(() -> viewer.purchaseValidation("d"))
                .isInstanceOf(InputParsingException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> viewer.purchaseValidation("100"))
                .isInstanceOf(IllegalAmountException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> viewer.purchaseValidation("-1000"))
                .isInstanceOf(NegativeInputException.class)
                .hasMessageContaining("[ERROR]");

    }
}
