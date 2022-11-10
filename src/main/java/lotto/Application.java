package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Consumer user = new Consumer();

        try {
            Lotto lotto = new Lotto(user.winningNumber());
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s\n",e.getMessage());
        }
    }
}
