package lotto;

public class LottoController {
    private final LottoView lottoView;

    private String tempInput;

    public LottoController(){
        this.lottoView = new LottoView();
    }

    public void run(){
        this.lottoView.printPurchaseAmountQuestion();
        this.tempInput = this.lottoView.getUserInput();

    }
}
