package lotto;

public class LottoProgram {
    private User user;
    private LottoGenerator lottoGenerator;
    private LotteryResult lotteryResult;
    private int lottoCount;

    public LottoProgram() {
        this.user = new User();
        this.lottoGenerator = new LottoGenerator(lottoCount);
        this.lotteryResult = new LotteryResult();
    }

    public void start() {
        lottoCount = user.inputPrice();
        generateLotto();
        inputLottoNumbers();
        printResult();
    }

    public void generateLotto() {
        LottoGenerator lottoGenerator = new LottoGenerator(lottoCount);
        lottoGenerator.publishLotto();
        lottoGenerator.printLotto();
    }

    public void inputLottoNumbers() {
        user.inputWinningNumbers();
        user.inputBonusNumbers();
    }

    public void printResult() {
//        for(Lotto lotto : lottoGenerator.userLotto) {
//            result.add(lotto.calcResult(user.inputLottoNumbers(), user.inputBonusNumbers()));
//        }
    }
}
