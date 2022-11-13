package lotto;

import java.util.List;

public class LottoController {
    private LottoService lottoService;
    private LottoStore lottoStore;

    public LottoController() {
        lottoService = new LottoService();
    }

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    /**
     * 구입금액을 입력받아 해당 구매 금액만큼 Lotto 를 구매하여 저장
     * @param inputAmount : 사용자 입력 구매금액 문자열
     * @return 구매한 Lotto 리스트
     */
    public List<Lotto> purchaseLotto(String inputAmount){
        int purchaseNumber = convertInputAmountToPurchaseNumber(inputAmount);
        List<Lotto> generatedLottos = lottoService.generateLottoList(purchaseNumber);
        lottoStore = new LottoStore(generatedLottos);

        return generatedLottos;
    }

    private int convertInputAmountToPurchaseNumber(String inputAmount){
        int purchaseAmount = Integer.parseInt(inputAmount);
        if (purchaseAmount<1000){
            throw new IllegalArgumentException("1개 이상 구매하야 합니다.");
        }
        if (purchaseAmount%1000 != 0){
            throw new IllegalArgumentException("입력금은 1000원 단위여야 합니다");
        }
        return purchaseAmount/1000;
    }
}
