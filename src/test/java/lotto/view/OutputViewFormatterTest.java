package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputViewFormatterTest {
    private OutputViewFormatter outputViewFormatter;

    @BeforeEach
    void setUp() {
        this.outputViewFormatter = new OutputViewFormatter();
    }

    @DisplayName("로또 번호는 오름차순으로 정렬하여 보여준다.")
    @Test
    void outputLotto() {
        assertThat(outputViewFormatter.outputLottoFormat(new Lotto(List.of(45, 16, 26, 2, 34, 7))))
                .isEqualTo("[2, 7, 16, 26, 34, 45]");
    }
}
