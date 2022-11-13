package lotto.domain;

import java.util.List;

public class Controller {
    private final Input input = new Input();
    private final Output output = new Output();

    public void generate() {
        try {
            //로또 구입하기
            int money = input.getMoney();
            UserLottos userLottos = new UserLottos(money);
            output.printUserLottos(userLottos);

            //당첨 로또 넣기
            WinningLotto winningLotto = getWinningLotto();

            //결과 출력하기
            LottoResult lottoResult = new LottoResult(money, userLottos, winningLotto);
            output.printResult(lottoResult);

        } catch (IllegalArgumentException e) {
            output.printErrorMessage();
        }
    }


    public WinningLotto getWinningLotto() {
        List<Integer> winningNumbers = input.getWinningNumbers();
        int bonusNumber = input.getBonusNumbers();

        return new WinningLotto(winningNumbers, bonusNumber);
    }


}
