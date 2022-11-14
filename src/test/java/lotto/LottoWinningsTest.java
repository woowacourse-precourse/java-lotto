package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoWinningsTest {

    @Test
    void lotto1Win() {
        long prizeMoney = 2_000_000_000;
        int count = 3;
        long totalPrizeMoney = prizeMoney * count;
        long result = LottoWinnings.LOTTO_1_WIN.money(3);
        assertThat(result).isEqualTo(totalPrizeMoney);
    }


    @Test
    void lotto2Win() {
        long prizeMoney = 30_000_000;
        int count = 3;
        long totalPrizeMoney = prizeMoney * count;
        long result = LottoWinnings.LOTTO_2_WIN.money(count);
        assertThat(result).isEqualTo(totalPrizeMoney);
    }

    @Test
    void lotto3Win() {
        long prizeMoney = 1_500_000;
        int count = 12;
        long totalPrizeMoney = prizeMoney * count;
        long result = LottoWinnings.LOTTO_3_WIN.money(count);
        assertThat(result).isEqualTo(totalPrizeMoney);
    }

    @Test
    void lotto4Win() {
        long prizeMoney = 50_000;
        int count = 22;
        long totalPrizeMoney = prizeMoney * count;
        long result = LottoWinnings.LOTTO_4_WIN.money(count);
        assertThat(result).isEqualTo(totalPrizeMoney);
    }

    @Test
    void lotto5Win() {
        long prizeMoney = 5_000;
        int count = 60;
        long totalPrizeMoney = prizeMoney * count;
        long result = LottoWinnings.LOTTO_5_WIN.money(count);
        assertThat(result).isEqualTo(totalPrizeMoney);
    }


}