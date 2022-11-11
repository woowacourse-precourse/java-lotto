package lotto;

public class Application {

    public static void main(String[] args) {
        try {
            // TODO: 프로그램 구현
            UserInput.getAllInput();
        } catch (IllegalArgumentException msg) {
            System.out.println(msg);
        }

    }


}

