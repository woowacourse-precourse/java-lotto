package lotto;

import lotto.domain.*;
import lotto.util.LottoRank;
import lotto.view.LottoGameView;
import lotto.view.ViewValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
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

    @DisplayName("숫자가 아닌 다른 글자가 들어가면 예외가 발생한다")
    @Test
    void createMoneyByNotNumber() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatThrownBy(() -> viewValidator.validateNumberType("a1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 들어가면 예외가 발생하지 않는다")
    @Test
    void createMoneyByNumber() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatNoException()
                .isThrownBy(() -> viewValidator.validateNumberType("1000"));
    }

    @DisplayName("숫자 예외가 발생 시 메시지에 접두어로 [ERROR]가 들어간다")
    @Test
    void errorMessageByNotNumber() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatThrownBy(() -> viewValidator.validateNumberType("a1000"))
                .hasMessageStartingWith("[ERROR]");
    }

    @DisplayName("1000원 단위가 아닌 돈이 입력됐을 때 예외가 발생한다")
    @Test
    void createMoneyByNotUnitOf1000() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatThrownBy(() -> viewValidator.validateUnitOf1000("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1000원 단위인 돈이 입력됐을 때 예외가 발생하지 않는다")
    @Test
    void createMoneyByUnitOf1000() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatNoException()
                .isThrownBy(() -> viewValidator.validateUnitOf1000("2000"));
    }

    @DisplayName("로또 번호를 생성하면 리스트로 로또 번호가 나온다")
    @Test
    void generateLottoNumberByList() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Customer customer = new Customer();

        Method method = customer.getClass().getDeclaredMethod("generateLottoNumber");
        method.setAccessible(true);
        Object lottoNumber = method.invoke(customer);

        assertThat(lottoNumber).isInstanceOf(List.class);
    }

    @DisplayName("로또 번호를 생성하면 6개의 번호가 나온다")
    @Test
    void generateLottoNumberBySixLength() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Customer customer = new Customer();
        int result = 6;

        Method method = customer.getClass().getDeclaredMethod("generateLottoNumber");
        method.setAccessible(true);
        List<Integer> lottoNumber = (List<Integer>) method.invoke(customer);

        assertThat(lottoNumber.size()).isEqualTo(result);
    }

    @DisplayName("로또 번호를 생성하면 중복없이 6개의 번호가 나온다")
    @Test
    void generateLottoNumberByNotDuplicated() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Customer customer = new Customer();
        int result = 6;

        Method method = customer.getClass().getDeclaredMethod("generateLottoNumber");
        method.setAccessible(true);
        List<Integer> lottoNumber = (List<Integer>) method.invoke(customer);
        int lottoNumberSize = new HashSet<>(lottoNumber).size();

        assertThat(lottoNumberSize).isEqualTo(result);
    }

    @DisplayName("로또 번호를 입력하면 오름차순으로 정렬한다")
    @Test
    void sortLottoNumber() {
        List<Integer> numbers = List.of(34, 24, 40, 41, 10, 7);
        List<Integer> result = List.of(7, 10, 24, 34, 40, 41);
        Lotto lotto = new Lotto(numbers);

        List<Integer> sortedByAscend = lotto.getSortedByAscend();

        assertThat(sortedByAscend).isEqualTo(result);
    }

    @DisplayName("금액을 입력하면 로또 개수를 반환한다")
    @Test
    void getLottoCountByMoney() {
        Customer customer = new Customer();
        int money = 8000;
        int result = 8;

        int lottoCount = customer.getLottoCount(money);

        assertThat(lottoCount).isEqualTo(result);
    }

    @DisplayName("돈을 입력하면 금액만큼 로또를 생성한다")
    @Test
    void generateLottosByMoney() {
        Customer customer = new Customer();
        int money = 6000;
        int result = 6;

        Lottos lottos = customer.purchaseLottos(money);

        assertThat(lottos.getLottoCount()).isEqualTo(result);
    }

    @DisplayName("당첨 번호가 1과 45사이의 값이 아니면 예외가 발생한다")
    @Test
    void createNumberByOutOfRange() {
        List<Integer> winningNumbers = List.of(1, 7, 10, 24, 37, 46);
        int bonusNumber = 12;

        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1과 45사이의 값이면 예외가 발생하지 않는다")
    @Test
    void createNumberByWithinRange() {
        List<Integer> winningNumbers = List.of(1, 7, 10, 24, 37, 45);
        int bonusNumber = 12;

        assertThatNoException()
                .isThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber));
    }

    @DisplayName("값이 숫자가 아니면 예외가 발생한다")
    @Test
    void createNumberByNotIntegerType() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatThrownBy(() -> viewValidator.validateNumberType("a1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 숫자면 예외가 발생하지 않는다")
    @Test
    void createNumberByIntegerType() {
        ViewValidator viewValidator = new ViewValidator();

        assertThatNoException()
                .isThrownBy(() -> viewValidator.validateNumberType("11"));
    }

    @DisplayName("5개의 콤마로 구분된 숫자들이 입력되면 6개의 숫자 리스트가 나온다")
    @Test
    void createSixNumber() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        LottoGameView lottoGameView = new LottoGameView(new ViewValidator());
        String winningNumbers = "1,7,10,24,37,45";
        List<Integer> result = List.of(1, 7, 10, 24, 37, 45);

        Method method = lottoGameView.getClass().getDeclaredMethod("convertWinningNumbers", String.class);
        method.setAccessible(true);
        List<Integer> numbers = (List<Integer>) method.invoke(lottoGameView, winningNumbers);

        assertThat(numbers).isEqualTo(result);
    }

    @DisplayName("1개의 보너스 번호가 6개의 당첨 번호 중에 포함되어있으면 예외가 발생한다")
    @Test
    void createBonusNumberIncludedInWinningNumber() {
        List<Integer> winningNumbers = List.of(1, 7, 10, 24, 37, 45);
        int bonusNumber = 7;

        assertThatThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1개의 보너스 번호가 6개의 당첨 번호 중에 포함되어있지 않으면 예외가 발생하지 않는다")
    @Test
    void createBonusNumberExcluded() {
        List<Integer> winningNumbers = List.of(1, 7, 10, 24, 37, 45);
        int bonusNumber = 11;

        assertThatNoException()
                .isThrownBy(() -> new WinningNumber(winningNumbers, bonusNumber));
    }

    @DisplayName("뽑기 기계에 당첨 번호를 넣으면 당첨 번호가 들어간다")
    @Test
    void generateWinningNumberInDrawingMachine() throws NoSuchFieldException, IllegalAccessException {
        List<Integer> result = List.of(1, 7, 10, 24, 37, 45);
        int bonusNumber = 11;
        WinningNumber drawingMachine = new WinningNumber(result, bonusNumber);

        Field field = drawingMachine.getClass().getDeclaredField("winningNumbers");
        field.setAccessible(true);
        List<Integer> winningNumber = (List<Integer>) field.get(drawingMachine);

        assertThat(winningNumber).isEqualTo(result);
    }

    @DisplayName("뽑기 기계에 보너스 번호를 넣으면 보너스 번호가 들어간다")
    @Test
    void generateBonusNumberInDrawingMachine() throws NoSuchFieldException, IllegalAccessException {
        List<Integer> winningNumber = List.of(1, 7, 10, 24, 37, 45);
        int result = 11;
        WinningNumber drawingMachine = new WinningNumber(winningNumber, result);

        Field field = drawingMachine.getClass().getDeclaredField("bonusNumber");
        field.setAccessible(true);
        int bonusNumber = (int) field.get(drawingMachine);

        assertThat(bonusNumber).isEqualTo(result);
    }

    @DisplayName("당첨 번호에 특정 번호가 포함되어 있으면 true를 반환한다")
    @Test
    void isContainNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 43), 45);

        boolean contain = winningNumber.isContainedWinningNumber(10);

        assertThat(contain).isEqualTo(true);
    }

    @DisplayName("당첨 번호에 특정 번호가 포함되어 있지 않으면 false를 반환한다")
    @Test
    void isNotContainNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 43), 45);

        boolean contain = winningNumber.isContainedWinningNumber(11);

        assertThat(contain).isEqualTo(false);
    }

    @DisplayName("로또 번호가 당첨 번호에 일치하는 개수를 반환한다")
    @Test
    void getThreeHitCount() {
        List<Integer> lottoNumber = List.of(1, 10, 12, 24, 33, 43);
        int bonusNumber = 2;
        WinningNumber winningNumber = new WinningNumber(List.of(3, 10, 12, 20, 33, 45), bonusNumber);
        Lotto lotto = new Lotto(lottoNumber);
        int result = 3;

        long hitCount = lotto.getHitCount(winningNumber);

        assertThat(hitCount).isEqualTo(result);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있으면 true를 반환한다")
    @Test
    void isHitBonusNumber() {
        List<Integer> lottoNumber = List.of(1, 10, 12, 24, 33, 43);
        WinningNumber winningNumber = new WinningNumber(List.of(3, 10, 12, 20, 33, 45), 43);
        Lotto lotto = new Lotto(lottoNumber);

        boolean hitBonusNumber = lotto.isHitBonusNumber(winningNumber);

        assertThat(hitBonusNumber).isEqualTo(true);
    }

    @DisplayName("로또 번호에 보너스 번호가 포함되어 있지 않으면 false를 반환한다")
    @Test
    void isNotHitBonusNumber() {
        WinningNumber winningNumber = new WinningNumber(List.of(3, 10, 12, 20, 33, 45), 41);
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 33, 43));

        boolean hitBonusNumber = lotto.isHitBonusNumber(winningNumber);

        assertThat(hitBonusNumber).isEqualTo(false);
    }

    @DisplayName("5개 번호와 1개의 보너스 번호가 일치하면 2등을 반환한다")
    @Test
    void isSecondPlace() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 45), 43);
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 33, 43));
        LottoRank result = LottoRank.SECOND_PLACE;

        LottoRank rank = lotto.getRank(winningNumber);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("5개 번호가 일치하면 3등을 반환한다")
    @Test
    void isThirdPlace() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 45), 42);
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 33, 43));
        LottoRank result = LottoRank.THIRD_PLACE;

        LottoRank rank = lotto.getRank(winningNumber);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("4개 번호가 일치하면 4등을 반환한다")
    @Test
    void isFourthPlace() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 45), 43);
        Lotto lotto = new Lotto(List.of(1, 10, 12, 24, 32, 43));
        LottoRank result = LottoRank.FOURTH_PLACE;

        LottoRank rank = lotto.getRank(winningNumber);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("2개 번호가 일치하면 낫싱을 반환한다")
    @Test
    void isNothing() {
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 45), 43);
        Lotto lotto = new Lotto(List.of(1, 10, 13, 25, 32, 43));
        LottoRank result = LottoRank.NOTHING;

        LottoRank rank = lotto.getRank(winningNumber);

        assertThat(rank).isEqualTo(result);
    }

    @DisplayName("2개의 로또가 들어가면 2개의 당첨 결과가 나온다")
    @Test
    void getRankByLottos() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 10, 13, 25, 32, 43)), new Lotto(List.of(2, 11, 13, 25, 33, 45))));
        WinningNumber winningNumber = new WinningNumber(List.of(1, 10, 12, 24, 33, 45), 43);

        List<LottoRank> ranks = lottos.getRanks(winningNumber);

        assertThat(ranks.size()).isEqualTo(2);
    }

    @DisplayName("랭크 결과 리스트를 입력하면 총 당첨금을 반환한다")
    @Test
    void getTotalPrizeMoneyByRanks() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        List<LottoRank> ranks = List.of(LottoRank.SECOND_PLACE, LottoRank.SECOND_PLACE, LottoRank.THIRD_PLACE);
        int result = 61_500_000;

        int totalPrizeMoney = lottos.getTotalPrizeMoney(ranks);

        assertThat(totalPrizeMoney).isEqualTo(result);
    }

    @DisplayName("산 로또들과 랭크를 입력하면 수익률이 반환된다")
    @Test
    void getRateOfReturnByMoneyAndPrizeMoney() {
        Lottos lottos = new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        List<LottoRank> ranks = List.of(LottoRank.SECOND_PLACE, LottoRank.SECOND_PLACE, LottoRank.THIRD_PLACE);
        double result = 6_150_000.0;

        double rateOfReturn = lottos.getRateOfReturn(lottos.getTotalPrizeMoney(ranks));

        assertThat(rateOfReturn).isEqualTo(result);
    }
}
