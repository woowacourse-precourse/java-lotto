package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManagementLotto {
    private final ValidInput validInput = new ValidInput();

    public List<Lotto> purchase(Integer amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < amount; count++) {
            lottos.add(generateLottoNumber());
        }

        return lottos;
    }

    public Lotto generateLottoNumber() {
        List<Integer> lottoNumber;
        lottoNumber = Randoms.pickUniqueNumbersInRange(
            LottoEnum.START_NUM.getValue(), LottoEnum.END_NUM.getValue(),
            LottoEnum.SIZE.getValue());
        lottoNumber.sort(Integer::compareTo);

        return new Lotto(lottoNumber);
    }

    public List<Integer> makeWinNumber(String input) {
        // List<Integer> winLottoNumber = new ArrayList<>();
        List<Integer> inputNumberList = Arrays.stream(input.split(",")).map(Integer::parseInt)
            .collect(Collectors.toList());
        validInput.validInputLength(inputNumberList);

        for (Integer number : inputNumberList) {
            validInput.validIsInputInRange(number);
        }

        validInput.validInputHasDuplicatedNumber(inputNumberList);

        return inputNumberList;
    }

    public Integer makeBonusNumber(String input) {
        Integer bonusNumber = Integer.parseInt(input);
        validInput.validIsInputInRange(bonusNumber);

        return bonusNumber;
    }

    public void checkLottoNumber() {

    }
}
