package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGrade;
import lotto.domain.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    void setUp() {
        lottoStore = new LottoStore();
    }

    @Test
    @DisplayName("8000원을 입력하면 8개의 리스트가 나와야 한다.")
    void createLottos() {
        assertThat(lottoStore.buyLottos(new Money("8000")).size()).isEqualTo(8);
    }

    @Test
    @DisplayName("8080원을 입력하면 예외처리 되어야 한다.")
    void createLottosNotDivide() {
        assertThatThrownBy(() -> lottoStore.buyLottos(new Money("8080")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 당첨 번호를 입력하면 리스트와 일치해야 한다.")
    void inputWinningNumberSuccess() {
        assertThat(lottoStore.confirmWinningNumbers("1,2,3,4,5,6").toString()).isEqualTo(Arrays.asList(1,2,3,4,5,6).toString());
    }

    @Test
    @DisplayName("정수가 아니거나 1~45의 범위에 없으면 예외처리 해야한다.")
    void inputWinningNumberNotInRange() {
        assertThatThrownBy(() -> lottoStore.confirmWinningNumbers("a,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개가 아니면 예외처리 해야한다.")
    void inputWinningNumberCountNotSix() {
        assertThatThrownBy(() -> lottoStore.confirmWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바른 보너스 번호를 입력하면 리스트와 일치해야 한다.")
    void inputBonusNumberSuccess() {
        assertThat(lottoStore.confirmBonusNumber("42")).isEqualTo(42);
    }

    @Test
    @DisplayName("정수가 아닐 시 예외처리 해야한다.")
    void inputBonusNumberNotDigit() {
        assertThatThrownBy(() -> lottoStore.confirmBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 안에 없을 시 예외처리 해야한다.")
    void inputBonusNumberNotInRange() {
        assertThatThrownBy(() -> lottoStore.confirmBonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("List를 Map으로 변환했을 시 ONE의 값이 같아야 한다.")
    void conversionListToMap() {
        List<LottoGrade> lottoGrades = List.of(LottoGrade.ONE, LottoGrade.ONE, LottoGrade.TWO, LottoGrade.THREE, LottoGrade.THREE, LottoGrade.ONE, LottoGrade.FIVE);
        Map<LottoGrade, Integer> lottoGradeResult = lottoStore.conversionLottosResult(lottoGrades);

        Map<LottoGrade, Integer> testCase = Map.of(
                LottoGrade.ONE, 3,
                LottoGrade.TWO, 1,
                LottoGrade.THREE, 2,
                LottoGrade.FOUR, 0,
                LottoGrade.FIVE, 1
        );
        assertThat(lottoGradeResult.get(LottoGrade.ONE)).isEqualTo(testCase.get(LottoGrade.ONE));
    }

    @Test
    @DisplayName("로또의 등수가 일치해야 한다.")
    void lottoNumberCompareToWinningNumberSuccess() {
        assertThat(lottoStore.allLottosCompare(List.of(new Lotto(List.of(1,2,3,4,5,6))), new Lotto(List.of(1,2,3,4,5,8)), 6).get(0))
                .isEqualTo(LottoGrade.TWO);
    }
}
