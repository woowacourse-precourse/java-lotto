package lotto;

public class Application {
    public static void main(String[] args) {
       DoLotto doLotto = new DoLotto();
       try {
           doLotto.startLotto();
       }
       catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
       }
    }
}
