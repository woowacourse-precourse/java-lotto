package lotto;

public class Price {
    private final int price;

    public Price(String price) {
        if(!validate(price)) {
            System.out.println(ErrorMessage.PRICE.get());
            throw new IllegalArgumentException();
        }
        this.price = Integer.parseInt(price);
    }

    public int get() {
        return price;
    }

    private boolean validate(String price){
        if (!isNumber(price))
            return false;
        if (!isPositiveNumber(price))
            return false;
        if (!isDividedBy1000(price))
            return false;
        return true;
    }

    private boolean isNumber(String price) {
        try {
            Integer.parseInt(price);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isPositiveNumber(String price) {
        if (Integer.parseInt(price) > 0)
            return true;
        return false;
    }

    private boolean isDividedBy1000(String price) {
        if ((Integer.parseInt(price) % 1000) == 0)
            return true;
        return false;
    }
}
