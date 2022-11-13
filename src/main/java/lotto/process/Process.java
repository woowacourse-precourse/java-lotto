package lotto.process;

import lotto.domain.Result;
import lotto.domain.User;
import lotto.logic.LottoLogic;
import lotto.logic.UserLogic;
import lotto.screen.IOResolve;
import java.util.List;

public class Process {
    private static Process process = new Process();
    private LottoLogic lottoLogic;
    private UserLogic userLogic;

    private Process() {
    }

    public static Process getInstance() {
        return process;
    }

    public void setLottoLogic(LottoLogic lottoLogic) {
        this.lottoLogic = lottoLogic;
    }

    public void setUserLogic(UserLogic userLogic) {
        this.userLogic = userLogic;
    }

    public void compareNumbers(User user, List<Integer> winningNumbers, Integer bonusNumber) {
        user.getLottos().stream().forEach(lotto -> {
            Result result = lottoLogic.compareNumbers(lotto.getNumbers(), winningNumbers, bonusNumber);
            lottoLogic.addWinCount(result);
            Integer prize = lottoLogic.getPrize(result);
            user.increasePrize(prize);
        });
    }

    public Integer makeLottoNumbers(User user) {
        Integer lottoCount = user.getLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            user.addLotto(lottoLogic.makeLotto());
        }
        return lottoCount;
    }

    public String sumUp(User user) {
        List<Integer> history = lottoLogic.getHistory();
        return IOResolve.joinStrings(
                String.format("3개 일치 (5,000원) - %d 개\n", history.get(5)),
                String.format("4개 일치 (50,000원) - %d 개\n", history.get(4)),
                String.format("5개 일치 (1,500,000원) - %d 개\n", history.get(3)),
                String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d 개\n", history.get(2)),
                String.format("6개 일치 (2,000,000,000원) - %d 개\n", history.get(1)),
                String.format("총 수익률은 %.2f%%입니다.\n", user.getYield()));
    }

    public String lottoNumbers(User user) {
        String[] lottos = lottoLogic.getLottos(user).stream().map(lotto -> lotto + "\n").toArray(String[]::new);
        return IOResolve.joinStrings((String[]) lottos);
    }

    public User createUser(Integer money) {
        return userLogic.makeUser(money);
    }
}
