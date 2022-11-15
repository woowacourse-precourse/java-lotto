package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest extends NsTest {
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

    @DisplayName("로또 번호가 정해진 형식으로 출력되는지 확인한다.(생성될때 이미 오름차순 정렬을 해주어서, 정렬은 보장된 상태)")
    @Test
    void printLottoByAscendingOrder(){
        Lotto lotto = new Lotto(List.of(2,9,16,22,25,41));
        lotto.Print();
        assertThat(output()).contains("[2, 9, 16, 22, 25, 41]");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
    // 아래에 추가 테스트 작성 가능
}
