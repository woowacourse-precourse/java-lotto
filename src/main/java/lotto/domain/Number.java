package lotto.domain;

public class Number {
    private final int lottoNumber;

    public Number(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Number(String input) {
        this.lottoNumber = validateNumber(input);
    }

    private int validateNumber(String input) {
        int lottoNumber = convertToInt(input);
        if (1 > lottoNumber || lottoNumber > 45) {
            throw new IllegalArgumentException();
        }

        return lottoNumber;
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (RuntimeException ex) {
            throw new IllegalArgumentException();
        }
    }

}
