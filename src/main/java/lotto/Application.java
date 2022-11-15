package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void Error(String ErrorType){
        throw new IllegalArgumentException("[ERROR] " + ErrorType);
    }
    public static Integer EnterAmount(){
        System.out.println("구입금액을 입력해 주세요.");

        Integer Amount;
        Amount = Integer.parseInt(Console.readLine());
        if(Amount%1000!=0){
            Error("구입금액은 1000의 배수여야 합니다.");
        }
        return Amount;
    }
    public static int PrintPurchaseResult(int Amount){
        int NumberOfGame = Amount/1000;
        System.out.println();
        System.out.println(NumberOfGame + "개를 구매했습니다.");
        return NumberOfGame;
    }
    public static List<Integer> setWinningNumber(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");

        String[] TempNumber = Console.readLine().split(",");

        List<Integer>WinningNumber = new ArrayList<>();

        for(String i : TempNumber){
            WinningNumber.add(Integer.parseInt(i));
        }
        return WinningNumber;
    }
    public static List<Lotto> MakeGame(int NumberOfGame){
        List<Lotto> AllGame = new ArrayList<>();
        List<List<Integer>> GameNumberTemp= new ArrayList<>();

        for(int i = 0; i < NumberOfGame; i++){
            GameNumberTemp.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Lotto TempLotto = new Lotto(GameNumberTemp.get(i));
            AllGame.add(TempLotto);
        }

        return AllGame;
    }
    public static void Game(){
        PrintPurchaseResult(EnterAmount());
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game();
    }
}
