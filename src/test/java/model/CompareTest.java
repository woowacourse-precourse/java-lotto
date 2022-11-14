package model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompareTest {

    @Test
    @DisplayName("[Compare] 3개 일치")
    void coincideThree() {
        //given
        List<Integer> usersLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winLottoNumber = Arrays.asList(1, 2, 3, 10, 11, 12);
        int bonusNumber = 13;
        WinLotto winLotto = new WinLotto(winLottoNumber, bonusNumber);
        //when
        Compare compare = new Compare(usersLotto, winLotto);
        Result result = compare.compute();
        //then
        assertThat(result).isEqualTo(Result.THREE);
    }

    @Test
    @DisplayName("[Compare] 4개 일치")
    void coincideFour() {
        //given
        List<Integer> usersLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winLottoNumber = Arrays.asList(1, 2, 3, 5, 11, 12);
        int bonusNumber = 13;
        WinLotto winLotto = new WinLotto(winLottoNumber, bonusNumber);
        //when
        Compare compare = new Compare(usersLotto, winLotto);
        Result result = compare.compute();
        //then
        assertThat(result).isEqualTo(Result.FOUR);
    }

    @Test
    @DisplayName("[Compare] 5개 일치")
    void coincideFive() {
        //given
        List<Integer> usersLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 12);
        int bonusNumber = 13;
        WinLotto winLotto = new WinLotto(winLottoNumber, bonusNumber);
        //when
        Compare compare = new Compare(usersLotto, winLotto);
        Result result = compare.compute();
        //then
        assertThat(result).isEqualTo(Result.FIVE);
    }

    @Test
    @DisplayName("[Compare] 5+보너스 일치")
    void coincideFiveBonus() {
        //given
        List<Integer> usersLotto = Arrays.asList(1, 2, 3, 4, 5, 13);
        List<Integer> winLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 12);
        int bonusNumber = 13;
        WinLotto winLotto = new WinLotto(winLottoNumber, bonusNumber);
        //when
        Compare compare = new Compare(usersLotto, winLotto);
        Result result = compare.compute();
        //then
        assertThat(result).isEqualTo(Result.FIVE_BONUS);
    }

    @Test
    @DisplayName("[Compare] 6개 일치")
    void coincideSix() {
        //given
        List<Integer> usersLotto = Arrays.asList(1, 2, 3, 4, 5, 12);
        List<Integer> winLottoNumber = Arrays.asList(1, 2, 3, 4, 5, 12);
        int bonusNumber = 13;
        WinLotto winLotto = new WinLotto(winLottoNumber, bonusNumber);
        //when
        Compare compare = new Compare(usersLotto, winLotto);
        Result result = compare.compute();
        //then
        assertThat(result).isEqualTo(Result.SIX);
    }
}