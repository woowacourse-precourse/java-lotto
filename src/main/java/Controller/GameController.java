package Controller;

import Service.LottoService;
import Service.View;
import Utils.utils;
import domain.Game;

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
        print_purchasedLottoNumber();
        LottoService.lottoSpawner(getLottoCount());
        LottoService.printLottoNumbers();
        read_WinningNumbers();
        setWinning_numbers(utils.change_StringToInt(winningNumbers_Input));
        read_bonusNumber();
        print_Message_Winning_Stastistics();
        mainController.setGrades();
        mainController.grade_count();
        print_Stactistics();
        mainController.set_totalGain();
        print_totalGain();

    }

}
