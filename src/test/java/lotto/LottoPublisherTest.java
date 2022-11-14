package lotto;

import lotto.Domain.LottoPublisher;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoPublisherTest {
    @DisplayName("로또 번호가 오름차순으로 정렬된다.")
    @Test
    void sortRandomNumberTest() {
        // given
        LottoPublisher lottoPublisher = new LottoPublisher();
        List<Integer> randomNumberList = new ArrayList<>();
        List<Integer> sortedRandomNumberList = new ArrayList<>();
        List<Integer> correctNumberList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        randomNumberList.add(3);
        randomNumberList.add(2);
        randomNumberList.add(1);

        // when
        sortedRandomNumberList = lottoPublisher.sortRandomLottoNumber(randomNumberList);

        // then
        assertThat(sortedRandomNumberList).isEqualTo(correctNumberList);

    }
}
