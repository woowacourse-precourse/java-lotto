package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoPlayer lottoPlayer = new LottoPlayer();
            lottoPlayer.play();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}