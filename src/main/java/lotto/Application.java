package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoUI lottoProgram = new LottoUI(new Manager());

        try {
            lottoProgram.setPurchasePrice();
            lottoProgram.publishLottos();

            lottoProgram.setLottoNumber();
            lottoProgram.setBonusNumber();

            lottoProgram.getLottoResult();
        } catch (IllegalArgumentException e){
            return;
        }
    }
}
