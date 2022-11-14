package lotto;

public class Price {
    private String text;
    private int price = 0;

    public Price() {
        KeyboardInput k = new KeyboardInput();
        text = k.read();
//        if (!validate())
//            throw new IllegalArgumentException();
        price = Integer.parseInt(text);
    }

   
}
