package Controller;

import Service.LottoService;
import Service.View;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static Controller.mainController.get_stactiscs;
import static Controller.mainController.print_gain;
import static Service.View.*;
import static domain.Game.*;

public class GameController {
    public static final boolean NOT_NUMBER_INPUT = true;
    public static boolean INPUT;

    public static void start() {
        INPUT = read_buyingLottoAmount();
        if (INPUT == NOT_NUMBER_INPUT) return;
        print_LottoNumber();
        LottoService.lottoSpawner(getLottoCount());
        LottoService.printLottoNumbers();
        changeToInt(read_WinningNumbers());
        read_bonusNumber();
        print_Message_Stastistics();
        mainController.setGrades();
        mainController.grade_count();
        print_Stactistics();
        mainController.set_totalGain();
        print_totalGain();

    }

    public static void changeToInt(String numbers) {
        String[] str = numbers.split(",");
        List<String> number = List.of(str);
        List<Integer> newforms = number.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        Collections.sort(newforms);
        winning_numbers = newforms;
    }

    public static List<Integer> getWinning_numbers() {
        return winning_numbers;
    }


}
