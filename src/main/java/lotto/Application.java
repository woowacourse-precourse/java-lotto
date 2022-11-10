package lotto;

public class Application {
    public static void main(String[] args) {
        InputUtil inputUtil = new InputUtil();
        Lotto lotto = new Lotto(inputUtil.listNumber());
        System.out.println(lotto);
    }
}
