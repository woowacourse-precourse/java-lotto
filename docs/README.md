## 로또

## 프로젝트 소개
입력 받은 금액만큼 로또를 자동으로 구매한 다음  
당첨 번호(+ 보너스 번호)와 비교해서  
당첨 내역과 수익률을 알려주는 프로그램이다.

## 프로그램 흐름
1. 로또 구입 금액을 입력 받는다.
2. 로또 구매 수량을 얻는다.
3. 로또를 발급한다.
4. 로또를 구매 수량을 출력한다.
5. 발급 로또들을 오름차순으로 출력한다.
6. 당첨 번호를 입력 받는다.
7. 보너스 번호를 입력 받는다.
8. 발급 로또들과 당첨 번호 및 보너스 번호를 비교해 각 등수를 구한다.
9. 각 등수를 출력한다.
10. 수익률을 출력한다.

## 기능 목록
- [x] 양의 정수를 입력받을 수 있다. - UserInterFace#inputInteger()
- [x] 로또 구입 금액을 기억할 수 있다. - Buyer#setMoney()
- [x] 로또 구입 금액을 얻을 수 있다. - Buyer#getMoney()
- [x] 금액에 해당하는 로또 발행수를 알 수 있다. - Judgment#countLottos()
   - [x] 입력 받은 금액이 양의 정수가 아니면 에러 메시지를 출력 후 종료할 수 있다.
   - [x] 입력 받은 금액이 1,000원으로 나누어 떨어지지 않으면 에러 메시지를 출력 후 종료할 수 있다.
- [x] 1~45까지의 중복되지 않는 6개의 숫자를 생성한다. - NumberGenerator#createLottoNumbers()
- [x] 로또를 구매할 수 있다. - Buyer#buyLottos()
- [x] 구매한 로또를 알 수 있다. - Buyer#getLottos()
- [x] 구매한 로또 번호를 오름차순으로 정렬할 수 있다. - Buyer#sortLotto()
- [x] 구매한 로또를 출력할 수 있다. - UserInterFace#printLottos()
- [x] 출력할 수 있다. - UserInterFace#print()
- [x] 유효한 당첨 번호를 입력 받을 수 있다. - UserInterFace#inputWinningNumbers()
   - [x] 당첨 번호가 ,를 5개 포함하지않으면 에러 메시지를 출력 후 종료할 수 있다. - Judgment#check5Commas()
   - [x] 당첨 번호가 ,를 기준으로 잘랐을 때 정수로 변경할 수 없으면 에러 메시지를 출력 후 종료할 수 있다. - Judgment#changeToInteger()
   - [x] (당첨 번호를 ,로 구분했을 때) 숫자 6개가 아니면 에러 메시지를 출력 후 종료할 수 있다. - Judgment#checkSize()
   - [x] (당첨 번호를 ,로 구분했을 때) 유효한 범위의 숫자가 아니면 에러 메시지를 출력 후 종료할 수 있다. - Judgment#checkNumbersRange()
   - [x] 중복인 숫자가 있으면 에러 메시지를 출력 후 종료할 수 있다. - Judgment#duplicateCheck()
- [x] 유효한 보너스 번호 하나를 입력 받을 수 있다. - UserInterFace#inputValidBonus()
   - [x] 당첨 번호와 겹치면 에러 메시지를 출력 후 종료할 수 있다.
- [x] 정수가 특정 범위에 있지 않으면 에러 메시지를 출력 후 종료할 수 있다. - Judgment#checkRange()
- [x] 구매자가 구매한 로또 번호(6자리)와 당첨 번호(6자리 + 보너스 번호)를 비교할 수 있다.
  - [x] 몇 개의 당첨 번호가 포함되는지 알 수 있다. - Judgment#correctCount()
  - [x] 보너스 번호가 포함되는지 알 수 있다. - Judgment#hasBonus()
- [x] 구매자가 구매한 로또 번호가 몇 등인지 알 수 있다. - Referee#getLottoRank()
   - [x] 당첨 번호와 3개 일치하면 5등이다.
   - [x] 당첨 번호와 4개 일치하면 4등이다.
   - [x] 당첨 번호와 5개 일치하면 3등이다.
   - [x] 당첨 번호와 5개 일치하고 보너스 까지 일치하면 2등이다.
   - [x] 당첨 번호와 6개 일치하면 1등이다.
- [x] 당첨 내역 및 수익률을 출력할 수 있다. - UserInterFace#printResult()