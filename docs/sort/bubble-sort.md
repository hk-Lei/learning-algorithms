冒泡排序 (Bubble Sort)
=====================

冒泡排序是一种比较简单的排序算法。

### 算法描述

# TODO

### 时间复杂度

冒泡排序最好的时间复杂度为 O(n)，最坏时间复杂度为 O(n^n)。

### 算法稳定性

冒泡排序比较的是相邻的两个元素，交换也发生在这两个元素之间。若元素相等，则没必要将其交换，相同元素的前后顺序在排序前后不会发生变化，因此冒泡排序是一种稳定排序算法。

### 算法实现

#### Java

```java
void bubbleSort(int[] array){
    for (int i = 0; i < array.length - 1; i++) {
        int temp;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[i]) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
}
```
