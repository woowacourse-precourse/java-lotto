package lotto.domain;

public class Money {
    private int money;

    public boolean validate(String input) {
        if (!validateNull(input) || !validateAllDigit(input) || !validateDividedByThousand(input)) {
            return false;
        }
        return true;
    }

    public void createMoney(String input) {
        this.money = Integer.parseInt(input);
    }

    private boolean validateNull(String input) {
        try {
            if (input.equals("") || input == null) {
                throw (new IllegalArgumentException());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            return false;
        }
        return true;
    }

    private boolean validateAllDigit(String input) {
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (!validateIsDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateIsDigit(char c) {
        try {
            if (!Character.isDigit(c)) {
                throw (new IllegalArgumentException("[ERROR]오류"));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            return false;
        }
        return true;
    }

    private boolean validateDividedByThousand(String input) {
        int number = Integer.parseInt(input);

        try {
            if ((number == 0) || ((number % 1000) != 0)) {
                throw (new IllegalArgumentException());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 금액은 1000원으로 나뉘어야 합니다.");
            return false;
        }
       return true;
    }

    public int getMoney() {
        return money;
    }
}