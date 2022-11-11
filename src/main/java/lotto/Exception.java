package lotto;

public class Exception {
    protected static void validatePayMoney(long payMoney) {
        if (payMoney % 1000 != 0) {
            System.out.println("[ERROR] 구입금액은 1,000 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    protected static void validateBonusBall(int bonus, Lotto lotto) {
        if (lotto.getNumbers().contains(bonus)) {
            System.out.println("[ERROR] 보너스 번호는 로또 번호와 중복되면 안됩니다.");
            throw new IllegalArgumentException();
        }

        if (bonus < 0 || bonus > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
