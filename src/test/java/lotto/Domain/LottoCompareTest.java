package lotto.Domain;

import lotto.Domain.LottoCompare;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoCompareTest {
    LottoCompare lottoCompare = new LottoCompare();

    @Test
    @DisplayName("사용자 로또번호와 당첨 번호를 비교한 결과를 반환한다.")
    void compareResultLotto() {
        //given
        List<List<Integer>> userLottoSheet = new ArrayList<>();
        List<List<Integer>> expectResultLotto = new ArrayList<>();
        List<Integer> winnerLotto = new ArrayList<>(Arrays.asList(1, 7, 3, 17, 20, 21));

        userLottoSheet.add(Arrays.asList(1, 7, 3, 17, 18, 19));
        expectResultLotto.add(Arrays.asList(4, 0));

        //when
        List<List<Integer>> compareResultLotto = lottoCompare.compareResultLotto(userLottoSheet, winnerLotto, "13");

        //Then
        assertEquals(expectResultLotto, compareResultLotto);
    }

    @Test
    @DisplayName("사용자 로또번호 중 당첨번호와 일치하지 않는 번호만 반환한다.")
    void unMatchUserBall() {
        //given
        List<Integer> expectResultLotto = new ArrayList<>(Arrays.asList(18, 19));
        List<Integer> winnerLotto = new ArrayList<>(Arrays.asList(1, 7, 3, 17, 20, 21));
        List<Integer> userLottoSheet = new ArrayList<>(Arrays.asList(1, 7, 3, 17, 18, 19));

        //when
        List<Integer> unMatchResultLotto = lottoCompare.unMatchUserBall(userLottoSheet, winnerLotto);

        //Then
        assertEquals(expectResultLotto, unMatchResultLotto);
    }
}

