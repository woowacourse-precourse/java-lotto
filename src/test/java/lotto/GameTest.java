package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Game game = new Game();

    @Test
    public void match6LottoTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;

        //when
        Lotto randomLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Win win = game.matchLotto(randomLotto, lotto, bonus);

        //then
        assertThat(win).isEqualTo(Win.MATCH6);
    }

    @Test
    public void match5LottoTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;

        //when
        Lotto randomLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Win win = game.matchLotto(randomLotto, lotto, bonus);

        //then
        assertThat(win).isEqualTo(Win.MATCH5);
    }

    @Test
    public void match5BonusLottoTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;

        //when
        Lotto randomLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Win win = game.matchLotto(randomLotto, lotto, bonus);

        //then
        assertThat(win).isEqualTo(Win.MATCH5BONUS);
    }

    @Test
    public void match4LottoTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;

        //when
        Lotto randomLotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Win win = game.matchLotto(randomLotto, lotto, bonus);

        //then
        assertThat(win).isEqualTo(Win.MATCH4);
    }

    @Test
    public void match3LottoTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;

        //when
        Lotto randomLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        Win win = game.matchLotto(randomLotto, lotto, bonus);

        //then
        assertThat(win).isEqualTo(Win.MATCH3);
    }

    @Test
    public void matchLottosTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonus = 7;

        //when
        Lotto randomLotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto randomLotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto randomLotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto randomLotto4 = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        Lotto randomLotto5 = new Lotto(List.of(1, 2, 3, 8, 9, 10));

        List<Lotto> randomLottos = new ArrayList<>(List.of(randomLotto1, randomLotto2, randomLotto3, randomLotto4, randomLotto5));
        game.matchLottos(randomLottos, lotto, bonus);

        //then
        assertThat(game.getReward()).isEqualTo(2031555000);
    }
}