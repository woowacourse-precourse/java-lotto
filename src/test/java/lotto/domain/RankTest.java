package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.constant.Rank;

class RankTest {
    @DisplayName("2개 이하는 꼴등")
    @ParameterizedTest(name = "{0}개 맞으면 꼴등")
    @CsvSource(value = {"0,false,NONE", "1,false,NONE", "2,false,NONE"}, delimiter = ',')
    void zero_one_and_two_is_NONE(int matchCount, boolean hasBonusNumber, Rank expected) {
        assertThat(Rank.from(matchCount, hasBonusNumber)).isEqualTo(expected);
    }

    @DisplayName("3개 맞으면 5등")
    @Test
    void three_match_is_FIFTH() {
        int matchCount = 3;
        boolean hasBonusNumber = false;

        assertThat(Rank.from(matchCount, hasBonusNumber)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("4개 맞으면 4등")
    @Test
    void four_match_is_FOURTH() {
        int matchCount = 4;
        boolean hasBonusNumber = false;

        assertThat(Rank.from(matchCount, hasBonusNumber)).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("5개 맞고 보너스번호 없으면 3등")
    @Test
    void five_match_without_bonus_number_is_THIRD() {
        int matchCount = 5;
        boolean hasBonusNumber = false;

        assertThat(Rank.from(matchCount, hasBonusNumber)).isEqualTo(Rank.THIRD);
    }

    @DisplayName("5개 맞고 보너스번호 있으면 2등")
    @Test
    void five_match_with_bonus_number_is_SECOND() {
        int matchCount = 5;
        boolean hasBonusNumber = true;

        assertThat(Rank.from(matchCount, hasBonusNumber)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("6개 맞으면 1등")
    @Test
    void six_match_is_FIRST() {
        int matchCount = 6;
        boolean hasBonusNumber = false;

        assertThat(Rank.from(matchCount, hasBonusNumber)).isEqualTo(Rank.FIRST);
    }
}