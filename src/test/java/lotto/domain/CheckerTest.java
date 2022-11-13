package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    Checker checker = new Checker();

    @Test
    void 당첨_번호_입력() {

        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        String numbers = "1,2,3,4,5,6";

        InputStream inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);

        checker.insertWinningNumbers();

        assertThat(checker.getWinningNumbers()).isEqualTo(result);

    }

    @Test
    void 보너스_번호_입력() {

        int result = 1;
        String numbers = "1";

        InputStream inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);

        checker.insertBonusNumber();

        assertThat(checker.getBonusNumber()).isEqualTo(result);

    }


}