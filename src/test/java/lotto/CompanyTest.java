package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    @DisplayName("당첨 번호에 문자열이 있다면 예외가 발생한다.")
    void createInputByString() {
        String input = "1,2,3,4,5,a";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Company company = new Company();

        assertThatThrownBy(company::inputWinNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호가 중복이면 예외가 발생한다.")
    void createInputByDuplicatedNumber() {
        String input = "1,2,3,4,5,5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Company company = new Company();

        assertThatThrownBy(company::inputWinNumbers)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다.")
    void inputBonusNumber() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Company company = new Company();
        company.inputWinNumbers();
        input = "6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(company::inputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void check() {

    }
}