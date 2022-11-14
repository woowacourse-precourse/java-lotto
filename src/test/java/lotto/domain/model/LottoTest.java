package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("로또 번호에 1보자 작은 수가 있으면 예외가 발생한다.")
    @Test
    void createLottoByOutBoundNumberUnderZero() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위에 벗어나는 숫자가 있으면 예외가 발생한다. : 1보다 큰 수")
    @Test
    void createLottoByOutBoundNumberUpperFortyFive() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 6개 일치")
    @Test
    void compareLottoToLottoNumber_ResultSix() {
        WinningLotto winningLotto = new WinningLotto("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(8, 15, 18, 21, 36, 45));
        assertThat(lotto.compareLottoNumber(winningLotto)).isEqualTo(LottoRank.SIX_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 5개 + 보너스 일치")
    @Test
    void compareLottoToLottoNumber_ResultFiveBonus() {
        WinningLotto winningLotto = new WinningLotto("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(8, 13, 18, 21, 36, 45));
        assertThat(lotto.compareLottoNumber(winningLotto)).isEqualTo(LottoRank.FIVE_BONUS_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 5개 일치")
    @Test
    void compareLottoToLottoNumber_ResultFive() {
        WinningLotto winningLotto = new WinningLotto("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(8, 14, 18, 21, 36, 45));
        assertThat(lotto.compareLottoNumber(winningLotto)).isEqualTo(LottoRank.FIVE_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 4개 일치")
    @Test
    void compareLottoToLottoNumber_ResultFour() {
        WinningLotto winningLotto = new WinningLotto("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(7, 14, 18, 21, 36, 45));
        assertThat(lotto.compareLottoNumber(winningLotto)).isEqualTo(LottoRank.FOUR_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 3개 일치")
    @Test
    void compareLottoToLottoNumber_ResultThree() {
        WinningLotto winningLotto = new WinningLotto("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(7, 14, 18, 22, 36, 45));
        assertThat(lotto.compareLottoNumber(winningLotto)).isEqualTo(LottoRank.THREE_MATCHES);
    }

    @DisplayName("로또 계산 결과를 리턴한다. : 3개 이하 일치")
    @Test
    void compareLottoToLottoNumber_ResultUnderTree() {
        WinningLotto winningLotto = new WinningLotto("8,18,21,45,15,36", "13");
        Lotto lotto = new Lotto(List.of(7, 14, 18, 22, 33, 45));
        assertThat(lotto.compareLottoNumber(winningLotto)).isEqualTo(LottoRank.NO_MATCH);
    }

    @DisplayName("객체 생성 테스트1")
    @Test
    void createFirstPlace() {
        String firstPlace = "1,2,3,4,5,6";
        assertThat(new Lotto(firstPlace)).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @DisplayName("객체 생성 테스트2")
    @Test
    void createFirstPlace2() {
        String firstPlace = "10,21,31,45,15,36";
        assertThat(new Lotto(firstPlace)).isEqualTo(new Lotto("10,21,31,45,15,36"));
    }

    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(6개 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchSix(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(10, 15, 21, 31, 36, 45);
        assertThat(new Lotto(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.SIX_MATCHES);
    }
    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(5개 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchFive(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(9, 15, 21, 31, 36, 45);
        assertThat(new Lotto(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.FIVE_MATCHES);
    }

    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(4개 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchFour(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(9, 15, 23, 31, 36, 45);
        assertThat(new Lotto(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.FOUR_MATCHES);
    }

    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(3개 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchThree(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(9, 15, 23, 31, 32, 45);
        assertThat(new Lotto(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.THREE_MATCHES);
    }

    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(3개 이하 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchUnderThree(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(9, 14, 23, 31, 32, 45);
        assertThat(new Lotto(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.NO_MATCH);
    }


    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다.")
    @Test
    void createFirstPlaceByNotDivideCommas1(){
        String firstPlace = "1,2,3,4,5,6,,,";
        assertThatThrownBy(() -> new Lotto(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 쉼표랑 다른 구분자 있을 때")
    @Test
    void createFirstPlaceByNotDivideCommas2() {
        String firstPlace = "1,2,3,4/5/6";
        assertThatThrownBy(() -> new Lotto(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 쉼표가 없을 때")
    @Test
    void createFirstPlaceByNotExistCommas() {
        String firstPlace = "1/2/3/4/5/6";
        assertThatThrownBy(() -> new Lotto(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유요 숫자 범위 내 숫자를 입력하지 않으면 예외가 발생한다. 0 포함")
    @Test
    void createFirstPlaceByOutBoundNumber1() {
        String firstPlace = "0,1,2,3,4,5";
        assertThatThrownBy(() -> new Lotto(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유요 숫자 범위 내 숫자를 입력하지 않으면 예외가 발생한다. 46이상 포함")
    @Test
    void createFirstPlaceByOutBoundNumber2() {
        String firstPlace = "3,1,46,7,4,5";
        assertThatThrownBy(() -> new Lotto(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자를 입력하면 예외가 발생한다.")
    @Test
    void createFirstPlaceByDuplicateNumber() {
        String firstPlace = "1,2,3,4,4,5";
        assertThatThrownBy(() -> new Lotto(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호 보너스번호 중복 확인")
    @Test
    void createFirstPlaceAndBonusNumberDuplicate(){
        String firstPlace = "1,2,3,4,5,6";
        String bonus = "3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(firstPlace).duplicateCheckBonusNumber(bonus));
        assertThat(exception.getMessage())
                .isEqualTo("[ERROR] 당첨번호에 속한 보너스 번호를 입력하였습니다 | 당첨 번호: [1, 2, 3, 4, 5, 6]");
    }

}
