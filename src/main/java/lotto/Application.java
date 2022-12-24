package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            new Service(1000,1,45,6);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
