## 어려웠던 점
### Immutable List , UnsupportedOperationException

```java
class LearnImmutableList { 
    List unmodifiableList = Collections.unmodifiableList(list);
    List newList = new ArrayList(unmodifiableList);
    Collections.sort(newList);
}
```

### 예외 처리
* 예외 처리 위치
* 꼼꼼한 예외 처리
* 테스트코드 작성시, 예외 발생 테스트

### 깨달은 점
* getter의 위험성
  * getter가 반환하는 값을 변경하지 못하도록 만들어야 함. + getter로 얻은 필드값을 변경하면 안됨
