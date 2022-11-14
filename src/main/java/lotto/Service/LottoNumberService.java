package lotto.Service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import lotto.Model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Application.ERROR_MESSAGE;
import static lotto.Application.errorContent;

public class LottoNumberService {
    public Integer receiveLottoSheetsAmount() {
        try {
            Integer lottoSheetsAmount = Integer.parseInt(Console.readLine());
            return lottoSheetsAmount;
        } catch (Exception exception) {
            errorContent = ERROR_MESSAGE + " 구입 금액은 숫자여야 합니다.";
            throw new IllegalArgumentException(errorContent);
        }
    }

    public void checkDivideBy1000(Integer amount) {
        try {
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (Exception exception) {
            errorContent = ERROR_MESSAGE + " 구매 금액은 1000의 배수여야합니다.";
            throw new IllegalArgumentException(errorContent);
        }
    }

    public Integer receiveLottoSheetsCount(Integer lottoSheetsAmount) {
        checkDivideBy1000(lottoSheetsAmount);
        Integer lottoSheetsCount = lottoSheetsAmount / 1000;
        return lottoSheetsCount;
    }

    public List<Lotto> generateRandomNumber(int lottoSheetsCount) throws IllegalArgumentException {
        List<Lotto> lottoList = new ArrayList<>();
        while (lottoList.size() < lottoSheetsCount) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            try {
                Lotto lotto = new Lotto(numbers);
                lottoList.add(lotto);
            } catch (Exception exception) {
                errorContent = exception.getMessage();
                throw new IllegalArgumentException(errorContent);
            }
        }
        return lottoList;
    }

}
