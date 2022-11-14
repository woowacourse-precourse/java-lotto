package lotto;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankSystemTest {
    RankSystem rankSystem = new RankSystem();

    @Test
    void hasCountCheck() {
        // GIVEN

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        // WHEN
        rankSystem.hasPrintCount(List.of(-1, 2, 3, 4, 5, 6));

        //THEN
        assertThat(out.toString().trim()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 1개"
        );
    }


}