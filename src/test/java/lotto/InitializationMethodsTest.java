package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import static lotto.Application.numberType;
import static lotto.Application.Places;

import static lotto.Application.initializeNumberType;
import static lotto.Application.initializeNoOfLottoWinAt;
import static lotto.Application.initializePrizesAtPlaces;

import static lotto.Application.prizesAt;
import static lotto.Application.noOfLottoWinAt;
import lotto.Application.NumberType;

class InitializationMethodsTest {
    @DisplayName("initializeNumberType 메소드 초기화 결과 테스트")
    @Test
    void initializeNumberTypeMethodResultTest() {
        initializeNumberType();
        for (int number = 1; number <= 45; number++)
            assertThat(numberType[number]).isEqualTo(NumberType.NONE);
    }

    @DisplayName("initializeNoOfLottoWinAt 메소드 초기화 결과 테스트")
    @Test
    void initializeNoOfLottoWinAtMethodResultTest() {
        initializeNoOfLottoWinAt();
        for (Places place: Places.values())
            assertThat(noOfLottoWinAt.get(place)).isEqualTo(0);
    }

    @DisplayName("initializePrizesAtPlaces 메소드 초기화 결과 테스트")
    @Test
    void initializePrizesAtPlacesMethodResultTest() {
        initializePrizesAtPlaces();
        ArrayList<Long> prizes
                = new ArrayList<>(List.of(2_000_000_000L, 30_000_000L, 1_500_000L, 50_000L, 5_000L, 0L));
        int index = 0;
        for (Places place: Places.values()) {
            assertThat(prizesAt.get(place)).isEqualTo(prizes.get(index));
            index++;
        }
    }
}