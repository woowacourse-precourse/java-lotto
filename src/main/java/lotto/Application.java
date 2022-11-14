package lotto;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR]";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Control control = new Control();
            control.play();
        } catch (IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + e);
        }

    }
}
