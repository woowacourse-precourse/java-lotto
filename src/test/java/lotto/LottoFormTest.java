package lotto;

import lotto.data.Error;
import lotto.presentation.LottoForm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoFormTest {
    LottoForm lottoForm;

    @BeforeEach
    void setUp() {
        lottoForm = new LottoForm();
    }

    @DisplayName("정상적인 값이 들어올 경우 해당 금액을 반환한다.")
    @Test
    void inputPrice() {
        int expected = 8000;
        String expectedInput = "8000";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        int price = lottoForm.inputPrice();
        assertEquals(expected, price);
    }

    @DisplayName("금액이 아닌 값을 입력할 경우 예외가 발생한다.")
    @Test
    void inputPriceWithInvalidPrice() {
        String expectedInput = "8000f";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> lottoForm.inputPrice());

        assertEquals(exception.getMessage(), Error.NOT_NUMERIC.getMessage());
    }

    @DisplayName("1000원으로 나누어 떨어지지 않은 값을 입력한 경우 예외가 발생한다.")
    @Test
    void inputPriceNotDivisibleWithThousand() {
        String expectedInput = "80008";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> lottoForm.inputPrice());

        assertEquals(exception.getMessage(), Error.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
    }

    @DisplayName("정상적인 값이 들어올 경우 해당 번호를 반환한다.")
    @Test
    void inputWinningNumbers() {
        String expectedInput = "1,2,3,4,5,6";
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        List<Integer> winningNumbers = lottoForm.inputWinningNumbers();
        assertEquals(expectedNumbers, winningNumbers);
    }

    @DisplayName("숫자와 ,가 아닌 값이 입력될 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersByNotNumeric() {
        String expectedInput = "1,2,3,4,5,f";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> lottoForm.inputWinningNumbers());

        assertEquals(exception.getMessage(), Error.NOT_NUMERIC.getMessage());
    }

    @DisplayName("로또 개수가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersByInvalidSize() {
        String expectedInput = "1,2,3,4,5,6,7";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> lottoForm.inputWinningNumbers());

        assertEquals(exception.getMessage(), Error.INVALID_SIZE.getMessage());
    }

    @DisplayName("숫자가 1부터 45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersByOutOfRange() {
        String expectedInput = "1,2,3,4,5,65";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> lottoForm.inputWinningNumbers());

        assertEquals(exception.getMessage(), Error.OUT_OF_RANGE.getMessage());
    }

    @DisplayName("중복된 숫자를 포함하는 경우 예외가 발생한다.")
    @Test
    void inputWinningNumbersWithDuplicateNumber() {
        String expectedInput = "1,2,3,4,5,5";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> lottoForm.inputWinningNumbers());

        assertEquals(exception.getMessage(), Error.DUPLICATE_NUMBER.getMessage());
    }

    @DisplayName("정상적인 값이 들어올 경우 해당 보너스 번호를 반환한다.")
    @Test
    void inputBonus() {
        String expectedInput = "1";
        int expected = 1;

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        int bonus = lottoForm.inputBonus();
        assertEquals(expected, bonus);
    }

    @DisplayName("숫자가 아닌 값이 입력될 경우 예외가 발생한다.")
    @Test
    void inputBonusByNotNumeric() {
        String expectedInput = "1f";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> lottoForm.inputWinningNumbers());

        assertEquals(exception.getMessage(), Error.NOT_NUMERIC.getMessage());
    }

    @DisplayName("숫자가 1부터 45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void inputBonusByOutOfRange() {
        String expectedInput = "61";

        InputStream inputStream = new ByteArrayInputStream(expectedInput.getBytes());
        System.setIn(inputStream);

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> lottoForm.inputWinningNumbers());

        assertEquals(exception.getMessage(), Error.OUT_OF_RANGE.getMessage());
    }
}