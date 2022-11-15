package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.Type;
import lotto.util.InputUtility;
import lotto.util.ValidationUtility;

public class LottoBroadcast {

    private Lotto winning;
    private int bonus;

    private LottoBroadcast() {
        drawWinning();
        drawBonus();
    }

    public static LottoBroadcast onAir() {
        return new LottoBroadcast();
    }

    private void drawWinning() {
        this.winning = new Lotto(getWinningInput());
    }

    private List<Integer> getWinningInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = InputUtility.readLine(Type.LOTTO.getValue());
        return InputUtility.parseLotto(input);
    }

    private void drawBonus() {
        this.bonus = getBonusInput();
        ValidationUtility.isValidBonus(winning, bonus);
    }

    private int getBonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = InputUtility.readLine(Type.BONUS.getValue());
        return Integer.parseInt(input);
    }


    public Lotto getWinning() {
        return winning;
    }

    public int getBonus() {
        return bonus;
    }
}
