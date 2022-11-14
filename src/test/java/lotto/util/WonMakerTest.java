package lotto.util;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WonMakerTest {
    @DisplayName("0원 환전")
    @Test
    public void zeroTest() {
        String expected = WonMaker.makeWon(0);
        String result = "0원";
        assertThat(expected).isEqualTo(result);
    }

    @DisplayName("1000원 환전")
    @Test
    public void thousandTest() {
        String expected = WonMaker.makeWon(1_000);
        String result = "1,000원";
        assertThat(expected).isEqualTo(result);
    }

    @DisplayName("10000원 환전")
    @Test
    public void tenThousandTest() {
        String expected = WonMaker.makeWon(1_0000);
        String result = "10,000원";
        assertThat(expected).isEqualTo(result);
    }

    @DisplayName("999원 환전")
    @Test
    public void tenThousandMinusOneTest() {
        String expected = WonMaker.makeWon(999);
        String result = "999원";
        assertThat(expected).isEqualTo(result);
    }

    @DisplayName("30,000,000원 환전")
    @Test
    public void secondTest() {
        String expected = WonMaker.makeWon(Rank.SECOND.getRewardMoney());
        String result = "30,000,000원";
        assertThat(expected).isEqualTo(result);
    }

    @DisplayName("2,000,000,000원 환전")
    @Test
    public void firstTest() {
        String expected = WonMaker.makeWon(Rank.FIRST.getRewardMoney());
        String result = "2,000,000,000원";
        assertThat(expected).isEqualTo(result);
    }
}