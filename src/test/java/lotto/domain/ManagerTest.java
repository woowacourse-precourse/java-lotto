package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

import lotto.domain.Lotto;
import lotto.domain.Manager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManagerTest {

    @DisplayName("로또 결과 종합하기")
    @Test
    void sumUpResult() {
        Manager manager = new Manager();
        List<Integer> sumOfResult = manager.sumUpResult(List.of(0, 2, 3, 3, 5, 15, 6, 2, 0, 1));

        assertThat(sumOfResult).isEqualTo(List.of(2, 0, 1, 1, 1));
    }

    @DisplayName("수익률 계산하기")
    @Test
    void getRateOfReturn() {
        LottoMachine lottoMachine = new LottoMachine();
        Manager manager = new Manager();
        lottoMachine.purchaseLottoTable(8000);
        float result = manager.getRateOfReturn(List.of(1,0,0,0,0));

        assertThat(result).isEqualTo(62.5f);
    }
}


