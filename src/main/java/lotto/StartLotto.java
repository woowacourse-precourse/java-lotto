package lotto;

public class StartLotto {
    Input input = new Input();
    MakeLotto makeLotto = new MakeLotto();
    Check check = new Check();

    private int purchasedValue;
    private int lottoCount;
    private int[][] lottoArray = new int[lottoCount][6];
    private int[] userInputLottoNumber = new int[6];
    private int userInputBonusNumber;

    public void startLotto(){
        this.purchasedValue = input.buyLotto();
        this.lottoCount = input.checkHowManyLotto(purchasedValue);
        makeLotto.makeLottoNumber(lottoArray, lottoCount);
        input.userInputLottoNumber(userInputLottoNumber, userInputBonusNumber);
        check.numberCompare(lottoCount, lottoArray, userInputLottoNumber, userInputBonusNumber, purchasedValue);
    }
}
