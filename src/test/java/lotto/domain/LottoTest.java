package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottosResponseDto.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 1등 결과를 반환하는 기능")
    @Test
    void calculateAnswerFirst() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.play(lotto);
        assertThat(lottoResult.isFirst()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 2등 결과를 반환하는 기능")
    @Test
    void calculateAnswerSecond() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.play(lotto);
        assertThat(lottoResult.isSecond()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 3등 결과를 반환하는 기능")
    @Test
    void calculateAnswerThird() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.play(lotto);
        assertThat(lottoResult.isThird()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 4등 결과를 반환하는 기능")
    @Test
    void calculateAnswerFourth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.play(lotto);
        assertThat(lottoResult.isFourth()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 5등 결과를 반환하는 기능")
    @Test
    void calculateAnswerFifth() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 7));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.play(lotto);
        assertThat(lottoResult.isFifth()).isTrue();
    }

    @DisplayName("1개의 로또와 당첨 번호를 비교하여 이외의 결과를 반환하는 기능")
    @Test
    void calculateAnswerElse() {
        Lotto lotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Answer answer = new Answer(List.of(6, 5, 4, 3, 2, 1), 7);

        LottoResult lottoResult = answer.play(lotto);
        assertThat(lottoResult.isElse()).isTrue();
    }

    @DisplayName("한개의 로또를 오름차순으로 정렬하는 기능")
    @CsvSource(value = {"0:4", "1:7", "2:9", "3:10", "4:12", "5:14"}, delimiter = ':')
    @ParameterizedTest
     void sortLottoNumber(int index, int answer) {
        List<Integer> numbers = new ArrayList<>(List.of(7, 4, 9, 10, 14, 12));
        Lotto lotto = new Lotto(numbers);

        LottoResponseDto responseDto = lotto.toResponseDto();
        List<Integer> sortNumbers = responseDto.getLottoNumber();

        assertThat(sortNumbers.get(index)).isEqualTo(answer);
    }
}
