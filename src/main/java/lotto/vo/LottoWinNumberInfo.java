package lotto.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinNumberInfo {

    private List<Integer> lottoWinNumbers;
    private int bonusNumber;

    public LottoWinNumberInfo(String inputWinNumbers) {
        this.lottoWinNumbers = lottoNumberToList(inputWinNumbers);
    }

    public LottoWinNumberInfo(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> lottoNumberToList(String inputWinNumbers) {
        return Arrays.stream(inputWinNumbers
                .replaceAll(" ", "")
                .split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }


    public List<Integer> getLottoWinNumbers() {
        return lottoWinNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
