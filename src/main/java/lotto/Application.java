package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("구입금액을 입력해주세요.");
        Integer purchaseAmount = Integer.parseInt(readLine());

        LottoAmount lottoAmount = new LottoAmount(purchaseAmount);

        System.out.printf("%d개를 구매했습니다.\n", lottoAmount.getAmount());


        ArrayList<Lotto> lottos = IntStream.range(0, lottoAmount.getAmount()).map(i -> new Lotto(new LottoCreate())).collect(Collectors.toList());

        lottos.forEach(print());



        // 당첨 번호 입력 받기 ( include validation )

        LottoWinningCreate lottoWinningCreate = new LottoWinningCreate(readLine());
        LottoManager lottoManager = new LottoManager(lottoWinningCreate);

        // Lotto create

        System.out.println("당첨 통계");
        System.out.println("---");
        List<Integer> results = lottos.stream().map(lotto -> lottoManager.evaluate(lotto)).collect(Collectors.toList());
        double earningRate = (double)results.stream().reduce(0, Integer::sum)/purchaseAmount;

        System.out.println("총 수익률은 "+earningRate+"%입니다.");


    }
}
