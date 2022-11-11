### Application.java


### Lotto.java
```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
```
	
####__1. lottoRandomNum (Lotto 랜덤 숫자뽑기)__
	   
+ 숫자 1 ~ 45 Random, 중복되지 않는 숫자 6개 저장
	
####__2. myLottoNum (내가 뽑은 Lotto 숫자)__

+ 숫자 1 ~ 45 선택, 중복되지 않은 숫자 6개 저장
  <br/>(숫자 입력은 ,쉼표 기준으로 구분)
<br/><br/>
+ _"당첨 번호를 입력해 주세요."_ 
	
	1,2,3,4,5,6

+ **validate 에러항목 검증**

####__2-1. bonusNum (보너스 번호)__
+ 숫자 6개 지정 후 보너스 번호 입력 
 <br/><br/>
 
+ _"보너스 번호를 입력해 주세요."_

	7
 
####__3. validate ( [ERROR] 예외발생 문구 출력)__

+ 잘못된 값 입력 시 에러 문구 출력
<br/><br/>
+ ex) 숫자가 아닌 문자열 입력, 중복 값 입력, 1 ~ 45 벗어난 숫자 입력

	[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

---------------------------------------------------------------------------
####__4. lottoStart (로또 번호 대조하기)__

+ lottoRandomNum, myLottoNum 로또 번호 대조(List<> 1, List<> 2)
<br/><br/>
+ agreementCount 적중 숫자 리턴

> - 6개 적중 -> 1등 출력
> - 5개 + **보너스 번호 적중** -> 2등 출력
> - 5개 적중 -> 3등 출력
> - 4개 적중 -> 4등 출력
> - 3개 적중 -> 5등 출력

####__4-1. agreementLotto (로또 당첨 등수 리턴)__

+ agreementCount -> 등수 리턴

####__5. prizeMoney (int lottoStart) - (당첨금 출력)__

+ lottoStart 등수에 따른 당첨금 출력

> - 1등 - 2,000,000,000원
> - 2등 - 30,000,000원
> - 3등 - 1,500,000원
> - 4등 - 50,000원
> - 5등 - 5,000원

####__6. buyLotto (로또 구입)__

+ 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며<br/> 
1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
<br/><br/>
+ _"구입금액을 입력해 주세요."_
<br/><br/>
+ 입력 받은 값 / 1000 
<br/>( 1장에 1,000원. 소숫점 예외처리 )
	
	< 중 간 점 검 > <br/>
	-로또 구입 숫자 n번만큼 lottoRandomNum도 n번 실행됬는가? <br/>
	-lottoRandomNum  List n개를 차례대로 myLottoNum 당첨숫자와 대조했는가? <br/>
	-당첨 내역 n개 값, 등수, 당첨금이 원하는 메서드에 전달 됬는가?

####__7. prizeList (당첨 내역 저장)__

+ myLottoNum, lottoRandomNum 숫자 대조 List값 저장.
<br/><br/>
+ 당첨 내역 List n개의 등수, 당첨금 출력

####__8. yield (당첨금 수익률 계산)__

![수익률](https://user-images.githubusercontent.com/106413731/201090898-3dfb018e-9df5-4fd3-a0fc-57a0b5d5fcb9.jpg)

+ 수익률은 소숫점 둘째자리에서 반올림 한다.
<br/><br/>
+ 수익률 프린트

	총 수익률은 12.5% 입니다.

####__9. lottoEnd (로또 게임 종료)__

+ 게임 종료

---------------------------------------------------------------------

####__10. buyLottoPrint (구매한 로또 lottoRandomNum 리스트 출력)__

+ 발행한 로또 수량(buyLotto) 및 번호(lottoRandomNum)를 출력한다.<br/> 
로또 번호는 오름차순으로 정렬하여 보여준다.
<br/><br/>
+ _"n개를 구입했습니다."_  ->buyLotto값 전달받음
	
	n개를 구매했습니다.<br/>
	[8, 21, 23, 41, 42, 43] <br/>
	[3, 5, 11, 16, 32, 38] <br/>
	[7, 11, 16, 35, 36, 44] <br/>
	[1, 8, 11, 31, 41, 42] <br/>
	[13, 14, 16, 38, 42, 45] <br/>
	[7, 11, 30, 40, 42, 43] <br/>
	[2, 13, 22, 32, 38, 45] <br/>
	[1, 3, 5, 14, 22, 45]

####__11. prizeListPrint (당첨내역 통계 출력)__

+ 당첨 내역을 출력한다.
<br/><br/>
+ prizeList 값 전달받음

	< 당 첨  통 계 ><br/>
	---<br/>
	3개 일치 (5,000원) - 1개<br/>
	4개 일치 (50,000원) - 0개<br/>
	5개 일치 (1,500,000원) - 0개<br/>
	5개 일치, 보너스 볼 일치 (30,000,000원) - 0개<br/>
	6개 일치 (2,000,000,000원) - 0개<br/>
	총 수익률은 12.5%입니다<br/>
