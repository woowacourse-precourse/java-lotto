package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class UserInterface {

    public String getUserInput(String changeWord) {
        System.out.println(changeWord + "을 입력해 주세요.");
        return Console.readLine();
    }

    public void showAutoLottos(List<List<Integer>> autoLottos, int lottoCount) {
        System.out.println("\n"+lottoCount+"개를 구매했습니다.");
        for(List<Integer> autoLotto : autoLottos){
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(autoLotto.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
            sb.append("]");
            System.out.println(sb.toString());
        }
        System.out.println();
    }
}
