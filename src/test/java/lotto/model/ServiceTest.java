package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceTest {

    @DisplayName("1등 당첨 테스트")
    @Test
    void rank1Test() {
        int lottoAmount = 2;
        List<List<Integer>> lottoNumbers = new ArrayList<>(Collections.emptyList());
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        lottoNumbers.add(List.of(11, 12, 13, 14, 15, 16));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int winningBonusNumber = 7;
        int[] result = new Service(lottoAmount, lottoNumbers, winningLottoNumbers, winningBonusNumber).getLottoResult();

        assertThat(result).isEqualTo(new int[]{1, 0, 0, 0, 0});
    }

    @DisplayName("2등 당첨 테스트")
    @Test
    void rank2Test() {
        int lottoAmount = 2;
        List<List<Integer>> lottoNumbers = new ArrayList<>(Collections.emptyList());
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        lottoNumbers.add(List.of(11, 12, 13, 14, 15, 16));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        int winningBonusNumber = 6;
        int[] result = new Service(lottoAmount, lottoNumbers, winningLottoNumbers, winningBonusNumber).getLottoResult();

        assertThat(result).isEqualTo(new int[]{0, 1, 0, 0, 0});
    }

    @DisplayName("3등 당첨 테스트")
    @Test
    void rank3Test() {
        int lottoAmount = 2;
        List<List<Integer>> lottoNumbers = new ArrayList<>(Collections.emptyList());
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        lottoNumbers.add(List.of(11, 12, 13, 14, 15, 16));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 7);
        int winningBonusNumber = 8;
        int[] result = new Service(lottoAmount, lottoNumbers, winningLottoNumbers, winningBonusNumber).getLottoResult();

        assertThat(result).isEqualTo(new int[]{0, 0, 1, 0, 0});
    }

    @DisplayName("4등 당첨 테스트")
    @Test
    void rank4Test() {
        int lottoAmount = 2;
        List<List<Integer>> lottoNumbers = new ArrayList<>(Collections.emptyList());
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        lottoNumbers.add(List.of(11, 12, 13, 14, 15, 16));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 7, 8);
        int winningBonusNumber = 8;
        int[] result = new Service(lottoAmount, lottoNumbers, winningLottoNumbers, winningBonusNumber).getLottoResult();

        assertThat(result).isEqualTo(new int[]{0, 0, 0, 1, 0});
    }

    @DisplayName("5등 당첨 테스트")
    @Test
    void rank5Test() {
        int lottoAmount = 2;
        List<List<Integer>> lottoNumbers = new ArrayList<>(Collections.emptyList());
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        lottoNumbers.add(List.of(11, 12, 13, 14, 15, 16));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 7, 8, 9);
        int winningBonusNumber = 8;
        int[] result = new Service(lottoAmount, lottoNumbers, winningLottoNumbers, winningBonusNumber).getLottoResult();

        assertThat(result).isEqualTo(new int[]{0, 0, 0, 0, 1});
    }

    @DisplayName("당첨 안되었을 때 테스트")
    @Test
    void noRankTest() {
        int lottoAmount = 2;
        List<List<Integer>> lottoNumbers = new ArrayList<>(Collections.emptyList());
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        lottoNumbers.add(List.of(11, 12, 13, 14, 15, 16));
        List<Integer> winningLottoNumbers = List.of(31, 32, 33, 37, 38, 39);
        int winningBonusNumber = 8;
        int[] result = new Service(lottoAmount, lottoNumbers, winningLottoNumbers, winningBonusNumber).getLottoResult();

        assertThat(result).isEqualTo(new int[]{0, 0, 0, 0, 0});
    }

    @DisplayName("1~5등 모두 당첨되었을 때 테스트")
    @Test
    void multiRankTest() {
        int lottoAmount = 5;
        List<List<Integer>> lottoNumbers = new ArrayList<>(Collections.emptyList());
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 6));
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 7));
        lottoNumbers.add(List.of(1, 2, 3, 4, 5, 8));
        lottoNumbers.add(List.of(1, 2, 3, 4, 7, 8));
        lottoNumbers.add(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int winningBonusNumber = 7;
        int[] result = new Service(lottoAmount, lottoNumbers, winningLottoNumbers, winningBonusNumber).getLottoResult();

        assertThat(result).isEqualTo(new int[]{1, 1, 1, 1, 1});
    }

}
