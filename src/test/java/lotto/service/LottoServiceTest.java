package lotto.service;

import lotto.domain.GenerateNumbers;
import lotto.domain.LottoRanking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    LottoService lottoService = new LottoService();

    @Test
    void generateLotteries() {
        assertThat(lottoService.generateLotteries(8).size()).isEqualTo(8);
    }

    @Test
    void calculatorProfit() {
        UserService userService = new UserService();
        userService.buyLotto("10000");
        List<LottoRanking> lottoRankingList = new ArrayList<>(List.of(LottoRanking.FIFTH_PLACE,LottoRanking.FIFTH_PLACE));
        assertThat(lottoService.calculatorProfit(lottoRankingList)).isEqualTo(10000);
    }

}