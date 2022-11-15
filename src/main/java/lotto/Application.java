package lotto;

public class Application {
    public static void main(String[] args) {

        try {
            LottoSystem.proceedSystem();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
