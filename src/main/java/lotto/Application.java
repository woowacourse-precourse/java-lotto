package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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

    public static void RedundancyCheck(List<Integer> WinningNumber){
        Set<Integer> RedundancyCheckSet = new HashSet<>(WinningNumber);

        if(RedundancyCheckSet.size()!=WinningNumber.size()){
            Error("중복된 숫자가 존재해서는 안됩니다.");
        }
    }
    public static void RedundancyCheck(List<Integer> WinningNumber,int BonusNumber){
        for(int i : WinningNumber){
            if(i==BonusNumber){
                Error("중복된 숫자가 존재해서는 안됩니다.");
            }
        }
    }
    public static void RangeCheck(List<Integer> WinningNumber){
        for(int i = 0; i < WinningNumber.size(); i++){
            if(WinningNumber.get(i)>46||WinningNumber.get(i)<1){
                Error("당첨 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }
    public static void RangeCheck(int BonusNumber){
        if(BonusNumber>46||BonusNumber<1){
            Error("당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
    public static List<Integer> setWinningNumber(){
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요");
        String[] TempNumber = Console.readLine().split(",");

        List<Integer>WinningNumber = new ArrayList<>();

        for(String i : TempNumber){
            WinningNumber.add(Integer.parseInt(i));
        }
        RedundancyCheck(WinningNumber);
        RangeCheck(WinningNumber);
        Collections.sort(WinningNumber);
        return WinningNumber;
    }
    public static int setBonus(List<Integer> WinningNumber){
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int BonusNumbber;
        BonusNumbber = Integer.parseInt(Console.readLine());
        RangeCheck(BonusNumbber);
        RedundancyCheck(WinningNumber,BonusNumbber);
        return BonusNumbber;
    }
    public static List<Lotto> MakeGame(int NumberOfGame){
        List<Lotto> AllGame = new ArrayList<>();
        List<List<Integer>> GameNumberTemp= new ArrayList<>();

        for(int i = 0; i < NumberOfGame; i++){
            GameNumberTemp.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(GameNumberTemp.get(i));
            Lotto TempLotto = new Lotto((GameNumberTemp.get(i)));
            AllGame.add(TempLotto);
        }

        return AllGame;
    }
    public static void PrintAllGame(List<Lotto> AllGame){
        for(int i = 0; i < AllGame.size();i++){
            System.out.println(AllGame.get(i).NumberReturn());
        }
    }
    public static List<Integer> WinGameCheck(List<Lotto> AllGame,List<Integer> WinningNumber, int BonusNumber){
        List<Integer> Rank = new ArrayList<>();
        for(int i = 0; i < AllGame.size();i++){
            int Ranking =AllGame.get(i).Matching(WinningNumber,BonusNumber);
            Rank.add(Ranking,Rank.get(Ranking)+1);
        }
        return Rank;
    }
    
    public static void Game(){
        List<Lotto> AllGame = new ArrayList<>();
        Integer Amount = EnterAmount();
        int NumberOfGame = PrintPurchaseResult(Amount);
        AllGame = MakeGame(NumberOfGame);
        PrintAllGame(AllGame);
        List<Integer> Winning = setWinningNumber();
        int BonusNumber = setBonus(Winning);
        List<Integer> Rank= WinGameCheck(AllGame,Winning,BonusNumber);
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game();
    }
}
