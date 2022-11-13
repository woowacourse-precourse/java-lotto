package lotto.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class LottoConsole {

    public LottoConsole(){ }

    public static String userInput() {
        return readLine();
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println("[ERROR]: " + errorMessage);
    }

    public static void printLottoResult(List<Integer> lottoNumbers){
        System.out.println(lottoNumbers);
    }

}
