package util;

import constant.ErrorMessage;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertWinningLottoNumberTest {



    @Test
    @DisplayName(",로분리된 번호가 숫자인지?")
    void validateSplitNumber_문자인지확인() {
        String wrongSplitedNumber = "j";

        Assertions.assertThatThrownBy(() -> {
                int convertSplitedNumber = 0;
                try {
                    convertSplitedNumber = Integer.parseInt(wrongSplitedNumber);
                } catch (Exception e) {
                    throw new IllegalArgumentException(ErrorMessage.ERROR_WINNING_NOT_NUMBER.getMessage());
                }
            }
        ).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> {
            ConvertWinningLottoNumber.validateSplitNumber(wrongSplitedNumber);
        }).isInstanceOf(IllegalArgumentException.class);

    }




}