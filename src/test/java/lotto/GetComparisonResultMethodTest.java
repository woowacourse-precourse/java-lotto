package lotto;

import lotto.Application.Places;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import lotto.Application.NumberType;

import static lotto.Application.getComparisonResult;
import static lotto.Application.initializeNoOfLottoWinAt;
import static org.assertj.core.api.Assertions.assertThat;

import static lotto.Application.noOfLottoWinAt;
import static lotto.Application.numberType;
import static lotto.Application.purchasedLottos;

class GetComparisonResultMethodTest {
    @Test
    void getComparisonResult_메소드_테스트1() {
        initializeNoOfLottoWinAt();
        for (int number = 1; number <= 6; number++)
            numberType[number] = NumberType.WINNING;
        numberType[7] = NumberType.BONUS;
        ArrayList<Integer> purchasedLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        purchasedLottos.add(purchasedLotto);
        getComparisonResult();

        assertThat(noOfLottoWinAt.get(Places.FIRST)).isEqualTo(1);
        assertThat(noOfLottoWinAt.get(Places.SECOND)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.THIRD)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FOURTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FIFTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.NONE)).isEqualTo(0);
    }

    @Test
    void getComparisonResult_메소드_테스트2() {
        initializeNoOfLottoWinAt();
        for (int number = 1; number <= 6; number++)
            numberType[number] = NumberType.WINNING;
        numberType[7] = NumberType.BONUS;
        ArrayList<Integer> purchasedLotto = new ArrayList<>(List.of(2, 3, 4, 5, 6, 7));

        purchasedLottos.remove(0);
        purchasedLottos.add(purchasedLotto);
        getComparisonResult();

        assertThat(noOfLottoWinAt.get(Places.FIRST)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.SECOND)).isEqualTo(1);
        assertThat(noOfLottoWinAt.get(Places.THIRD)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FOURTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FIFTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.NONE)).isEqualTo(0);
    }

    @Test
    void getComparisonResult_메소드_테스트3() {
        initializeNoOfLottoWinAt();
        for (int number = 1; number <= 6; number++)
            numberType[number] = NumberType.WINNING;
        numberType[7] = NumberType.BONUS;
        ArrayList<Integer> purchasedLotto = new ArrayList<>(List.of(2, 3, 4, 5, 6, 8));

        purchasedLottos.remove(0);
        purchasedLottos.add(purchasedLotto);
        getComparisonResult();

        assertThat(noOfLottoWinAt.get(Places.FIRST)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.SECOND)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.THIRD)).isEqualTo(1);
        assertThat(noOfLottoWinAt.get(Places.FOURTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FIFTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.NONE)).isEqualTo(0);
    }

    @Test
    void getComparisonResult_메소드_테스트4() {
        initializeNoOfLottoWinAt();
        for (int number = 1; number <= 6; number++)
            numberType[number] = NumberType.WINNING;
        numberType[7] = NumberType.BONUS;
        ArrayList<Integer> purchasedLotto = new ArrayList<>(List.of(3, 4, 5, 6, 7, 8));

        purchasedLottos.remove(0);
        purchasedLottos.add(purchasedLotto);
        getComparisonResult();

        assertThat(noOfLottoWinAt.get(Places.FIRST)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.SECOND)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.THIRD)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FOURTH)).isEqualTo(1);
        assertThat(noOfLottoWinAt.get(Places.FIFTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.NONE)).isEqualTo(0);
    }

    @Test
    void getComparisonResult_메소드_테스트5() {
        initializeNoOfLottoWinAt();
        for (int number = 1; number <= 6; number++)
            numberType[number] = NumberType.WINNING;
        numberType[7] = NumberType.BONUS;
        ArrayList<Integer> purchasedLotto = new ArrayList<>(List.of(4, 5, 6, 7, 8, 9));

        purchasedLottos.remove(0);
        purchasedLottos.add(purchasedLotto);
        getComparisonResult();

        assertThat(noOfLottoWinAt.get(Places.FIRST)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.SECOND)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.THIRD)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FOURTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FIFTH)).isEqualTo(1);
        assertThat(noOfLottoWinAt.get(Places.NONE)).isEqualTo(0);
    }

    @Test
    void getComparisonResult_메소드_테스트6() {
        initializeNoOfLottoWinAt();
        for (int number = 1; number <= 6; number++)
            numberType[number] = NumberType.WINNING;
        numberType[7] = NumberType.BONUS;
        ArrayList<Integer> purchasedLotto = new ArrayList<>(List.of(5, 6, 7, 8, 9, 10));

        purchasedLottos.remove(0);
        purchasedLottos.add(purchasedLotto);
        getComparisonResult();

        assertThat(noOfLottoWinAt.get(Places.FIRST)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.SECOND)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.THIRD)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FOURTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.FIFTH)).isEqualTo(0);
        assertThat(noOfLottoWinAt.get(Places.NONE)).isEqualTo(1);
    }
}