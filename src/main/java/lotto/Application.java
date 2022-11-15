package lotto;

public class Application {
    public static void main(String[] args) {
        Operator operator = new Operator();
        try {
            operator.purchaseLotto();
            operator.notifyResult(operator.checkLotto());
        }catch (IllegalArgumentException e){
            System.out.println(e.toString());
        }
    }
}
