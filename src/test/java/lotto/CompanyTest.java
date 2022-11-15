package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void createInputByDuplicated() {
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
    @DisplayName("당첨 통계 출력이 예상과 일치한다.")
    void printResult() {
        PrintStream origin = System.out;
        Company company = new Company();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        List<Prize> prizes = new ArrayList<>();
        prizes.add(Prize.BANG);
        prizes.add(Prize.BANG);
        prizes.add(Prize.BANG);
        prizes.add(Prize.BANG);
        prizes.add(Prize.BANG);
        prizes.add(Prize.BANG);
        prizes.add(Prize.BANG);
        prizes.add(Prize.FIVE);
        Integer money = 8000;
        company.printResult(prizes, money);

        assertThat(outputStream.toString()).isEqualTo(
                "\n당첨 통계\n---\n" +
                        "3개 일치 (5,000원) - 1개\n" +
                        "4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                        "6개 일치 (2,000,000,000원) - 0개\n" +
                        "총 수익률은 62.5%입니다.\n");
    }

    @Test
    @DisplayName("당첨 번호 비교 결과가 예상과 일치한다.")
    void checkWinNumber() {
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Company company = new Company();
        company.inputWinNumbers();
        input = "6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        List<Lotto> lotto = Arrays.asList(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        List<Prize> result = company.check(lotto);
        List<Prize> sample = new ArrayList<>();
        sample.add(Prize.BANG);
        sample.add(Prize.BANG);
        sample.add(Prize.BANG);
        sample.add(Prize.BANG);
        sample.add(Prize.BANG);
        sample.add(Prize.BANG);
        sample.add(Prize.BANG);
        sample.add(Prize.FIVE);
        assertThat(result).isEqualTo(sample);
    }
}