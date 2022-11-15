package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해주세요.");

        LottoAmount lottoAmount = new LottoAmount(readLine());

        System.out.printf("%d개를 구매했습니다.\n", lottoAmount.getAmount());


        List<Lotto> lottos = IntStream.range(0, lottoAmount.getAmount()).boxed()
                .map((i) -> new Lotto(new LottoCreate())).collect(Collectors.toList());

        lottos.forEach(Lotto::print);


        // 당첨 번호 입력 받기 ( include validation )
        System.out.println("당첨 번호를 입력해 주세요.");
        LottoWinningCreate lottoWinningCreate = new LottoWinningCreate(readLine());

        System.out.println("보너스 번호를 입력해 주세요.");
        lottoWinningCreate.setBonusNumber(readLine());
        LottoManager lottoManager = new LottoManager(lottoWinningCreate);

        // Lotto create

        System.out.println("당첨 통계");
        System.out.println("---");
        lottos.forEach(lottoManager::evaluate);
        lottoManager.print();

    }
}
