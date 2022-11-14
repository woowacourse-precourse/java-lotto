package lotto.domain;

public class Buyer {
    int lottoAmount;

    static void validConsistByNumber(String inputValue){
        try {
            Integer.parseInt(inputValue);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
