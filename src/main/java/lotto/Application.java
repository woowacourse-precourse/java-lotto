package lotto;

public class Application {
    public static void main(String[] args)  {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        try{
            controller.buyLotto();
            controller.inputNumber();
            controller.winningStatics();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
