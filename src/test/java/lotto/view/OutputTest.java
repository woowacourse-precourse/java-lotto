package lotto.view;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {

    @Test
    void printLottoNumber() {
//        assertThat();
        OutputView.printLottoNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        System.out.println(111111);
    }
}
