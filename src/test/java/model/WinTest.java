package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WinTest {

    @ParameterizedTest(name = "{index}  {0}개 일치, 보너스 볼 일치({1}) 시 등수 : {2}")
    @CsvSource(value = {"6:false:FIRST", "5:true:SECOND", "5:false:THIRD", "4:false:FOURTH", "3:false:FIFTH"}, delimiter = ':')
    void 등수를_반환한다(int matchCount, boolean containsBonusBall, Win win) {
        Optional<Win> ranking = Win.getRanking(matchCount, containsBonusBall);

        assertTrue(ranking.isPresent());
        assertEquals(ranking.get(), win);
    }

    @Test
    void 일치하는_번호가_없으면_빈_값을_반환한다() {
        Optional<Win> ranking = Win.getRanking(0, false);

        assertTrue(ranking.isEmpty());
    }
}