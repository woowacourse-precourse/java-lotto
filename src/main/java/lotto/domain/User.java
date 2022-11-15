package lotto.domain;

public class User {
    private static int lottoCnt;
    private static final String regex = "^\\d+$";

    public User() {
    }

    public void buyLotto(String price) {
        validate(price);
        lottoCnt = calculateLottoCnt(price);
    }

    private void validate(String price) {
        if (!price.matches(regex)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(price) % 10 != 0) {
            throw new IllegalArgumentException();
        }
    }
    
    private int calculateLottoCnt(String price) {
        return Integer.parseInt(price) / 1000;
    }

    public int getLottoCnt() {
        return lottoCnt;
    }
}
