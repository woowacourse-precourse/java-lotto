package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GenerateNumbersTest {

    @DisplayName("6개의 숫자와 1개의 보너스 번호를 생성하는지 확인")
    @Test
    void generateNumbers() {
        GenerateNumbers generateNumbers = new GenerateNumbers();
        List<Integer> checkNumbers = generateNumbers.getGenerateNumbers();
        int checkBonusNumber = 0;
        checkBonusNumber = generateNumbers.getBonusNumber();

        assertThat(checkNumbers.size()).isEqualTo(6);
        assertThat(checkBonusNumber).isNotZero();
    }
}