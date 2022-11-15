package lotto;

import lotto.util.InputHandler;
import lotto.util.LOTTERY_REWARD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


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

    @DisplayName("구매한 개수만큼 로또 생성.")
    @Test
    void createRandomLottos() {
        int generationNumber = 4;
        List<Lotto> testLotto = new LottoGenerator().generateLotto(generationNumber);
        assertThat(testLotto.size()).isEqualTo(generationNumber);
    }

    @DisplayName("입력한 값의 타입이 다르면 에러가 발생한다.")
    @Test
    void validateInputType() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        InputHandler inputHandler = new InputHandler();
        Method validateMethod = inputHandler.getClass().getDeclaredMethod("validateListType", String.class);
        validateMethod.setAccessible(true);
        assertThat(validateMethod.invoke(inputHandler, "1,2,3")).isEqualTo(List.of(1, 2, 3));
    }

    @DisplayName("보너스 숫자 중복되면 에러 발생")
    @Test
    void validateBonusNumber() throws NoSuchMethodException {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> InputHandler.validateBonusNumber(lotto, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 범위 넘어가면 에러 발생")
    @Test
    void validateRange() throws NoSuchMethodException {
        InputHandler inputHandler = new InputHandler();
        Method validateRange = inputHandler.getClass().getDeclaredMethod("validateRange", int.class);
        validateRange.setAccessible(true);
        assertThatThrownBy(() -> validateRange.invoke(inputHandler, 46))
                .isInstanceOf(InvocationTargetException.class);
    }

    @DisplayName("랜덤한 로또 생성")
    @Test
    void generateRandomLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        int generate = 5;
        List<Lotto> generatedLotto = lottoGenerator.generateLotto(generate);
        assertThat(generatedLotto.size()).isEqualTo(generate);
    }

    @DisplayName("로또 번호 비교 일치값 반환")
    @Test
    void getMatchingCount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoMachine lottoMachine = new LottoMachine();
        Lotto inputLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        Method getMatches = lottoMachine.getClass().getDeclaredMethod("getMatches", Lotto.class, Lotto.class);
        getMatches.setAccessible(true);
        assertThat(getMatches.invoke(lottoMachine, inputLotto, winningLotto)).isEqualTo(3);
    }


    @DisplayName("보너스 확인 테스트")
    @Test
    void getBonusMatching() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        LottoMachine lottoMachine = new LottoMachine();
        Lotto inputLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Method getBonusRank = lottoMachine.getClass().getDeclaredMethod("getBonusRank", Lotto.class);
        Field bonusNumber = lottoMachine.getClass().getDeclaredField("bonusNumber");
        getBonusRank.setAccessible(true);
        bonusNumber.setAccessible(true);
        bonusNumber.set(lottoMachine, 1);
        assertThat(getBonusRank.invoke(lottoMachine, inputLotto)).isEqualTo(LOTTERY_REWARD.BONUS_PLACE.getIndex());
    }


    // 아래에 추가 테스트 작성 가능
}
