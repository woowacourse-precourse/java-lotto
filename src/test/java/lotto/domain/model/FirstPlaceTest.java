package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstPlaceTest {

    @DisplayName("객체 생성 테스트1")
    @Test
    void createFirstPlace() {
        String firstPlace = "1,2,3,4,5,6";
        assertThat(new FirstPlace(firstPlace)).isEqualTo(new FirstPlace("1,2,3,4,5,6"));
    }

    @DisplayName("객체 생성 테스트2")
    @Test
    void createFirstPlace2() {
        String firstPlace = "10,21,31,45,15,36";
        assertThat(new FirstPlace(firstPlace)).isEqualTo(new FirstPlace("10,21,31,45,15,36"));
    }

    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(6개 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchSix(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(10, 15, 21, 31, 36, 45);
        assertThat(new FirstPlace(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.SIX_MATCHES);
    }
    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(5개 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchFive(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(9, 15, 21, 31, 36, 45);
        assertThat(new FirstPlace(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.FIVE_MATCHES);
    }

    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(4개 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchFour(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(9, 15, 23, 31, 36, 45);
        assertThat(new FirstPlace(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.FOUR_MATCHES);
    }

    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(3개 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchThree(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(9, 15, 23, 31, 32, 45);
        assertThat(new FirstPlace(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.THREE_MATCHES);
    }

    @DisplayName("구매한 로또번호와 1등번호가 일치한 만큼의 LottoRank Enum 값이 리턴이 된다.(3개 이하 일치)")
    @Test
    void calculateFirstPlaceByUserLottoMatchUnderThree(){
        String firstPlace = "10,21,31,45,15,36";
        List<Integer> userLotto = List.of(9, 14, 23, 31, 32, 45);
        assertThat(new FirstPlace(firstPlace).calculateMatch(userLotto)).isEqualTo(LottoRank.NO_MATCH);
    }


    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다.")
    @Test
    void createFirstPlaceByNotDivideCommas1(){
        String firstPlace = "1,2,3,4,5,6,,,";
        assertThatThrownBy(() -> new FirstPlace(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 쉼표랑 다른 구분자 있을 때")
    @Test
    void createFirstPlaceByNotDivideCommas2() {
        String firstPlace = "1,2,3,4/5/6";
        assertThatThrownBy(() -> new FirstPlace(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("쉼표로 숫자를 구분하지 않으면 예외가 발생한다. : 쉼표가 없을 때")
    @Test
    void createFirstPlaceByNotExistCommas() {
        String firstPlace = "1/2/3/4/5/6";
        assertThatThrownBy(() -> new FirstPlace(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유요 숫자 범위 내 숫자를 입력하지 않으면 예외가 발생한다. 0 포함")
    @Test
    void createFirstPlaceByOutBoundNumber1() {
        String firstPlace = "0,1,2,3,4,5";
        assertThatThrownBy(() -> new FirstPlace(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유요 숫자 범위 내 숫자를 입력하지 않으면 예외가 발생한다. 46이상 포함")
    @Test
    void createFirstPlaceByOutBoundNumber2() {
        String firstPlace = "3,1,46,7,4,5";
        assertThatThrownBy(() -> new FirstPlace(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자를 입력하면 예외가 발생한다.")
    @Test
    void createFirstPlaceByDuplicateNumber() {
        String firstPlace = "1,2,3,4,4,5";
        assertThatThrownBy(() -> new FirstPlace(firstPlace))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또번호 보너스번호 중복 확인")
    @Test
    void createFirstPlaceAndBonusNumberDuplicate(){
        String firstPlace = "1,2,3,4,5,6";
        String bonus = "3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new FirstPlace(firstPlace).duplicateCheckBonusNumber(bonus));
        assertThat(exception.getMessage())
                .isEqualTo("[ERROR] Lotte Has A Duplicate Value With The Bonus Number.");

    }
}