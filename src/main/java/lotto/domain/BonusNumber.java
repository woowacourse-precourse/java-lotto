package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import static lotto.domain.AdditionalFunction.StringToInt;
import static lotto.domain.AdditionalFunction.validateNumRange;

public class BonusNumber {
    private final int bonusNumber;
    private final PrizeLotto prizeLotto;

    public BonusNumber(PrizeLotto prizeLotto) {
        this.prizeLotto = prizeLotto;
        this.bonusNumber = CreateBonusLotto();
    }

    private int CreateBonusLotto(){
        String inputValue = Console.readLine();
        int lottoNum = StringToInt(inputValue);
        validateNumRange(lottoNum);
        validateDuplicate(lottoNum, prizeLotto);
        return lottoNum;
    }

    private void validateDuplicate(int bonusNumber, PrizeLotto prizeLotto) {
        if (prizeLotto.getPrizeLotto().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }
}
