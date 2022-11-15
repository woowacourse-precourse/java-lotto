package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTEST {
    LottoController lottoController;
    @BeforeEach
    void setUp(){
        lottoController = new LottoController();
    }
    @DisplayName("금액 입력시 1000원 단위가 아니거나 0보다 작은 경우 예외 발생")
    @ParameterizedTest
    @CsvSource({"10","500","-500","-1000","1234"})
    void cost2countTest(int num) {
        assertThatThrownBy(() -> {
            lottoController.cost2count(num);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
