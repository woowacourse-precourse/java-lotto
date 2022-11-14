package lotto;

public class Application {
    public static void main(String[] args) {
        LottoProgram lottoProgram = new LottoProgram();

        try {
            lottoProgram.makeUserLotto();
            lottoProgram.makeWinningLotto();
            lottoProgram.makeProfitsStatistics();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
