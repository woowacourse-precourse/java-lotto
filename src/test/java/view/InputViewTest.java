package view;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    static InputView inputView;

    @BeforeAll
    static void setInputView() {
        inputView = new InputView();
    }


    @ParameterizedTest
    @ValueSource(strings = {"r,r,r", "46", " , ", ", ", "1,2,3r", ",,,,, "})
    public void parseeInt(String userInput) {
        List<String> test = inputView.parseStringToList(userInput);
        assertThatThrownBy(()-> {
            inputView.checkEachInput(test);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "r", "", "46"})
    public void bonnusNumber_test(String userInput) {
        assertThatThrownBy(()-> {
            inputView.bonnusNumberException(userInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
