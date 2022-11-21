package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserMissCheckingTest {

    private final List<Integer> lotto = new ArrayList<>(List.of(1, 3, 6, 12, 35, 44));
    private final String input = "14";

    private final List<Integer> wrongLotto = new ArrayList<>(List.of(1, 3, 3, 6, 12, 35));
    private final List<Integer> wrongLotto2 = new ArrayList<>(List.of(1, 3, 3, 6, 3, 35));
    private final List<Integer> wrongLotto3 = new ArrayList<>(List.of(1, 3, 3, 6, 6, 35));
    private final String wrongInput = "1";
    private final String wrongInput2 = "사십";
    private final String wrongInput3 = "35";

    @Test
    public void 숫자대신_문자입력_에러() {
        assertThatThrownBy(() -> UserMissChecking.numberChecking("사십사"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserMissChecking.numberChecking("test"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserMissChecking.numberChecking(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또금액_첫원단위_미입금() {
        assertThatThrownBy(() -> UserMissChecking.thousandChecking(4200))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserMissChecking.thousandChecking(12305))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserMissChecking.thousandChecking(123130))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 지정된_로또_숫자범위_이외_숫자_삽입() {
        assertThatThrownBy(() -> UserMissChecking.numberLimitChecking(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserMissChecking.numberLimitChecking(47))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_당침번호_입력시_중복체크() {
        assertThatThrownBy(() -> UserMissChecking.numRepeatCheck(wrongLotto))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserMissChecking.numRepeatCheck(wrongLotto2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> UserMissChecking.numRepeatCheck(wrongLotto3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 보너스_숫자_넣기_테스트(){
        assertThatThrownBy(()-> UserMissChecking.bonusNumberChecking(lotto, wrongInput))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> UserMissChecking.bonusNumberChecking(lotto, wrongInput2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> UserMissChecking.bonusNumberChecking(lotto, wrongInput3))
                .isInstanceOf(IllegalArgumentException.class);
    }
}