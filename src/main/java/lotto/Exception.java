package lotto;

import java.util.Objects;

public class Exception {
    public void initialInput(String input) throws IllegalArgumentException {
        if (onlyNumber(input)) throw new IllegalArgumentException();
        int inMoney = Integer.parseInt(input);
        if (onlyOneThousand(inMoney)) throw new IllegalArgumentException();
        System.out.println();
    }

    public boolean onlyOneThousand(int inMoney) {
        try {
            if (!Objects.equals(inMoney%1000,0)) onlyUnit();
            else if (Objects.equals(inMoney,0)) onlyUnit();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public boolean onlyNumber(String temp) {
        for (int i = 0; i < temp.length(); i++) {
            try {
                if (temp.charAt(i) < '0' || temp.charAt(i) > '9') onlyNum();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }

    public void inputWinningBonus(String input) {
        if (onlyNumberBonus(input)) throw new IllegalArgumentException();
        int bonus = Integer.parseInt(input);
        if (onlyRangeBonus(bonus)) throw new IllegalArgumentException();
        System.out.println();
    }

    public boolean onlyRangeBonus(int bonus) {
        try {
            if (bonus < 1 || bonus > 45) onlyRange();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    public boolean onlyNumberBonus(String input) {
        for (int i = 0; i < input.length(); i++) {
            try {
                if (input.charAt(i) < '0' || input.charAt(i) > '9') onlyNum();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }

    private void onlyNum() {
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
    }

    private void onlyUnit() {
        throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
    }

    private void onlyRange() {
        throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해주세요.");
    }
}
