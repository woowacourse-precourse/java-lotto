package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import lotto.Application;
import lotto.exception.InputNotNumberException;
import lotto.exception.InvalidAmountValueException;
import lotto.exception.NumberOutOfRangeException;
import lotto.exception.NumbersDuplicatedException;
import lotto.exception.SmallAmountException;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {

    private final InputView inputView = new InputView();

    @Test
    void inputAmount_success() {
        String input = "1000";
        mockIO(input);

        int result = inputView.inputAmount();
        assertThat(Integer.parseInt(input)).isEqualTo(result);
    }

    @Test
    void inputAmount_fail_not_number() {
        assertThatThrownBy(() -> {
            String input = "1000d";
            mockIO(input);
            inputView.inputAmount();
        }).isInstanceOf(InputNotNumberException.class);
    }

    @Test
    void inputAmount_fail_too_small() {
        assertThatThrownBy(() -> {
            String input = "100";
            mockIO(input);
            inputView.inputAmount();
        }).isInstanceOf(SmallAmountException.class);
    }

    @Test
    void inputAmount_fail_not_valid() {
        assertThatThrownBy(() -> {
            String input = "1500";
            mockIO(input);
            inputView.inputAmount();
        }).isInstanceOf(InvalidAmountValueException.class);
    }

    @Test
    void inputBonusNumber_fail_duplicated() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        assertThatThrownBy(() -> {
            String input = "1";
            mockIO(input);
            inputView.inputBonusNumber(numbers);
        }).isInstanceOf(NumbersDuplicatedException.class);
    }

    @Test
    void inputBonusNumber_fail_out_of_range() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        assertThatThrownBy(() -> {
            String input = "55";
            mockIO(input);
            inputView.inputBonusNumber(numbers);
        }).isInstanceOf(NumberOutOfRangeException.class);
    }

    @Test
    void inputWinningNumbers_success() {
        String input = "1,2,3,4,5,6";
        mockIO(input);
        List<Integer> numbers = inputView.inputWinningNumbers();
        assertThat(numbers.size()).isEqualTo(input.split(",").length);
    }

    @Test
    void inputWinningNumbers_fail_duplicated(){
        assertThatThrownBy(() -> {
            String input = "1,2,3,4,5,5";
            mockIO(input);
            inputView.inputWinningNumbers();
        }).isInstanceOf(NumbersDuplicatedException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    private void mockIO(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}