package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class User {
    public static final int LOTTO_LENGTH = 6;

    private int publicans;
    protected List<Integer> userNumbers;

    public User() {
        System.out.println("구입금액을 입력해 주세요.");
        int budget = Integer.parseInt(Console.readLine());
        if (budget % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000원 단위입니다!");
        }
        this.publicans = budget / 1000;
    }

    public void getNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        String[] num = numbers.split(",");
        validate(num);
        System.out.println(num.length);
    }

    public void validate(String[] num) {
        lengthValidate(num);
        for (int i = 0; i < num.length; i++) {
            isDigitValidate(Integer.parseInt(num[i]));
            rangeValidate(Integer.parseInt(num[i]));
        }
    }

    public void lengthValidate(String[] num) {
        if (num.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요!");
        }
    }

    public void isDigitValidate(int num) {

        if (!String.valueOf(num).matches("[-+]?\\d*\\.?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요!");
        }

    }

    public void rangeValidate(int num) {
        if (num > 45 || num < 1) {
            throw new IllegalArgumentException("[ERROR] 1~45사이의 숫자를 입력해주세요!");
        }

    }

    public int getPublicans() {
        return publicans;
    }

}
