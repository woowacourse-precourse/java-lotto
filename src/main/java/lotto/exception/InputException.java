package lotto.exception;

public class InputException {
    public static int inputMoneyException(String input) throws IllegalArgumentException {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에 특수문자는 입력 불가능합니다.");
        }
        if (input.length() > 9) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에 1,000,000,000 미만의 숫자만 입력 가능합니다.");
        }
        int money = Integer.parseInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력받을 수 있습니다.");
        }
        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에 음수는 입력이 불가능합니다.");
        }
        return money;
    }

    public static int bonusException(String input) throws IllegalArgumentException {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }

        int bonus = Integer.parseInt(input);
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonus;
    }

    public static void lottoNumberException(String input) throws IllegalArgumentException {
        if (!input.matches("^[0-9]*$") && !input.matches(",") ){
            throw new IllegalArgumentException("[ERROR] ,외의 특수문자는 입력 불가능합니다.");
        }
        if (input.matches("")){
            throw new IllegalArgumentException("[ERROR] 공백은 입력 불가능합니다.");
        }
    }
}
