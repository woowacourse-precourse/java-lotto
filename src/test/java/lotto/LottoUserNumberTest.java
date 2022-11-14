package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoUserNumberTest {
    private static long ticket = 8;
    LottoUserNumber lottoUserNumber = new LottoUserNumber();


    @BeforeEach
    void setUp() {
        lottoUserNumber.createRandomNumber(ticket);
    }

    @DisplayName("중복된 숫자가 존재하면 예외가 발생한다.")
    @Test
    void 중복되는_숫자() {
        int result = 0;
        for (int i = 0; i < ticket; i++) {
            Set<Integer> deduplicationNumbers = new HashSet<>(lottoUserNumber.LottoRandomNumbers.get(i));
            List<Integer> afterNumbers = new ArrayList<>(deduplicationNumbers);
            if (!(lottoUserNumber.LottoRandomNumbers.get(i).size() == 6)) {
                result++;
            }
            if (lottoUserNumber.LottoRandomNumbers.get(i).size() != afterNumbers.size()) {
                result++;
            }
        }
        assertThat(result == 0).isEqualTo(true);
    }

    @DisplayName("숫자 범위가 벗어나면 예외가 발생한다.")
    @Test
    void 숫자_범위() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            allNumbers.add(i);
        }
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < lottoUserNumber.LottoRandomNumbers.size(); i++) {
            for (int j = 0; j < 6; j++) {
                userNumbers.add(lottoUserNumber.LottoRandomNumbers.get(i).get(j));
            }
        }
        userNumbers.removeAll(allNumbers);

        boolean result = userNumbers.size() == 0;
        assertThat(result).isEqualTo(true);
    }

    @DisplayName("티켓 수량만큼 생성한다.")
    @Test
    void 티켓_수량만큼_생성() {
        assertThat(lottoUserNumber.LottoRandomNumbers.size()).isEqualTo(ticket);
    }

}