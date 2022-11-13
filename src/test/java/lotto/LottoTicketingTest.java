package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Validator;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketingTest {
    LottoTicketing lottoTicketing = new LottoTicketing();

    @DisplayName("로또 티켓을 발권해 티켓 내 중복된 숫자가 없는지 확인한다.")
    @Test
    void checkDuplicationInAutoCreatedLottoTickets() {
        List<Integer> lottoNumbers;
        Set<Integer> lottoNumbersWithoutDuplication;
        int count = 0;
        IllegalArgumentException error = new IllegalArgumentException();

        while (count != 100) {
            lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbersWithoutDuplication = new TreeSet<>(lottoNumbers);
            count++;
            if (lottoNumbers.size() != lottoNumbersWithoutDuplication.size()) {
                throw error;
            }
        }
        assertThat(lottoTicketing.getValidLottoNumbers().size()).isEqualTo(6);
    }
}