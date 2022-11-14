package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("입력받은 금액 만큼 로또번호를 생성.")
    @Test
    void CreateLottoNumInputMoney(){
        User user = new User();
        List<List<Integer>> AutoLotto = new ArrayList<>();
        AutoLotto = user.Count(8000);
        assert(AutoLotto.size() == 8);
    }

    @DisplayName("입력받은 금액이 1000단위가아니면 오류")
    @Test
    void CheckMoney(){
        User user = new User();
        assertThatThrownBy(() ->  user.Count(8500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 로또번호와 자동으로생성한 로또번호를 대조해서 일치하는횟수를 list에 순서대로 저장후 리턴")
    @Test
    void CheckMatchCount(){
        List<List<Integer>> AutoLotto = List.of(
                List.of(25,40,1,6,41,8,11),
                List.of(20, 35, 3, 10, 33, 21, 42)
        );
        List<Integer> UserLotto = List.of(25,40,1,42,8,7,9);
        List<Integer> result = new ArrayList<>();
        User user = new User();
        result = user.CheckResult(AutoLotto,UserLotto);
        assertThat(result.contains(3));
    }

    @DisplayName("result 반환리스트안에 3이라는 숫자가 있는 갯수만큼의 수를 리턴")
    @Test
    void CheckResultThree(){
        List<Integer> result = List.of(3,1,2,3);
        CheckCount count = new CheckCount();
        int Three = count.CheckThree(result);
        assert(Three == 2);
    }

    @DisplayName("result 반환리스트안에 4라는 숫자가 있는 갯수만큼의 수를 리턴")
    @Test
    void CheckResultFour(){
        List<Integer> result = List.of(4,1,2,4);
        CheckCount count = new CheckCount();
        int Four = count.CheckFour(result);
        assert(Four == 2);
    }

}
