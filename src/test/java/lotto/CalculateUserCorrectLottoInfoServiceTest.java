package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domian.Lotto;
import lotto.domian.User;
import lotto.domian.UserSingleLottoNumber;
import lotto.service.CalculateUserCorrectLottoInfoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateUserCorrectLottoInfoServiceTest {

    private final CalculateUserCorrectLottoInfoService calculateUserCorrectLottoInfoService = new CalculateUserCorrectLottoInfoService();

    @DisplayName("countWinningInfo, LottoCompareToWinningNumbers 메서드 테스트")
    @Test
    void lottoCompareToWinningNumbersTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lotto.setBonusNumber(10);
        User user = new User(1000);
        List<UserSingleLottoNumber> singleLottoNumber = List.of(new UserSingleLottoNumber(List.of(1, 2, 3, 7, 8, 9)));
        user.setUserLottoNumbers(singleLottoNumber);

        int money = 5000;

        // when
        calculateUserCorrectLottoInfoService.countWinningInfo(lotto, user);

        // then

        assertThat(user.getUserWinningPrice()).isEqualTo(money);
    }

    @DisplayName("compareWinningNumbers 메서드 테스트")
    @Test
    void compareWinningNumbersTest() {

        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 8);
        int answer = 5;

        // when
        int count = calculateUserCorrectLottoInfoService.compareWinningNumbers(lotto, lottoNumbers);

        //then
        assertThat(count).isEqualTo(answer);
    }

    @DisplayName("compareBonusNumber 메서드 테스트")
    @Test
    void compareBonusNumberTest() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bounsNumber = 1;
        int answer = 5;

        // when
        int count = calculateUserCorrectLottoInfoService.compareBonusNumber(bounsNumber, lottoNumbers, answer);

        // then
        assertThat(count).isEqualTo(answer + 2);
    }

    @DisplayName("calculateYieldOfUser 메서드 테스트")
    @Test
    void calculateYieldOfUserTest() {
        // given
        User user = new User(13000);
        int winningPrice = 26000;
        user.addUserWinningPrice(winningPrice);
        String answer = "200.0";

        // when
        String result = calculateUserCorrectLottoInfoService.calculateYieldOfUser(user);

        // then
        assertThat(result).isEqualTo(answer);
    }
}
