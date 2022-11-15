package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoUI lottoProgram = new LottoUI(new Manager());

        lottoProgram.setPurchasePrice();
        lottoProgram.publishLottos();

        lottoProgram.getLottoNumber();
        lottoProgram.setBonusNumber();

        lottoProgram.getLottoResult();
    }
}
