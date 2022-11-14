package lotto;

public class StartLotto {
    Input input = new Input();
    MakeLotto makeLotto = new MakeLotto();
    Check check = new Check();

    private int purchasedValue;
    private int lottoCount;
    private Lotto[] lottoArray;
    private Lotto userInputLottoNumber;
    private int userInputBonusNumber;

    public void startLotto(){
        this.purchasedValue = input.buyLotto();
        this.lottoCount = input.checkHowManyLotto(purchasedValue);
        lottoArray = new Lotto[lottoCount];
        makeLotto.makeLottoNumber(lottoArray, lottoCount);
        userInputLottoNumber = input.userInputLottoNumber();
        userInputBonusNumber = input.getUserInputBonusNumber();
        check.numberCompare(lottoCount, lottoArray, userInputLottoNumber, userInputBonusNumber, purchasedValue);
    }
}
