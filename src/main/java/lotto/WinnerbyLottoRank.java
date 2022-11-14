package lotto;
import java.util.function.Supplier;

public enum WinnerbyLottoRank {
    THREE( () -> 5000,( ) -> "3"),
    FOUR(() ->50_000, ( ) -> "4"),
    FIVE(() ->1_500_000,( ) -> "5"),
    BONUS(() ->30_000_000, ( ) -> "5"),
    SIX(() ->2_000_000_000, ( ) -> "6");
    private Supplier<Integer> prize;
    private Supplier<String> grade;

    WinnerbyLottoRank(Supplier<Integer> prize, Supplier<String> grade ) {
        this.grade = grade;
        this.prize= prize;
    }
    public int prizeValue(){
        return prize.get();
    }
    public void printWinnerbyLottoRank(int prizeLottoNumber){
        System.out.print(grade.get()+"개 일치");
        if(prize.get().equals(30_000_000)){
            System.out.print(", 보너스 볼 일치");
        }
        System.out.print(" ("+String.format("%,d", prize.get())+"원) - ");
        System.out.printf("%d개%n",prizeLottoNumber);
    }
}
