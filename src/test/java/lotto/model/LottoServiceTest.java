package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private LottoService service = new LottoService(1000);

    @DisplayName("로또번호의 오름차순 정렬 테스트")
    @Test
    void sortLottoNumbersByAscending() {
        List<Integer> nonSortedNumbers = new ArrayList<>(List.of(6, 5, 4, 3, 2, 1));
        service.sortLotto(nonSortedNumbers);

        assertThat(nonSortedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

}