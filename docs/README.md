# 기능 목록 

- [x] 로또 구입 금액을 입력한다.    ``` Input#buyLotto ```
    - [x] 로또 수량을 확인한다.     ```Controller#checkQuantityOfLotto```
        - [x] 로또 번호를 수량만큼 발행한다. ```Controller#publishLotto```
          - [x] 각 로또의 번호 6개를 뽑는다. ```Controller#pickLottoNumbers```
            - [x] 1 ~ 45 범위에서 뽑아야 한다. ```ExceptionHandler#checkNumbersRange```
            - [x] 동일한 숫자가 없어야 한다. ```ExceptionHandler#checkDuplicationNumbers```
            - [x] 오름차순으로 정렬한다. ```Controller#sortNumbers```
    - [x] 예외 1)  1000원 단위가 아닐 경우 ```ExceptionHandler#checkMoney```
- [x] 당첨 번호를 입력받는다. ```Input#pickWinningNumbers```
    - [ ] length = 6이다. 
- [x] 보너스 번호를 입력받는다. ```Input#pickBonusNumbers ```
    - [x] 1개를 뽑는다.
- [x] 당첨 번호와 발행한 로또를 비교한다. ```Controller#compareNumbers```
  - [x] 당첨된 개수를 확인한다. ```Controller#countWinningLotto```
    - [x] 3개 일치 
    - [x] 4개 일치
    - [x] 5개 일치
    - [x] 5개 일치 , 보너스 볼 일치 
    - [x] 6개 일치 
  - [x] 수익률을 계산한다. ```Controller#calculateProfit```
    - [ ] 소수점 둘째자리에서 반올림한다. 
- [x] 결과를 출력한다. ```Output#printResult```
-----------------------------------------------
### 예외 사항
1. 에러 문구를 출력한다. 
- [ ] 에러 문구는 "[ERROR]"로 시작한다. 

2. 로또 숫자 예외
- [ ] 예외 1) 숫자 범위가 1 ~ 45를 벗어난 경우
3. 로또 구입 금액 
- [ ] 예외 1) 1000원 단위가 아닐 경우 
4. 입력 예외 
   - 당첨번호
       - [x] 예외 1) 쉼표로 숫자를 구분하지 않았을 경우
       - [x] 예외 2) 숫자를 입력하지 않았을 경우
       - [x] 예외 3) 숫자 범위가 1 ~ 45를 벗어난 경우
       - [x] 예외 4) 6개 초과 또는 미만으로 뽑았을 경우
   - 보너스 번호
        - [x] 예외 1) 1개 초과 또는 미만으로 뽑았을 경우
        - [x] 예외 2) 당첨번호와 같은 값이 있을 경우
        - [x] 이하 예외는 당첨번호의 예외 2,3과 동일하다.

## 기능 요구사항
로또 게임 기능을 구현한다. 

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시킨다 
- "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.

### 시스템 요구사항 
- 함수의 길이가 15라인을 넘어가지 않는다. 
- else 예약어를 쓰지 않는다. 
- switch/case도 허용하지 않는다.
- java Enum을 적용한다. 
- 도메인 로직에 단위 테스트를 구현한다. 
