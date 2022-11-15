package lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputView {

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }


    public void printLottoTickets(List<Lotto> lottos){
        printEmptyLine();
        printMessage(String.format("%d개를 구매했습니다.",lottos.size()));
        lottos.forEach(
                lotto -> {
                    printMessage(lotto.getSortedLottoNumbers().toString());
                }
        );
    }


}
