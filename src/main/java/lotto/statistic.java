package lotto;

import java.util.Arrays;
import java.util.List;


public class statistic {

  private int count;
  private int[] result = new int[5];
  public statistic(String normal_number, String bonus_number, List<List<Integer>> pick_member, String input_price) {
    System.out.println("\n당첨 통계\n---");
    String[] normal_number_table = normal_number.split(",");
    int[] new_normal_number_table = Arrays.asList(normal_number_table).stream().mapToInt(Integer::parseInt).toArray();
    int new_bonus_number = Integer.parseInt(bonus_number);
    victory_count(new_normal_number_table,new_bonus_number,pick_member);
    medal_result(result, input_price);
  }
  //각 줄의 숫자별 포함 개수
  private void victory_count(int[] new_normal_number_table, int new_bonus_number, List<List<Integer>> pick_member){
    for(List<Integer> line : pick_member){
      int cnt_normal_number = 0;
      int cnt_bonus_number = 0;
      if(line.contains(new_normal_number_table[0])) cnt_normal_number++;
      if(line.contains(new_normal_number_table[1])) cnt_normal_number++;
      if(line.contains(new_normal_number_table[2])) cnt_normal_number++;
      if(line.contains(new_normal_number_table[3])) cnt_normal_number++;
      if(line.contains(new_normal_number_table[4])) cnt_normal_number++;
      if(line.contains(new_normal_number_table[5])) cnt_normal_number++;
      if(line.contains(new_bonus_number)) cnt_bonus_number++;
      medal(cnt_normal_number, cnt_bonus_number);
    }
  }
  //각 줄별 당첨 수
  private void medal(int cnt_normal_number, int cnt_bonus_number){
    if(cnt_normal_number == 3) result[0]++;
    else if(cnt_normal_number == 4) result[1]++;
    else if(cnt_normal_number == 5 && cnt_bonus_number == 1) result[3]++;
    else if(cnt_normal_number == 5) result[2]++;
    else if(cnt_normal_number == 6) result[4]++;
  }
  //최종 통계 및 출력
  private void medal_result(int[] input_result, String ratio){
    double buy_money = Integer.parseInt((ratio));
    double total = 5000*input_result[0] + 50000*input_result[1] + 1500000*input_result[2] + 30000000*input_result[3] + 2000000000*input_result[4];
    System.out.println("3개 일치 (5,000원) - " + input_result[0] +"개");
    System.out.println("4개 일치 (50,000원) - " + input_result[1] +"개");
    System.out.println("5개 일치 (1,500,000원) - " + input_result[2] +"개");
    System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + input_result[3] +"개");
    System.out.println("6개 일치 (2,000,000,000원) - " + input_result[4] +"개");
    System.out.println("총 수익률은 " + total/buy_money*100 +"%입니다.");
  }
}
