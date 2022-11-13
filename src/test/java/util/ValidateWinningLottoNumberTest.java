package util;

import static org.junit.jupiter.api.Assertions.*;

import constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateWinningLottoNumberTest {

    @Test
    @DisplayName("티켓사이즈확인")
    void setWinningLottoTicket_티켓사이즈확인() {
        String winningLotto = "1,3,5,7,9";
        String[] split = winningLotto.split(",");
        List<Integer> winningLottoTicket = new ArrayList<>();
        for (String number : split) {
            winningLottoTicket.add(Integer.parseInt(number));
        }

        Assertions.assertThatThrownBy(() -> {
            if (winningLottoTicket.size() != 6) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_INCORRECT_SIZE.getMessage());
            }
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName(",로분리된 번호가 숫자인지?")
    void validateSplitNumber_문자인지확인() {
        String wrongSplitedNumber = "j";

        Assertions.assertThatThrownBy(() -> {
                int convertSplitedNumber = 0;
                try {
                    convertSplitedNumber = Integer.parseInt(wrongSplitedNumber);
                } catch (Exception e) {
                    throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
                }
            }

        ).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName(",로 분리된 숫자가 범위 안에 있는지")
    void validateSplitNumber_범위안에있는지() {
        String wrongSplitedNumber = "46";
        Assertions.assertThatThrownBy(() -> {
            int convertSplitedNumber = 0;
            try {
                convertSplitedNumber = Integer.parseInt(wrongSplitedNumber);
            } catch (Exception e) {
            }

            if (convertSplitedNumber < 1 || convertSplitedNumber > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_OVERRANGE.getMessage());
            }
        }).isInstanceOf(IllegalArgumentException.class);

    }





}