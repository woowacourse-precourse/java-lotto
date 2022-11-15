package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import static lotto.domain.LottoNumberParser.parseLottoNumbers;

public class InputLottoGenerateStrategy implements LottoGenerateStrategy {
    @Override
    public Lotto generate() {
        String inputLottoNumbers = Console.readLine();
        return new Lotto(parseLottoNumbers(inputLottoNumbers));
    }
}
