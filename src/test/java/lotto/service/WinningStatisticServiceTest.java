package lotto.service;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FORTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.repository.RankCountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticServiceTest {

    private final RankCountRepository rankCountRepository = new RankCountRepository();

    private final WinningStatisticService winningStatisticService =
        new WinningStatisticService(rankCountRepository);

    @Test
    @DisplayName("보너스 번호가 포함되면 true 반환한다.")
    void hasBonusNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        // when
        boolean result = winningStatisticService.hasBonusNumber(lotto, bonusNumber);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("보너스 번호가 포함되지 않으면 false 반환한다.")
    void hasNotBonusNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        boolean result = winningStatisticService.hasBonusNumber(lotto, bonusNumber);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("두 로또 번호를 비교하여 일치하는 번호의 개수를 반환한다.")
    void getMatchedNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningLottoNumbers = List.of(7, 8, 1, 2, 3, 4);

        // when
        int matchedNumber = winningStatisticService.getMatchedNumber(lotto, winningLottoNumbers);

        // then
        assertThat(matchedNumber).isEqualTo(4);
    }

    @Test
    @DisplayName("두 로또 번호를 비교하여 일치하는 번호가 없으면 0을 반환한다.")
    void getHasNotMatchedNumber() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningLottoNumbers = List.of(7, 8, 9, 10, 11, 12);

        // when
        int matchedNumber = winningStatisticService.getMatchedNumber(lotto, winningLottoNumbers);

        // then
        assertThat(matchedNumber).isEqualTo(0);
    }

    @Test
    @DisplayName("6개의 숫자가 같으면 1등을 반환한다.")
    void getFirstRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningLottoNumbers = lotto.getNumbers();
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 7);

        // when
        Optional<Rank> rank = winningStatisticService.getRank(lotto, winningLotto);

        // then
        assertThat(rank.isPresent()).isTrue();
        assertThat(rank.get()).isEqualTo(FIRST);
    }

    @Test
    @DisplayName("5개의 숫자가 같고 보너스번호가 일치하면 2등을 반환한다.")
    void getSecondRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 7);

        // when
        Optional<Rank> rank = winningStatisticService.getRank(lotto, winningLotto);

        // then
        assertThat(rank.isPresent()).isTrue();
        assertThat(rank.get()).isEqualTo(SECOND);
    }

    @Test
    @DisplayName("5개의 숫자가 같고 보너스번호가 일치하지 않으면 3등을 반환한다.")
    void getThirdRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 8);

        // when
        Optional<Rank> rank = winningStatisticService.getRank(lotto, winningLotto);

        // then
        assertThat(rank.isPresent()).isTrue();
        assertThat(rank.get()).isEqualTo(THIRD);
    }

    @Test
    @DisplayName("4개의 숫자가 일치하면 4등을 반환한다.")
    void getForthRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 8);

        // when
        Optional<Rank> rank = winningStatisticService.getRank(lotto, winningLotto);

        // then
        assertThat(rank.isPresent()).isTrue();
        assertThat(rank.get()).isEqualTo(FORTH);
    }

    @Test
    @DisplayName("3개의 숫자가 일치하면 5등을 반환한다.")
    void getFifthRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 8);

        // when
        Optional<Rank> rank = winningStatisticService.getRank(lotto, winningLotto);

        // then
        assertThat(rank.isPresent()).isTrue();
        assertThat(rank.get()).isEqualTo(FIFTH);
    }

    @Test
    @DisplayName("당첨되지 않으면 빈 Optional 객체를 반환한다.")
    void getEmptyRank() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));
        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, 8);

        // when
        Optional<Rank> rank = winningStatisticService.getRank(lotto, winningLotto);

        // then
        assertThat(rank).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("모든 당첨 로또의 개수를 저장한다.")
    void saveRankCount() {
        // givens
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(firstLotto.getNumbers(), 7);
        List<Lotto> lottos = new ArrayList<>(List.of(firstLotto, secondLotto));

        // when
        winningStatisticService.saveRankCount(lottos, winningLotto);

        // then
        assertThat(rankCountRepository.findOne(FIRST)).isEqualTo(1);
        assertThat(rankCountRepository.findOne(SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("저장된 당첨 로또의 개수를 반환한다.")
    void getRankCount() {
        // given
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto secondLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(firstLotto.getNumbers(), 7);
        List<Lotto> lottos = new ArrayList<>(List.of(firstLotto, secondLotto, secondLotto2));
        winningStatisticService.saveRankCount(lottos, winningLotto);

        // when
        int firstRankCount = winningStatisticService.getRankCount(FIRST);
        int secondRankCount = winningStatisticService.getRankCount(SECOND);

        // then
        assertThat(firstRankCount).isEqualTo(1);
        assertThat(secondRankCount).isEqualTo(2);
    }

    @Test
    @DisplayName("저장된 모든 로또의 결과를 반환한다.")
    void getRankCountMap() {
        // given
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto secondLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto notWinningLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        WinningLotto winningLotto = new WinningLotto(firstLotto.getNumbers(), 7);
        List<Lotto> lottos = new ArrayList<>(
            List.of(firstLotto, secondLotto, secondLotto2, notWinningLotto));
        List<Integer> expectedResult = List.of(0, 0, 0, 2, 1);
        winningStatisticService.saveRankCount(lottos, winningLotto);

        // when
        Map<Rank, Integer> rankCountMap = winningStatisticService.getRankCountMap();

        // then
        assertThat(new ArrayList<>(rankCountMap.keySet())).isEqualTo(List.of(Rank.values()));
        assertThat(new ArrayList<>(rankCountMap.values())).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("총 획득한 상금을 반환한다.")
    void getTotalAmount() {
        // given
        Map<Rank, Integer> rankCountMap = new LinkedHashMap<>() {{
            List.of(Rank.values()).forEach(rank -> put(rank, 1));
        }};
        int expected = Arrays.stream(Rank.values())
            .mapToInt(Rank::getWinningAmount)
            .sum();

        // when
        long result = winningStatisticService.getTotalAmount(rankCountMap);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률을 반환한다.")
    void getYield() {
        // given
        int totalAmount = 5200000;
        int purchasePrice = 20000;
        double expected = ((double) totalAmount / purchasePrice) * 100;

        // when
        double result = winningStatisticService.getYield(totalAmount, purchasePrice);

        // then
        assertThat(result).isEqualTo(expected);
    }
}