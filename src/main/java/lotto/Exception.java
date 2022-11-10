package lotto;

public class Exception {
    public int initialInput(String input) {
        onlyNumber(input);
        int inMoney = Integer.parseInt(input);
        onlyOneThousand(inMoney);
        System.out.println();
        return inMoney;
    }

    private void onlyOneThousand(int inMoney) {
        if (inMoney % 1000 != 0) {
            System.out.println("[ERROR] 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private static void onlyNumber(String temp) {
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) < '0' || temp.charAt(i) > '9') {
                System.out.println("[ERROR] 숫자만 입력해주세요");
                throw new IllegalArgumentException();
            }
        }
    }

    public int inputWinningBonus(String input) {
        onlyNumberBonus(input);
        int bonus = Integer.parseInt(input);
        onlyRangeBonus(bonus);
        System.out.println();
        return bonus;
    }

    private void onlyRangeBonus(int bonus) {
        if (bonus < 1 || bonus > 45) {
            System.out.println("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private void onlyNumberBonus(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                System.out.println("[ERROR] 숫자만 입력해주세요.");
                throw new IllegalArgumentException();
            }
        }
    }
}
