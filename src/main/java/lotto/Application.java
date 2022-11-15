package lotto;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        try{
        lottoMachine.run();
        }
        catch (IllegalArgumentException E){
            System.out.println(E.getMessage());
        }
    }
}
