package lotto;

public class Price {
    private String text;
    private int price = 0;

    public Price() {
        KeyboardInput k = new KeyboardInput();
        text = k.read();
        if (!validate())
            throw new IllegalArgumentException();
        price = Integer.parseInt(text);
    }

    private boolean validate() {
        if (!isNumber())
            return false;

        if (!isPositiveNumber())
            return false;

        return true;
    }

    private boolean isNumber() {
        try {
            Integer.parseInt(text);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isPositiveNumber() {
        int price = Integer.parseInt(text);
        if (price > 0)
            return true;
        return false;
    }
}
