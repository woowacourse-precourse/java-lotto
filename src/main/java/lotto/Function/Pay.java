package lotto.Function;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class Pay {
    private String cash;

    public Pay(String cash) {
        cashChanger(cash);
        validateCash(cash);
        this.cash = cash;
    }

    private void validateCash(String cash) {
        if (0 < (Integer.parseInt(cash) % 1000)) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000원 단위만 입력가능합니다.");
                throw new NoSuchElementException();
            }
        }
    }

    public void cashChanger(String cash) {
        for (int i = 0; i < cash.length(); i++) {
            int n = cash.charAt(i);
            if (57 < n || n < 48) {
                cash.replaceAll("^[\\d]", "");
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.out.println("[ERROR] 숫자만 입력이 가능합니다.");
                    throw new NoSuchElementException();
                }
            }
        }
    }

    public int makeBuyNum() {
        int result = Integer.parseInt(cash) / 1000;
        return result;
    }
}
