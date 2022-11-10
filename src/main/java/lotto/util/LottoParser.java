package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.global.Message;

public class LottoParser {

    public List<Integer> lottoInputToLottoNumbers(String lottoInput) {
        List<Integer> lottoNumbers = new ArrayList<>();

        try {
            List<String> lottoInputSplit = List.of(lottoInput.split(","));
            lottoNumbers = lottoInputSplit.stream().map(input -> Integer.valueOf(input))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            lottoError(Message.ERROR_LOTTO);
        }

        return lottoNumbers;
    }

    public void lottoError(Message message) {
        message.print();
        throw new IllegalArgumentException();
    }
}
