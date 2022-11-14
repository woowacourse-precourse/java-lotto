package lotto.global;

import lotto.model.Lotto;

import java.util.List;

public class LogicException {

    public static void verifyMoney(String money) {
        if (!money.matches("^\\d*")) {
            System.out.println(ExceptionCode.NUM_ERROR.getMessage());
            throw new IllegalArgumentException(ExceptionCode.NUM_ERROR.getMessage());
        }
        if(Integer.parseInt(money) % 1000 != 0 || Integer.parseInt(money) == 0) {
            throw new IllegalArgumentException(ExceptionCode.MUST_DIVIDE_UNIT_PRICE.getMessage());
        }
    }

    public static void verifyLottoListVolume(List<Lotto> lottoList, int volume) {
        if(lottoList.size() != volume) {
            throw new IllegalArgumentException(ExceptionCode.NOT_CORRECT_VOLUME.getMessage());
        }
    }

    public static void verifyBonusNum(int bonusNum) {
        if(bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException(ExceptionCode.NOT_CORRECT_BONUS_NUM_RANGE.getMessage());
        }
    }

    public static void verifyBonusNumAndJackpot(String[] jackpotNumArr, int bonusNum) {
        for(int i = 0; i < jackpotNumArr.length; i++) {
            int jackpotNum = Integer.parseInt(jackpotNumArr[i]);
            if(jackpotNum == bonusNum) {
                throw new IllegalArgumentException(ExceptionCode.NOT_CORRECT_BONUS_NUM.getMessage());
            }
        }
    }
}
