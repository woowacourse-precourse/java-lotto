package lotto;

public class Application {
    public static void main(String[] args) {
        LottoView lottoView = new LottoView();
        try{
            lottoView.start();
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}