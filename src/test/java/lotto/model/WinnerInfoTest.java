package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerInfoTest {

    @DisplayName("1등 결과 값 확인 테스트")
    @Test
    void rank1Test() {
        int result = WinnerInfo.getRank(6);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("2등 결과 값 확인 테스트")
    @Test
    void rank2Test() {
        int result = WinnerInfo.checkRank2(true);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("3등 결과 값 확인 테스트")
    @Test
    void rank3Test() {
        int result = WinnerInfo.checkRank2(false);
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("4등 결과 값 확인 테스트")
    @Test
    void rank4Test() {
        int result = WinnerInfo.getRank(4);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("5등 결과 값 확인 테스트")
    @Test
    void rank5Test() {
        int result = WinnerInfo.getRank(3);
        assertThat(result).isEqualTo(4);
    }

    @DisplayName("순위에 없을 때 결과 값 확인 테스트")
    @Test
    void noRankTest() {
        int result = WinnerInfo.getRank(1);
        assertThat(result).isEqualTo(-1);
    }
}
