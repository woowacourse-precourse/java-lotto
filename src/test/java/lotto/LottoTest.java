package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @Test
    void 당첨번호_생성_테스트() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getLottoNumbers()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void 보너스넘버_생성_테스트() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<Integer> numbers = lottoNumberGenerator.generateLottoNumbers();
        int bonusNumber = lottoNumberGenerator.generateBonusNumber(numbers);
        assertThat(numbers.contains(bonusNumber)).isEqualTo(false);
    }

    @Test
    void 투입_금액_만큼_로또가_구매되는지_테스트() {
        Player player = new Player(6000);
        assertThat(player.getLottery().size()).isEqualTo(6);
    }

    @Test
    void 당첨넘버_생성_테스트() {
        String winningNumbersInput = "1,2,3,4,5,6";
        String winningBonusNumber = "7";
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput, winningBonusNumber);
        assertThat(winningNumbers.getWinningNumbers().contains(3));
    }

    @Test
    void 당첨보너스넘버_생성_테스트() {
        String winningNumbersInput = "1,2,3,4,5,6";
        String winningBonusNumber = "7";
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersInput, winningBonusNumber);
        assertThat(winningNumbers.getWinningBonusNumber()).isEqualTo(7);
    }

    @Test
    void 당첨금액_잘_매핑되는지_테스트() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        lotto.generateBonusNumber("9");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,7", "9");
        RewardsMapper rewardsMapper = new RewardsMapper(winningNumbers);
        Rewards rewards = rewardsMapper.getReward(lotto);
        assertThat(rewards.getReward()).isEqualTo(30000000);
    }

    @Test
    void 당첨금액_잘_매핑되는지_테스트2() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        lotto.generateBonusNumber("9");
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", "9");
        RewardsMapper rewardsMapper = new RewardsMapper(winningNumbers);
        Rewards rewards = rewardsMapper.getReward(lotto);
        assertThat(rewards.getReward()).isEqualTo(2000000000);
    }
}
