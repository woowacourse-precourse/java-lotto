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
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않을 경우 예외가 발생한다.")
    void 구입_금액이_1000으로_나누어_떨어지지_않을_경우_예외가_발생한다() {
        List<Integer> testNumbers = Arrays.asList(2500, 145, 1, 4556, -1000);
        Validator validator = new Validator();
        for (Integer testNumber : testNumbers) {
            assertThatThrownBy(() -> validator.validatePurchaseAmount(testNumber)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 번호는 1에서 45사이의 숫자만 가져야 한다.")
    void 로또_번호는_1에서_45사이의_숫자만_가져야_한다() {
        List<List<Integer>> testLotto = Arrays.asList(Arrays.asList(1, 2, 3, 4, 46), Arrays.asList(0, 1, 2, 3, 4, 5));
        Validator validator = new Validator();
        for (List<Integer> numbers : testLotto) {
            assertThatThrownBy(() -> validator.validateLotto(numbers)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우 예외가 발생한다.")
    void 로또_번호가_6개가_아닐_경우_예외가_발생한다() {
        List<List<Integer>> testLotto = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Validator validator = new Validator();
        for (List<Integer> numbers : testLotto) {
            assertThatThrownBy(() -> validator.validateLotto(numbers)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또 번호가 중복일 경우 예외가 발생한다.")
    void 로또_번호가_중복일_경우_예외가_발생한다() {
        List<List<Integer>> testLotto = Arrays.asList(Arrays.asList(1, 2, 2, 4, 5, 6), Arrays.asList(1, 1, 1, 1, 1, 1));
        Validator validator = new Validator();
        for (List<Integer> numbers : testLotto) {
            assertThatThrownBy(() -> validator.validateLotto(numbers)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("로또_번호가 당첨 번호와 몇개가 일치하는지 확인한다.")
    void 로또_번호가_당첨_번호와_몇개가_일치하는지_확인한다() {
        Matcher matcher = new Matcher();
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winNumbers = Arrays.asList(7, 2, 3, 4, 5, 6);
        assertThat(matcher.getCountOfCommonElement(lotto, winNumbers)).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호에 보너스 번호가 있는지 확인한다.")
    void 로또_번호에_보너스_번호가_있는지_확인한다() {
        Matcher matcher = new Matcher();
        Lotto lottoWithBonusNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lottoWithoutBonusNumber = new Lotto(Arrays.asList(1, 2, 3, 5, 6, 7));
        int bonusNumber = 4;

        assertThat(matcher.doesContainBonusNumber(lottoWithBonusNumber, bonusNumber)).isEqualTo(true);
        assertThat(matcher.doesContainBonusNumber(lottoWithoutBonusNumber, bonusNumber)).isEqualTo(false);
    }

    @Test
    @DisplayName("로또의 등수를 판별한다.")
    void 로또의_등수를_확인한다() {
        Lotto lottoWithFirstPrize = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lottoWithSecondPrize = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lottoWithThirdPrize = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto lottoWithFourthPrize = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
        Lotto lottoWithFifthPrize = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
        Lotto invalidLotto = new Lotto(Arrays.asList(1, 2, 8, 9, 10, 11));
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer(winNumber, bonusNumber);

        assertThat(resultAnalyzer.determineRank(lottoWithFirstPrize)).isEqualTo(1);
        assertThat(resultAnalyzer.determineRank(lottoWithSecondPrize)).isEqualTo(2);
        assertThat(resultAnalyzer.determineRank(lottoWithThirdPrize)).isEqualTo(3);
        assertThat(resultAnalyzer.determineRank(lottoWithFourthPrize)).isEqualTo(4);
        assertThat(resultAnalyzer.determineRank(lottoWithFifthPrize)).isEqualTo(5);
        assertThat(resultAnalyzer.determineRank(invalidLotto)).isEqualTo(6);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void 수익률을_계산한다() {
        List<Integer> winNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer(winNumber, bonusNumber);
        List<Lotto> wholeLotto = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), new Lotto(Arrays.asList(9, 2, 10, 4, 5, 8)), new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        int[] rankRecord = resultAnalyzer.makeRankRecord(wholeLotto); // {0,0,0,2,0,1,0}
        double expense = 3000;
        double income = 3005000;
        assertThat(resultAnalyzer.calculateRateOfReturn(wholeLotto, rankRecord)).isEqualTo((double) Math.round(income / expense * 100 * 10) / 10);
    }
}
