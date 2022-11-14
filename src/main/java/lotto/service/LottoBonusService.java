package lotto.service;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.enumtype.LottoNumberInclusive;
import lotto.constant.enumtype.LottoRule;
import lotto.constant.enumtype.UserInterfaceMessage;
import lotto.domain.lotto.repository.Lotto;
import lotto.domain.lotto.repository.LottoBonus;

public class LottoBonusService {
    private LottoBonus lottoBonus;

    private LottoBonusService() {
    }

    private static class InnerLottoBonusService {
        private static final LottoBonusService instance = new LottoBonusService();
    }

    public static LottoBonusService getInstance(){
        return InnerLottoBonusService.instance;
    }

    public void inputLottoBonusNumber(List<Integer> LottoNumber) {
        System.out.println(UserInterfaceMessage.REQUEST_INPUT_BONUS_NUMBER.getValue());
        setLottoBonusNumber(readLine(), LottoNumber);
    }

    public void setLottoBonusNumber(String bonusNumber, List<Integer> LottoNumber) throws IllegalArgumentException {
        lottoBonus = new LottoBonus(validateNumberFormat(bonusNumber), LottoNumber);
    }

    private Integer validateNumberFormat(String bonusNumber) {
        Integer parsedBonusNumber = 0;
        try {
            parsedBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format(UserInterfaceMessage.ERROR_INPUT_BONUS_NUMBER_INCLUSIVE.getValue(),
                    LottoNumberInclusive.START.getValue(), LottoNumberInclusive.END.getValue()));
        }
        return parsedBonusNumber;
    }


    public LottoBonus getLottoBonus() {
        return lottoBonus;
    }
    public Integer getLottoBonusNumber() {
        return lottoBonus.getBonusNumber();
    }
}
