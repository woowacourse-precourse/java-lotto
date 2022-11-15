package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            Ui ui= new Ui();
            ui.startLotto();
        }catch (Exception e){
            System.out.println("[ERROR]");
        }
    }
}
