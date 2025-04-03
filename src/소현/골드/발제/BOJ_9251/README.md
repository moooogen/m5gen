# 9251 LCS

```
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다. 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력하라
```

- DP, 문자열
- 시간 제한 0.1초
- 메모리 제한 256 MB

## LCS

- 문자열이 연속적이지 않아도 된다

### 2차원 배열에 저장

ex) ![예시 이미지](https://velog.velcdn.com/images/zeesouth/post/851b7093-8bbe-4b76-84ad-96e8886de2d0/image.png)

- [code](./BOJ_9251.java)
  - 메모리 21712kb
  - 시간 208ms
- 과정

1. String A, B가 있을 경우 list[A.length()+1][B.length()+1] 만들고 index 0 값들은 0으로 둔다.
2. list[a][b]값을 정할 때 A.charAt(a-1) != B.charAt(b-1) 라면 list[a-1][b]와 list[a][b-1] 중 큰 값,
   A.charAt(a-1) == B.charAt(b-1) 라면 list[a-1][b-1] + 1

```java
String str1, str2;
int[][] list = new int[str1.length() + 1][str2.length() + 1];

for (int i = 1; i <= str1.length(); i++) {
    for (int j = 1; j <= str2.length(); j++) {
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            list[i][j] = list[i - 1][j - 1] + 1;
        } else {
            list[i][j] = Math.max(list[i - 1][j], list[i][j - 1]);
        }
    }

}
```

- 시간복잡도 O(nm)
- 공간복잡도 O(nm)

### 1차원 배열 2개 사용

- [code](./BOJ_9251_ver2.java)

  - 메모리 21664kb
  - 시간 204ms

- 과정

1. String A, B가 있을 경우 list[B.length()+1] 두개 만들고 index 0 값들은 0으로 둔다.
2. list[b]값을 정할 때 A.charAt(a-1) != B.charAt(b-1) 라면 list[b]와 list[b-1] 중 큰 값,
   A.charAt(a-1) == B.charAt(b-1) 라면 이전 줄 확인 시 저장한 배열의 list[b-1] + 1
3. 한 줄이 끝나면 다른 리스트에 해당 값들 저장

```java
String str1, str2;
int[] list1 = new int[str2.length() + 1];
int[] list2 = new int[str2.length() + 1];

for (int i = 1; i <= str1.length(); i++) {
    for (int j = 1; j <= str2.length(); j++) {
        list1[j] = str1.charAt(i - 1) == str2.charAt(j - 1) ? list2[j - 1] + 1 : Math.max(list1[j], list1[j - 1]);
    }
    list2 = list1.clone();
}
```

- 시간복잡도 O(nm)
- 공간복잡도 O(n)
