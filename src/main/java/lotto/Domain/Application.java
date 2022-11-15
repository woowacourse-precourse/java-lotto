package lotto.Domain;
public class Application {
    public static void main(String[] args) {
        try {
            LottoController.getInstance().run();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}