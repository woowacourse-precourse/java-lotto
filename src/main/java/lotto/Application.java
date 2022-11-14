package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            new Service();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
