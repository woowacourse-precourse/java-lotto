# MODEL

## 1. Lotto
- 예외 처리
  - 1부터 45까지 예외처리
  - 6를 가지고 있는지
  - 중복 숫자가 있을 시 예외처리
- play : 각 로또와 WinningNumber를 비교하여 Result를 반환한다.
- generateLotto : 6개의 random한 숫자를 가진 로또를 발행한다.

## 2. WinningNumber
- Lotto를 상송받고 보너스 값을 가진다.

## 3. Buyer
- buyLotto : Lotto 혹은 List를 입력받는다.
  - 구매해야 할 갯수를 입력받는다.
  - 기존 로또와 중복시 구매하지 않는다.
- play : 각 Lotto와 WinningNumber의 모든 결과를 History에 반영한다.

## 4. Result
- NONE, THREE, FOUR, FIVE, FIVE_BONUS, SIX
  - THREE 이하의 값은 모두 NONE이다.
- 각 상수는 당첨값을 갖고 있다.

## 5. History
- Buyer의 play의 결과로 당첨 내역을 HashTable로 갖는다.
- calculateProfit : 수익률을 반환한다. 

# Viewer

## 1. inputView
- 모든 안내 문구를 상수로 정의한다.
- controller에서 받은 구매한 로또 수량을 출력한다.
- 입력받은 로또 번호를 정렬하여 []으로 감싸서 출력한다.
- 당첨 번호와 보너스 번호를 입력받는다.
## 2. outputView
- 모든 안내 문구를 상수로 정의한다.
- domain에서 계산된 history를 이용하여 내역과 수익률을 출력한다.

# Controller

## 1. Controller
- 구입 금액이 1000원 이상일시 예외처리한다.
- domain과 Viewer를 이용하여 application을 구현한다.