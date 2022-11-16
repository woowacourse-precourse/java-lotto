package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            new Shop().sellLottos();
        } catch (IllegalArgumentException e) {
            return;
        }
    }
}
