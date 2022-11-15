package lotto;

import lotto.ui.InputScanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private Scanner scanner;
    private InputScanner inputScanner;
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        Lotto lotto=new Lotto(List.of(1, 2, 3, 4, 5, 5));
        String input = "1,2,3,4,5,5";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        scanner = new Scanner(System.in);
        inputScanner = new InputScanner();
        assertThatThrownBy(() -> inputScanner.validateWinningNumbers(String.valueOf(scanner)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
