package lotto;

import java.util.EnumMap;

enum grade {
    first, second, third, forth, fifth
}
public class WinningGrade {
    public EnumMap enumMapinit(){
        EnumMap emap = new EnumMap(grade.class);

        emap.put(grade.first, 0);
        emap.put(grade.second, 0);
        emap.put(grade.third, 0);
        emap.put(grade.forth, 0);
        emap.put(grade.fifth, 0);

        return emap;
    }

    public EnumMap inputGrade(EnumMap emap, int count, boolean bonus){

        if (count == 6){
            emap.put(grade.first, ((int) emap.get(grade.first)) + 1);
        }
        if (count == 5 && (bonus == true)){
            emap.put(grade.second, ((int) emap.get(grade.second)) + 1);
        }
        if (count == 5 && (bonus == false)){
            emap.put(grade.third, ((int) emap.get(grade.third)) + 1);
        }
        if (count == 4){
            emap.put(grade.forth, ((int) emap.get(grade.forth)) + 1);
        }
        if (count == 3){
            emap.put(grade.fifth, ((int) emap.get(grade.fifth)) + 1);
        }
        return (emap);
    }

    public void printGrade(EnumMap emap, int count){
        System.out.println("3개 일치 (5,000원) - " + emap.get(grade.fifth) + "개");
        System.out.println("4개 일치 (50,000원) - " + emap.get(grade.forth) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + emap.get(grade.third) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + emap.get(grade.second) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + emap.get(grade.first) + "개");

        totalProceed(emap, count);
    }

    public void totalProceed(EnumMap emap, int count){
        long total = 0;

        if ((int) emap.get(grade.fifth) != 0){
            total += (int) emap.get(grade.fifth) * 5000;
        }
        if ((int) emap.get(grade.forth) != 0){
            total += (int) emap.get(grade.forth) * 50000;
        }
        if ((int) emap.get(grade.third) != 0){
            total += (int) emap.get(grade.third) * 1500000;
        }
        if ((int) emap.get(grade.second) != 0){
            total += (int) emap.get(grade.second) * 30000000;
        }
        if ((int) emap.get(grade.first) != 0){
            total += (int) emap.get(grade.first) * 2000000000;
        }
        printYield(total, count);
    }

    public void printYield(long total, int count){
        double yield;

        yield = ((double)total / ((double)count * 1000)) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", yield) + "%입니다.");
    }
}