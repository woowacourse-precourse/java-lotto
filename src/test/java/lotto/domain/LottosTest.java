package lotto.domain;

import lotto.dto.LottoResponseDtos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static lotto.dto.LottoResponseDtos.LottoResponseDto;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("플레이어가 구매한 로또 정보를 오름차순으로 정렬해서 반환")
    @Test
    void getLottosWithSorting() {
        List<List<Integer>> lottoNumbers = createSortTestLottoNumbers();

        Lottos lottos = LottosCashier.create(3000, lottoNumbers);
        LottoResponseDtos purchaseLottos = lottos.toResponseDto();
        List<LottoResponseDto> responseDtos = purchaseLottos.getLottoResponseDtos();
        List<List<Integer>> answer = createAnswer();

        for (int i = 0; i < responseDtos.size(); i++) {
            List<Integer> lottoNumber = responseDtos.get(i).getLottoNumber();
            List<Integer> answerNumber = answer.get(i);
            for (int j = 0; j < lottoNumber.size(); j++) {
                assertThat(lottoNumber.get(j)).isEqualTo(answerNumber.get(j));
            }
        }
    }

    private List<List<Integer>> createSortTestLottoNumbers() {
        List<List<Integer>> lottoNumbers =  new ArrayList<>();
        lottoNumbers.add(new ArrayList<>(List.of(6, 5, 4, 3, 2, 1)));
        lottoNumbers.add(new ArrayList<>(List.of(5, 3, 2, 6, 8, 1)));
        lottoNumbers.add(new ArrayList<>(List.of(6, 3, 2, 8, 17, 7)));
        return lottoNumbers;
    }

    private List<List<Integer>> createAnswer() {
        return List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 5, 6, 8),
                List.of(2, 3, 6, 7, 8, 17)
        );
    }

    @DisplayName("get 메소드 테스트")
    @Test
    void get() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto, otherLotto));

        assertThat(lottos.get(0)).isEqualTo(lotto);
        assertThat(lottos.get(1)).isEqualTo(otherLotto);
    }

    @DisplayName("toResponseDto 메소드 테스트")
    @Test
    void toResponseDto() {
        List<Integer> lottoNumbers = new LinkedList<>(List.of(6, 5, 4, 3, 2, 1));
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.toResponseDto().getLottoNumber()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
