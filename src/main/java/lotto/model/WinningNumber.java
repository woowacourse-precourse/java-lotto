package lotto.model;

import lotto.service.LottoService;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.model.Lotto.*;

public class WinningNumber {
    private List<Integer> winningNumber;
    private final String INVALID_WINNING_NUMBER_ERROR = "[ERROR] 로또 번호는 중복되지 않은 1부터 45 사이의 숫자 6개입니다.";

    public WinningNumber(String winningNumberString) {

        validate(winningNumberString);
    }

    private void validate(String winningListString) {
        winningNumber = new ArrayList<>();
        String[] split = winningListString.split(LOTTO_DELIMITER);
        Set<Integer> lottoNumberSet = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            int number = validateNumber(split[i]);
            winningNumber.add(number);
            lottoNumberSet.add(number);
        }
        try {
            if (lottoNumberSet.size() != LOTTO_LENGTH) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            LottoService.status = LottoService.ERROR_STATUS;
            OutputView.printError(INVALID_WINNING_NUMBER_ERROR);
        }
    }

    public int validateNumber(String numberString) {
        int number = 0;
        try {
            number = Integer.parseInt(numberString);
            if (!(number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX)) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            LottoService.status = LottoService.ERROR_STATUS;
            OutputView.printError(INVALID_WINNING_NUMBER_ERROR);
        }
        return number;
    }

    public List<Integer> getWinningNumber() {

        return winningNumber;
    }
}
