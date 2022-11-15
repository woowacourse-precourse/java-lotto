# 미션 - 로또

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고,<br>기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

* * *

## ✨ 체크 포인트
### WinningLotto를 추가한 이유?
- `Lotto에 필드(인스턴스 변수)를 추가할 수 없다.`
    - 사용자로부터 입력받는 번호 중 보너스 번호가 존재한다.
    - 하지만, Lotto에 필드를 추가할 수 없다.
    - 6개의 번호만을 가지는 Lotto 클래스와 별개로, bonusNumber 필드를 가진<br>WinningLotto 클래스를 추가해 해결한다.

* * *

## 🤔 의문점
- `IllegalArgumentException` <-> `InvalidParameterException`
    - 입력값의 오류인데 invalidParam 이 아닌 illegalArgument?
- Coupling of List as Parameter
    - 이번, 이전 과제에서 List를 Parameter로 전달하는 경우 多
    - 이번 과제까지는 List를 Deep Copy해서 기존 객체를 보존했지만
    - 이걸 Call by Value 구현이라 볼 수 있나?
- Validate
  - 제공된 코드에선 Lotto 클래스 자체적으로 유효성 검사가 진행된다.
  - 클래스별 유효성 검사가 상이할 수 있으나 클래스는 핵심 기능만 수행하는 편이 낫지 않나
    - 이전 과제부터 모든 유효성 검사를 Checker 클래스로 분리하고 참조해 사용
    - 지금까지는 활용성/유지보수성 모두 양호하지만 클래스 수가 증가하면 악화?
    - UserChecker LottoChecker 각 클래스별 체크 클래스를 별도로?