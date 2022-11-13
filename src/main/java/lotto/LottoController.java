package lotto;

import java.util.ArrayList;
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

    /**
     * 문자열을 파싱하여 당첨 번호를 설정한다.
     * @param inputWinningNumbers : 숫자와 쉼표로 구성된 문자열
     */
    public void setWinningNumbers(String inputWinningNumbers){
        List<Integer> winningNumbers = convertInputWinningNumbers(inputWinningNumbers);
        lottoService.setWinningNumbers(winningNumbers);
    }

    private List<Integer> convertInputWinningNumbers(String inputWinningNumbers){
        List<Integer> result = new ArrayList<>();
        String[] splitInputs = inputWinningNumbers.split(",");
        if (splitInputs.length != 6){
            throw new IllegalArgumentException("당첨 번호는 6자리여야 합니다");
        }
        for (String splitInput : splitInputs){
            int winningNumber = convertInputNumber(splitInput);
            result.add(winningNumber);
        }
        return result;
    }

    private int convertInputNumber(String inputNumber){
        int number = Integer.parseInt(inputNumber);
        if (number < 1 || number > 45){
            throw new IllegalArgumentException("당첨 번호는 1에서 45 사이어야 합니다");
        }
        return number;
    }

    /**
     * 문자열을 파싱하여 보너스 번호를 설정한다.
     * @param inputBonusNumber : 숫자로 구성된 문자열
     */
    public void setBonusNumber(String inputBonusNumber){
        int bonusNumber = convertInputNumber(inputBonusNumber);
        lottoService.setBonusNumber(bonusNumber);
    }

    /**
     * Lotto 게임의 당첨 결과 리스트를 반환한다.
     * @return 5등부터 1등까지 당첨 개수가 포함된 리스트
     */
    public List<Integer> getLottoRankResults(){
        List<Lotto> lottos = lottoStore.getLottos();
        return lottoService.getLottoRankResultsByLottos(lottos);
    }

    /**
     * Lotto 게임의 수익률을 반환한다.
     * @return 백분율로 계산된 로또 수익률
     */
    public double getLottoYield(){
        List<Integer> lottoRankResults = getLottoRankResults();
        double lottoYield = lottoStore.calculateLottoYield(lottoRankResults);
        return lottoYield * 100;
    }
}
