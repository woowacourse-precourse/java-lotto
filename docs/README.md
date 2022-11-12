# MODEL

## 1. Lotto
- 1부터 45까지 예외처리
- 6를 가지고 있는지
- 중복 숫자가 있을 시 예외처리
- play : 각 로또와 WinningNumber를 비교하여 Result를 반환한다.

## 2. WinningNumber
- Lotto를 포함하고 보너스 값을 가진다.

## 3. Buyer
- buyLotto : Lotto 혹은 List를 입력받는다.
- play : 각 Lotto와 WinningNumber의 모든 결과를 History에 반영한다.

## 4. History
- Buyer의 play의 결과로 당첨 내역을 HashTable로 갖는다.
- calculateProfit : 수익률을 반환한다. 

## 5. Result
- NONE, THREE, FOUR, FIVE, FIVE_BONUS, SIX
- 각 상수는 당첨값을 갖고 있다.
