package view;

import domain.Lotto;

import java.util.List;
import java.util.Objects;

public class OutputView {
    public static void showLottos(List <Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매하셨습니다.");

        lottos.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }
}
