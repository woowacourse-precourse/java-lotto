package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.LottoCalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCalculateServiceTest {
    private LottoCalculateService lottoCalculateService = new LottoCalculateService();

    @DisplayName("수익률 계산 테스트")
    @Test
    public void getYieldOfLottoTest() {
        // given
        User user = new User(8000);
        int totalPrice = 5000;

        // when
        String result = lottoCalculateService.getYieldOfLotto(user, totalPrice);

        // then
        assertThat(result).isEqualTo("62.5");
    }

    @DisplayName("로또 번호 몇 개 맞았는지 테스트")
    @Test
    public void countUserNumbersContainLottoTest() {
        // given
        List<Integer> userNumbers = List.of(1, 2, 3, 7, 8, 9);
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        int count = lottoCalculateService.countUserNumbersContainLotto(userNumbers, lottoNumbers);

        // then
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("로또 번호 매칭 개수 3,4,6개 테스트")
    @Test
    public void isNumberMatchedNormalTest() {
        // given
        int countContainsOfLotto1 = 3;
        int countContainsOfLotto2 = 4;
        int countContainsOfLotto3 = 6;
        int countContainsOfLotto4 = 0;

        // when
        boolean result1 = lottoCalculateService.isNumberMatchedNormal(countContainsOfLotto1);
        boolean result2 = lottoCalculateService.isNumberMatchedNormal(countContainsOfLotto2);
        boolean result3 = lottoCalculateService.isNumberMatchedNormal(countContainsOfLotto3);
        boolean result4 = lottoCalculateService.isNumberMatchedNormal(countContainsOfLotto4);

        // then
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
        assertThat(result3).isEqualTo(true);
        assertThat(result4).isEqualTo(false);
    }

    @DisplayName("로또 번호 매칭 개수 5개 + 보너스번호 테스트")
    @Test
    public void isNumberMatchedFiveWithBonusTest() {
        // given
        int countContainsOfLotto = 5;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(8);
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.setBonusNumber(6);

        // when
        boolean result = lottoCalculateService.isNumberMatchedFiveWithBonus(countContainsOfLotto, numbers, lotto);

        // then
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("로또 번호 매칭 개수 5개 테스트")
    @Test
    public void isNumberMatchedFiveTest() {
        // given
        int countContainsOfLotto = 5;
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(1);
        lottoNumbers.add(2);
        lottoNumbers.add(3);
        lottoNumbers.add(4);
        lottoNumbers.add(5);
        lottoNumbers.add(8);
        Lotto lotto = new Lotto(lottoNumbers);
        lotto.setBonusNumber(10);

        // when
        boolean result = lottoCalculateService.isNumberMatchedFive(countContainsOfLotto, numbers, lotto);

        // then
        assertThat(result).isEqualTo(true);
    }
}
