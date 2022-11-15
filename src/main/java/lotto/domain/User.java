package lotto.domain;

public class User {
    private static final String regex = "^\\d+$";

    public User() {
    }

    public void buyLotto(String price) {
        validate(price);
    }

    private void validate(String price) {
        if (!price.matches(regex)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(price) % 10 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
