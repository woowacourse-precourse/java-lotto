package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    @DisplayName("일치하는 숫자에 따라서 해당되는 Rank의 toString 가져오기. 단 2등은 출력되지 않는다.")
    @Test
    void rankingToStringTest(){
        List<String> rank= IntStream.rangeClosed(0,6)
            .mapToObj(Rank::ranking)
            .map(Rank::toString)
            .collect(Collectors.toList());

        assertThat(rank).contains(
            "3개 일치 (5,000원) - ",
            "4개 일치 (50,000원) - ",
            "5개 일치 (1,500,000원) - ",
            "6개 일치 (2,000,000,000원) - ");
    }

}
