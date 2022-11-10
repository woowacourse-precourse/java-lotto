# MODEL

## 1. Lotto
- 1부터 45까지 예외처리
- 6를 가지고 있는지
- 중복 숫자가 있을 시 예외처리

## 2. WinningNumber
- Lotto의 자식클래스로 보너스 값을 가진다.

## 3. Buyer
- buyLotto : Lotto 혹은 List를 입력받는다.
- play : WinningNumber를 입력받아 History에 반영한다.

## 4. History
- Buyer의 play의 결과로 당첨 내역을 HashTable로 갖는다.
- calculateProfit : 수익률을 반환한다. 

## 5. Result
- NONE, THREE, FOUR, FIVE, FIVE_BONUS, SIX
- 각 상수는 당첨값을 갖고 있다.
