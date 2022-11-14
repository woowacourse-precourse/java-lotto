package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.IllegalResultLottoException;
import lotto.util.LottoValueRange;

public class ResultLotto {
    private Lotto lotto;
    private List<Integer> specialNumbers;

    public ResultLotto(Lotto lotto, List<Integer> specialNumbers, int specialNumberSize) {
        validate(lotto, specialNumbers, specialNumberSize);
        this.lotto = lotto;
        this.specialNumbers = specialNumbers;
    }

    public ResultLotto(String lottoReadLine, String delimiter, int lottoSize, String specialNumberReadLine,
                       int specialNumberSize) {
        Lotto lotto = new Lotto(transformReadLine(lottoReadLine, delimiter), lottoSize);
        List<Integer> specialNumbers = transformReadLine(specialNumberReadLine, delimiter);
        validate(lotto, specialNumbers, specialNumberSize);
        this.lotto = lotto;
        this.specialNumbers = specialNumbers;
    }

    private static List<Integer> transformReadLine(String readLine, String delimiter) {
        try {
            return Arrays.stream(readLine.split(delimiter))
                    .map(x -> Integer.parseInt(x))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalResultLottoException();
        }
    }

    private static void validate(Lotto lotto, List<Integer> specialNumbers, int specialNumberSize) {
        LottoValueRange.validate(specialNumbers);
        duplicateValidate(lotto, specialNumbers, specialNumberSize);
    }

    private static void duplicateValidate(Lotto lotto, List<Integer> specialNumbers, int specialNumberSize) {
        Set<Integer> copySpecialNumbers = new HashSet<>(specialNumbers);
        copySpecialNumbers.addAll(lotto.getNumbers());
        if (copySpecialNumbers.size() != specialNumberSize + lotto.getNumbers().size()) {
            throw new IllegalResultLottoException();
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public List<Integer> getSpecialNumbers() {
        return specialNumbers;
    }
}
