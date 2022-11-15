package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Controller {
    final private Service service = new Service();
    private String command;
    private int lottoCount, bonusNumber;
    private List<Lotto> lottos;
    private List<Integer> winNumbers;

    public void startLotto() {
        enterMoney();
        enterWinNumbers();
        getResult();
    }

    private void enterMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        command = camp.nextstep.edu.missionutils.Console.readLine();

        lottoCount = service.getLottoCount(command);
        System.out.println(lottoCount + "개를 구매했습니다.");

        lottos = service.buyLotto(lottoCount);
        for (Lotto lotto : lottos) {
            lotto.print();
        }
    }

    private void enterWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        command = Console.readLine();
        winNumbers = service.getWinNumbers(command);

        System.out.println("보너스 번호를 입력해 주세요.");
        command = Console.readLine();
        bonusNumber = service.getLottoNumber(command);
    }

    private void getResult() {
        System.out.println("당첨 통계\n---");
        System.out.println(service.getStatText(lottos, winNumbers, bonusNumber));
    }
}
