package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 총 6개 입니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()){
            System.out.println("[ERROR] 중복되는 값이 존재 합니다.");
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < numbers.size(); i++){
            if((numbers.get(i) > 45) || (numbers.get(i) < 1)){
                System.out.println("[ERROR] 당첨 번호에 1 ~ 45 사잇값이 아닌 수가 존재합니다.");
                throw new IllegalArgumentException();
            }
        }
    }
    public int[][] GET_MATCHES(int Cnt_Match, int[][] Match, int Match_Bonus){
        if(Cnt_Match == 3) {Match[3][0] += 1;}
        if(Cnt_Match == 4) {Match[4][0] += 1;}
        if(Cnt_Match == 5) {
            if(Match_Bonus == 0){
                Match[5][0] += 1;
            }
            Match[0][0] += Match_Bonus;
        }
        if(Cnt_Match == 6) {Match[6][0] += 1;}
        return Match;
    }
    public float GET_YIELD(int[][] Match, int Amount){
        float result_v = 0;
        for (int i = 0; i < Match.length; i++){
            result_v += Match[i][0] * Match[i][1];
        }
        float result = (result_v * 100)/ Amount;
        return result;
    }
    public ArrayList<String> GET_WINNER_STR(int[][] Match, int Amount){
        ArrayList<String> result = new ArrayList<>();
        result.add(String.format("3개 일치 (5,000원) - %d개", Match[3][0]));
        result.add(String.format("4개 일치 (50,000원) - %d개", Match[4][0]));
        result.add(String.format("5개 일치 (1,500,000원) - %d개", Match[5][0]));
        result.add(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", Match[0][0]));
        result.add(String.format("6개 일치 (2,000,000,000원) - %d개", Match[6][0]));
        result.add(String.format("총 수익률은 %.1f%s입니다.", GET_YIELD(Match, Amount), "%"));
        return result;
    }

    // TODO: 추가 기능 구현

    public int[][] CHECK_WINNER_SUB(int Bonus, List<Integer> One_Lotto, int[][] Match) {
        int Match_Bonus = 0;
        int Cnt_Match = 0;
        for (int i = 0; i < One_Lotto.size(); i++) {
            if(numbers.contains(One_Lotto.get(i))){
                Cnt_Match += 1;
            }
        }
        if(One_Lotto.contains(Bonus)){
            Match_Bonus += 1;
        }
        Match = GET_MATCHES(Cnt_Match, Match, Match_Bonus);
        return Match;
    }

    public ArrayList<String> CHECK_WINNER(int Bonus, ArrayList<List<Integer>> My_Lotto_Number, int Amount){
        int[][] Match = {{0, 30000000},{0, 0},{0, 0},{0, 5000},{0, 50000},{0, 1500000},{0, 2000000000}};
        int Cnt_Match = 0;
        for (int i = 0; i < My_Lotto_Number.size(); i++){
            Match = CHECK_WINNER_SUB(Bonus, My_Lotto_Number.get(i), Match);
        }
        ArrayList<String> result = GET_WINNER_STR(Match, Amount);
        return result;
    }
    public void VALIDATE_BONUS_NO(int Input){
        if((Input > 45) || (Input < 1)){
            System.out.println("[ERROR] 보너스 번호가 1 ~ 45 사잇값이 아닙니다.");
            throw new IllegalArgumentException();
        }
        if(numbers.contains(Input)){
            System.out.println("[ERROR] 보너스 번호가 로또 번호에 포함되어 있습니다.");
            throw new IllegalArgumentException();
        }
    }
}
