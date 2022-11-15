import controller.LottoController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController();
        try{
            lottoController.run();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
