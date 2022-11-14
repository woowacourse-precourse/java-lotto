package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    @DisplayName("맞는 로또번호 갯수와 보너스 번호 맞춘 여부가 주어지면, 해당 등수 리턴")
    void findByCountAndBonus(){
        //Given
        int count = 5;
        boolean isCorrectBonus = false;

        //When
        Rank rank = Rank.findByCountAndBonus(count, isCorrectBonus);
        //Then
        assertThat(rank.name()).isEqualTo("THIRD");
    }


    @Test
    @DisplayName("5등 안에 못들면 NORANK 리턴")
    void findByCountAndBonusNORANK(){
        //Given
        int count = 2;
        boolean isCorrectBonus = false;
        //When
        Rank rank = Rank.findByCountAndBonus(count, isCorrectBonus);
        //Then
        assertThat(rank.name()).isEqualTo("NORANK");
    }
}