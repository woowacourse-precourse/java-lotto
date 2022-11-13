package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            ConsoleManager.runUI();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
