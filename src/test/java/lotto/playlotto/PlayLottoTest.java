package lotto.playlotto;

import lotto.playlotto.object.Lotto;
import lotto.playlotto.object.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayLottoTest {

    private Lotto lotto;
    private User user;
    private PlayLotto game;

    @BeforeEach
    public void beforeEach() {
        lotto = new Lotto(List.of(1,2,3,4,5,6));
        user = new User();
        game = new PlayLotto();
        List<List<Integer>> lotterys = new ArrayList<>(List.of(List.of(1,2,3,4,5,6), List.of(7,8,9,10,11,12)));
        game.setLotto(lotto);
        user.setLottery_count(2);
        user.setMoney(2000);
        user.setLottery_nums(lotterys);
        game.setUser(user);
    }



    @DisplayName("로또 리스트 중에 로또 숫자들을 6자리 한번 맞췄을 때")
    @Test
    void compare_lottery() {
        game.compare_lottery(user);
        int win = game.getWin_count().get(4); //6자리 모두 맞은 횟수를 가져옴
        assertThat(win).isEqualTo(1);
    }

    @DisplayName("우승번호와 사용자 번호가 일치할 때")
    @Test
    void equal_count() {
        List<Integer> winNumbers = List.of(1,2,3,4,5,6);
        List<Integer> userNumbers = List.of(1,2,3,4,5,6);
        game.equal_count(winNumbers, userNumbers);
        int win = game.getWin_count().get(4); // 6자리 모두 맞은 횟수를 가져옴
        assertThat(win).isEqualTo(1);
    }

    @DisplayName("로또 번호들과 일치하는 값이 존재할 때 True 반환")
    @Test
    void check_num() {

        PlayLotto playLotto = create_PlayLotto();
        playLotto.setLotto(create_Lotto());


        Integer num = 5;
        Boolean condition = playLotto.check_num(playLotto.getLotto().returnNumbers(), 5);
        assertThat(condition).isTrue();
    }

    @DisplayName("보너스 번호와 일치하는 번호가 존재할 때 True 반환")
    @Test
    void check_bonus() {
        PlayLotto lotto = new PlayLotto();
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Integer bonus = 5;
        Boolean condition = lotto.check_bonus(list, 5);
        assertThat(condition).isTrue();

    }

    @DisplayName("일치하는 번호갯수와 보너스 일치 갯수를 전달하면 필드에 결과를 반영한다.")
    @Test
    void check_result() {
        int correct_num_count = 6;
        int correct_bonus = 0;


    }
    void print_yeild() {
    }

    @Test
    void cal_revenue() {
    }

    private Lotto create_Lotto(){
        return new Lotto(List.of(1,2,3,4,5,6));
    }
    private User create_User(){
        return new User();
    }
    private PlayLotto create_PlayLotto(){
        return new PlayLotto();
    }

}
