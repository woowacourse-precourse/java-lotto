package lotto.playlotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.playlotto.object.Lotto;
import lotto.playlotto.object.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayLottoTest {

    @Test
    void play() {
    }

    @Test
    void buy_lottery() {
    }

    @Test
    void print_lottery_nums() {
    }

    @Test
    void create_lotto() {
    }

    @Test
    void create_bonus() {
    }

    @Test
    void compare_lottery() {
    }

    @Test
    void equal_count() {

    }

    @Test
    void check_num() {

        PlayLotto playLotto = create_PlayLotto();
        playLotto.setLotto(create_Lotto());


        Integer num = 5;
        Boolean condition = playLotto.check_num(playLotto.getLotto().returnNumbers(), 5);
        assertThat(condition).isTrue();
    }

    @Test
    void check_bonus() {
        PlayLotto lotto = new PlayLotto();
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Integer bonus = 5;
        Boolean condition = lotto.check_bonus(list, 5);
        assertThat(condition).isTrue();

    }

    @Test
    void check_result() {
    }

    @Test
    void print_result() {

    }

    @Test
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