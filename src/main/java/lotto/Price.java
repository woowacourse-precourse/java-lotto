package lotto;

public class Price {
    private String text;
    private int price = 0;

    public Price() {
        text = inputPrice();
        if(!validate(text)) {
            System.out.println(ErrorMessage.PRICE.get());
            throw new IllegalArgumentException();
        }
        price = Integer.parseInt(text);
    }

    public int get() {
        return price;
    }

    private String inputPrice() {
        KeyboardInput k = new KeyboardInput();
        return k.read();
    }

    private boolean validate(String text){
        if (!isNumber(text))
            return false;
        if (!isPositiveNumber(text))
            return false;
        if (!isDividedBy1000(text))
            return false;
        return true;
    }

    private boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isPositiveNumber(String text) {
        int price = Integer.parseInt(text);
        if (price > 0)
            return true;
        return false;
    }

    private boolean isDividedBy1000(String text) {
        int price = Integer.parseInt(text);
        if ((price % 1000) == 0)
            return true;
        return false;
    }
}
