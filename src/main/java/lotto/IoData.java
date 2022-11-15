package lotto;

import java.util.ArrayList;
import java.util.List;

public class IoData {
	String str;
	List<Integer> dData = new ArrayList<Integer>(5);
	
	IoData (PrintMessage a){
		this.str = a.getName();
	}

	public IoData() {
		// TODO Auto-generated constructor stub
	}
	
	IoData(List<Integer> b){
		//this.str = str;
		this.dData = b;
	}
	static void inputNum(){
		IoData q = new IoData(PrintMessage.INPUT_NUMBER);
		System.out.println(q.str);
	}
	static void inputBonus(){
		IoData q = new IoData(PrintMessage.INPUT_BONUS);
		System.out.println(q.str);
	}
	
	static void inputMoney(){
		IoData q = new IoData(PrintMessage.INPUT_MONEY);
		System.out.println(q.str);
	}
	
	static void inputDupErr(){
		IoData q = new IoData(PrintMessage.INPUT_DUPLICATE_ERR);
		System.out.println(q.str);
	}
	
	static void inputDefErr(){
		IoData q = new IoData(PrintMessage.INPUT_DEFINE_ERR);
		System.out.println(q.str);
	}
	
	static void result(List<Integer> count) {// {3개, 4개, 5개, 5개+보너스, 6개};
			System.out.println("당첨 통계\n"
					+ "---\n" 
					+ "3개 일치 (5,000원) - "	+ count.get(0) + "개\n"
					+ "4개 일치 (50,000원) - " + count.get(1) + "개\n"
					+ "5개 일치 (1,500,000원) - " + count.get(2) + "개\n"
					+ "5개 일치, 보너스 볼 일치 (30,000,000원) - " + count.get(3) + "개\n"
					+ "6개 일치 (2,000,000,000원) - " + count.get(4) + "개\n"
					+ "총 수익률은 62.5%입니다.\n");
	}
	
	void gains(List<Integer> count) {
		//수익률계산
		
		
	}

	 
	
}
