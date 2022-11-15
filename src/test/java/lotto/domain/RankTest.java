package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {
    @ParameterizedTest
    @DisplayName("맞는 로또번호 갯수와 보너스 번호 맞춘 여부가 주어지면, 해당 등수 리턴")
    @CsvSource({"6,false,FIRST","5,true,SECOND","5,false,THIRD", "4,false,FOURTH","3,false,FIFTH","2,false,NORANK"})
    void findByCountAndBonus(int count, boolean isCorrectBonus, String expected){
        String actual = Rank.findByCountAndBonus(count,isCorrectBonus).name();
        assertThat(actual).isEqualTo(expected);
    }
}