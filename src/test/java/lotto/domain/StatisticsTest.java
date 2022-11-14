package lotto.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class StatisticsTest {
    @Test
    void test(){
        List<Lotto> lottos = List.of(new Lotto(List.of(1,2,3,4,5,6)),
                                    new Lotto(List.of(1,2,3,4,5,40)),
                                    new Lotto(List.of(1,2,3,4,5,12)),
                                    new Lotto(List.of(3,4,5,6,13,14)),
                                    new Lotto(List.of(4,5,6,13,14,15)),
                                    new Lotto(List.of(5,12,13,14,15,16)),
                                    new Lotto(List.of(2,3,4,5,6,36)),
                                    new Lotto(List.of(11,12,13,14,15,16)));
        String input = "1,2,3,4,5,6\n40";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        WinningNumbers winningNumbers = new WinningNumbers();
        Statistics statistics = new Statistics(winningNumbers, lottos);
        Map<Grade, Integer> gradeCount = statistics.getGradeCount();

        Map<Grade, Integer> result = Map.of(Grade.FIRST,1, Grade.SECOND, 1, Grade.THIRD, 2, Grade.FOURTH, 1, Grade.FIFTH, 1, Grade.NOTHING, 2);

        assertThat(gradeCount).isEqualTo(result);
    }

}