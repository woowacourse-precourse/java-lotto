package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class statistic {
  private final String normal_number;
  private final String bonus_number;
  private final String input_price;
  private final List<List<Integer>> pick_member;
  private int[] result = new int[5];
  public statistic(String normal_number, String bonus_number, List<List<Integer>> pick_member, String input_price) {
    this.normal_number = normal_number;
    this.bonus_number = bonus_number;
    this.pick_member = pick_member;
    this.input_price = input_price;
    //
    System.out.println("\n당첨 통계\n---");
    //
    String[] normal_number_table = normal_number.split(",");
    List<Integer> new_normal_number_table = Arrays.stream(normal_number_table).map(Integer::parseInt).collect(Collectors.toList());
    int new_bonus_number = Integer.parseInt(bonus_number);
    //
    victory_count(new_normal_number_table, new_bonus_number,pick_member);
    medal_result(result, input_price);
  }
  //당첨 수 확인
  private void victory_count(List<Integer> new_normal_number_table, int new_bonus_number, List<List<Integer>> pick_member){
    for(List<Integer> line : pick_member){
      int dang_chum = intersection(line, new_normal_number_table).size();
      if(dang_chum == 6) result[4]++;
      if(line.contains(new_bonus_number) && dang_chum == 5) result[3]++;
      if(dang_chum >= 3) result[dang_chum - 3]++;
    }
  }
  //교집합
  private List<Integer> intersection(List<Integer> left_side, List<Integer> right_side){
    List<Integer> result = new ArrayList<>();
    result.addAll(left_side);
    result.retainAll(right_side);
    return result;
  }
  //최종 통계 및 출력
  private void medal_result(int[] input_result, String ratio){
    double buy_money = Integer.parseInt((ratio));
    double total = 5000*input_result[0] + 50000*input_result[1] + 1500000*input_result[2] + 30000000*input_result[3] + 2000000000*input_result[4];
    //
    System.out.println("3개 일치 (5,000원) - " + input_result[0] +"개");
    System.out.println("4개 일치 (50,000원) - " + input_result[1] +"개");
    System.out.println("5개 일치 (1,500,000원) - " + input_result[2] +"개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + input_result[3] +"개");
    System.out.println("6개 일치 (2,000,000,000원) - " + input_result[4] +"개");
    System.out.println("총 수익률은 " + total/buy_money*100 +"%입니다.");
  }
}
