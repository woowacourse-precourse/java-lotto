package lotto;

import org.assertj.core.api.InputStreamAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.*;




class LottoNumbersTest {

    @Test
    void getLottoWinningNumber() {
        String input = "5,6,4,8,9,1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        List<Integer> result = LottoNumbers.getLotteryWinningNumbers();

        assertThat(result).containsExactly(5,6,4,8,9,1);
    }
}