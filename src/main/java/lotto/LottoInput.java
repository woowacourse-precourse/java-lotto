package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.global.Message;
import lotto.util.LottoParser;

public class LottoInput {

    private String lottoInput;
    private String bonusInput;

    public List<Integer> getLottoInput() {
        lottoInput = Console.readLine();
        return lottoInputToLotto();
    }

    private List<Integer> lottoInputToLotto() {
        LottoParser lottoParser = new LottoParser();
        return lottoParser.lottoInputToLottoNumbers(lottoInput);
    }

    public Integer getBonusInput() {
        bonusInput = Console.readLine();
        Integer bonus = Integer.valueOf(bonusInput);
        validateBonus(bonus);
        return bonus;
    }

    public void validateBonus(Integer number) {
        LottoParser lottoParser = new LottoParser();

        if (number < 1 || number > 45) {
            lottoParser.lottoError(Message.ERROR_BONUS);
        }
    }

}
