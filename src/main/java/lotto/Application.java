package lotto;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        try {
            user.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // TODO: 프로그램 구현
    }
}
