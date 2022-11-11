package lotto;

public class Exception {
    public boolean initialInput(String input) throws IllegalArgumentException {
        if (onlyNumber(input)) return true;
        int inMoney = Integer.parseInt(input);
        if (onlyOneThousand(inMoney)) return true;
        System.out.println();
        return false;
    }

    private boolean onlyOneThousand(int inMoney) {
        try {
            if (inMoney % 1000 != 0) getTh();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private boolean onlyNumber(String temp) {
        for (int i = 0; i < temp.length(); i++) {
            try {
                if (temp.charAt(i) < '0' || temp.charAt(i) > '9') getNum();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }

    public boolean inputWinningBonus(String input) {
        if (onlyNumberBonus(input)) return true;
        int bonus = Integer.parseInt(input);
        if (onlyRangeBonus(bonus)) return true;
        System.out.println();
        return false;
    }

    private boolean onlyRangeBonus(int bonus) {
        try {
            if (bonus < 1 || bonus > 45) getRan();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    private boolean onlyNumberBonus(String input) {
        for (int i = 0; i < input.length(); i++) {
            try {
                if (input.charAt(i) < '0' || input.charAt(i) > '9') getNum();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return true;
            }
        }
        return false;
    }

    private void getNum() {
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
    }

    private void getTh() {
        throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
    }

    private void getRan() {
        throw new IllegalArgumentException("[ERROR] 1에서 45 사이의 숫자를 입력해주세요.");
    }
}
