package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {

    public static Lotto winNumber;
    public InputController winNumberInputController = new WinNumberInputController();

    public List<Lotto> issueLottoNumbers(long count) {

        List<Lotto> lottoNumbers = Stream.generate(() -> new Lotto(getLottoNumber()))
                .limit(count)
                .collect(Collectors.toList());

        return lottoNumbers;
    }

    public List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void setWinNumber(List<String> inputLottoNumber) {

        winNumberInputController.validate(inputLottoNumber);

        winNumber = new Lotto(convertInteger(inputLottoNumber));
    }

    public List<Integer> convertInteger(List<String> inputLottoNumber) {

        return inputLottoNumber.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
