# 기능 목록 구현 

## 로또 구입 - Lotto 클래스
* 금액 얼마인지 - inputMoney();
* 자동 / 수동 선택 - selectAutoOrChoose();
   * 수동이면 1, 자동이면 2 입력
   * 수동 : 번호 입력 -> 가능하다면?
   * 자동 : 랜덤 생성


## 로또 랜덤 숫자 생성 - Lotto 클래스
* 1등 당첨 번호 생성 - makeWinnerNumber();
* 보너스번호 생성 - makeBonusNumber();


## 구입한 로또 출력 -DisplayLotto 클래스
* 몇 개 구입했는지 -theNumberOfLotto();
* 오름차순으로 정렬받는다. -sortUpper()


## 당첨 출력 - DisplayLotto 클래스
* 몇 개 일치했는지에 따라 당첨 출력 -compareLotto();
* 수익률 출력 - rateOfReturn();

## 예외사항 
* 로또 구입 금액 잘못 입력했을 경우 
* 수동일 경우 6개 외의 수를 입력한 경우 
