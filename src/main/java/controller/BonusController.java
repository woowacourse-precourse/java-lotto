package controller;

import domain.Bonus;
import domain.Lotto;
import service.BonusService;

import java.util.regex.Pattern;

public class BonusController {
    private static final String FORMAT = "^[0-9]*$";
    private final BonusService bonusService = new BonusService();

    public Bonus createBonusNumber(String bonusNumber, Lotto lotto) {
        isOneNumber(bonusNumber);
        return bonusService.createBonusNumber(Integer.parseInt(bonusNumber), lotto);
    }

    public void isOneNumber(String bonusNumber) {
        if (!Pattern.matches(FORMAT, bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 한 개의 숫자여야 합니다.");
        }
    }
}
