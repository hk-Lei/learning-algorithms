冒泡排序 (Bubble Sort)
=====================

冒泡排序是一种比较简单的排序算法。

### 算法描述

**注：** 我们默认按从小到大的顺序排序一个数组；**算法描述** 中提供的代码都为 java 实现，后面的 **算法实现** 部分会提供改良版的多语言实现。

#### 一般冒泡排序
我们设想这个数组是像一组气泡一样竖立在我们面前的，气泡之间有轻重之分（大则重，小则轻）。那么第一次遍历我们从最底下的气泡开始，两两比较，如果下面比上面轻则交换他们的位置，一直比较到最顶部的气泡，经过第一次遍历后，最轻的元素会在气泡的顶端。第二次，我们依旧从最底下开始，比较到上面第二个气泡即可，如此循环，直到比较完最底部两个气泡为止。

```java
/**
 * 一般的冒泡排序，时间复杂度为 O(n^2)
 */
void bubbleSort(int[] array){
    for (int i = 0; i < array.length - 1; i++) {
        int temp;
        for (int j = array.length - 1; j > i; j--) {
            if (array[j] < array[j - 1]) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
    }
}
```

上述过程中完全不考虑数组原本的顺序，针对个数为 n 的数组，都经过了 n * (n-1) / 2 次比较，即时间复杂度为 O(n^2)。

#### 优化版冒泡排序
如果我们的在冒泡排序中考虑了数组是否已经有序或者部分有序，我们将有效的减少元素间的比较次数，从而提高冒泡排序的效率。

1. 第一步优化
我们每次遍历都是从最底部元素(n)开始遍历到上面的某一个元素(i)为止，若在某一次遍历过程中，我们没有发生一次交换过程，即 i -> n 已经是有序的了，那么我们就没必要进行后面的排序过程了，整个数组已然是有序数组了。

```java
void bubbleSort2(int[] array){
    boolean isSwap;
    for (int i = 0; i < array.length - 1; i++) {
        int temp;
        isSwap = false;
        for (int j = array.length - 1; j > i; j--)
            if (array[j] < array[j - 1]) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                isSwap = true;
            }
        }
        if (!isSwap) break;
    }
}
```

2. 第二步优化
上一步我们在算法中考虑了数组底部元素是否有序。我们还可以考虑我们某一次遍历（n 到 i 自底向上）过程中，最后一次交换的是 k 和 k - 1 的元素（n > k > i），那么此时 k 到 i 已然是有序的了，那么我们下次遍历时，只需遍历 n 到 k 即可。

```java
void bubbleSort3(int[] array){
    int num = 0;
    int last, lastTemp = 0;
    for (int i = 0; i < array.length - 1; i++) {
        int temp;
        last = lastTemp;
        for (int j = array.length - 1; j > last; j--) {
            num ++;
            if (array[j] < array[j - 1]) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                lastTemp = j;
            }
        }
        //第一步优化的简写版
        if (last == lastTemp) break;
    }
}
```

最好的情况：数组有序，只需比较 n-1 次即可

最差的情况：数组倒序，则和一般的冒泡排序一样需要比较 n * (n-1) / 2 次

因此，优化版冒泡排序的最好的时间复杂度为 O(n)，最坏时间复杂度为 O(n^2)。

### 算法稳定性

冒泡排序比较的是相邻的两个元素，交换也发生在这两个元素之间。若元素相等，则没必要将其交换，相等元素的前后顺序在排序前后不会发生变化，因此冒泡排序是一种稳定的排序算法。

### 算法实现

#### Java

```java
/**
 * 优化版冒泡排序，时间复杂度为 O(n) ~ O(n^2)
 */
 void bubbleSort3(int[] array){
     int num = 0;
     int last, lastTemp = 0;
     for (int i = 0; i < array.length - 1; i++) {
         int temp;
         last = lastTemp;
         for (int j = array.length - 1; j > last; j--) {
             num ++;
             if (array[j] < array[j - 1]) {
                 temp = array[j];
                 array[j] = array[j - 1];
                 array[j - 1] = temp;
                 lastTemp = j;
             }
         }
         if (last == lastTemp) break;
     }
 }
```
