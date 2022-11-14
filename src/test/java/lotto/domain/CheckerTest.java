package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    Checker checker = new Checker();

    @BeforeEach
    void 당첨_번호_입력() {

        List<Integer> result = List.of(1, 2, 3, 4, 5, 6);
        String numbers = "1,2,3,4,5,6";

        InputStream inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);

        checker.insertWinningNumbers();

        assertThat(checker.getWinningNumbers()).isEqualTo(result);

    }

    @BeforeEach
    void 보너스_번호_입력() {

        int result = 7;
        String numbers = "7";

        InputStream inputStream = new ByteArrayInputStream(numbers.getBytes());
        System.setIn(inputStream);

        checker.insertBonusNumber();

        assertThat(checker.getBonusNumber()).isEqualTo(result);

    }

    @Test
    void 모든_당첨_순위_확인() {

        List<List<Integer>> numbers = List.of(
                List.of(1,2,3,8,9,10),  // 3
                List.of(1,2,3,4,9,10),  // 4
                List.of(1,2,3,4,5,10),  // 5
                List.of(1,2,3,4,5,7),   // 5, 1
                List.of(1,2,3,4,5,6)    // 6
        );

        HashMap<Integer, Integer> result = new HashMap<>() {{
            put(3, 1);
            put(4, 1);
            put(5, 1);
            put(6, 1);
            put(7, 1);
        }};

        for (int i = 0;i < numbers.size();i++) {
            checker.checkMyLotto(numbers.get(i));
        }

        checker.showWinningStats();

        assertThat(checker.getWinningStats()).isEqualTo(result);

    }

}