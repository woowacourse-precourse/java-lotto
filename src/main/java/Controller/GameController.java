package Controller;

import Service.LottoService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static Service.View.*;
import static domain.Game.getLottoCount;
import static domain.Game.winning_numbers;

public class GameController {

    public static void start() {
        read_buyingLottoAmount();
        System.out.print(getLottoCount() + "개를 구매했습니다.");
        LottoService.lottoSpawner(getLottoCount());
        LottoService.printLottoNumbers();
        changeToInt(read_WinningNumbers());
        read_bonusNumber();
        System.out.println("당첨 통계");
        mainController.setGrades();
        mainController.grade_count();
        mainController.print_Stactistics();

    }
    public static void changeToInt(String numbers) {
        String[] str = numbers.split(",");
        List<String> number = List.of(str);
        List<Integer> newforms = number.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Collections.sort(newforms);
        winning_numbers = newforms;
    }

    public static List<Integer> ascendingSort(List<Integer> numbers) {

        Collections.sort(numbers);

        return numbers;
    }
    public static List<Integer> getWinning_numbers(){
        return winning_numbers;
    }
}
