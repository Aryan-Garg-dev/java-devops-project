package com.garg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntArrayTest {

  @Test
  void testSum() {
    Assertions.assertEquals(15, IntArray.sum(new int[]{1, 2, 3, 4, 5}));
    Assertions.assertEquals(0, IntArray.sum(new int[]{}));
  }

  @Test
  void testMean() {
    Assertions.assertEquals(3.0, IntArray.mean(new int[]{1, 2, 3, 4, 5}));
    Assertions.assertEquals(0.0, IntArray.mean(new int[]{})); // returns 0.0 for empty stream
  }

  @Test
  void testMin() {
    Assertions.assertEquals(1, IntArray.min(new int[]{1, 2, 3, 4, 5}));
  }

  @Test
  void testMax() {
    Assertions.assertEquals(5, IntArray.max(new int[]{1, 2, 3, 4, 5}));
  }

  @Test
  void testCount() {
    Assertions.assertEquals(2, IntArray.count(new int[]{1, 2, 2, 3}, 2));
    Assertions.assertEquals(0, IntArray.count(new int[]{1, 2, 3}, 4));
  }

  @Test
  void testIsSorted() {
    Assertions.assertTrue(IntArray.isSorted(new int[]{1, 2, 3, 4}));
    Assertions.assertTrue(IntArray.isSorted(new int[]{})); // empty is sorted
    Assertions.assertFalse(IntArray.isSorted(new int[]{3, 2, 1}));
  }

  @Test
  void testRemoveByIndex() {
    Assertions.assertArrayEquals(new int[]{1, 3}, IntArray.remove(new int[]{1, 2, 3}, 1, true));
    Assertions.assertArrayEquals(new int[]{1, 2, 3}, IntArray.remove(new int[]{1, 2, 3}, 5, true)); // invalid index
  }

  @Test
  void testRemoveByElement() {
    Assertions.assertArrayEquals(new int[]{1, 3}, IntArray.remove(new int[]{1, 2, 3}, 2, false));
    Assertions.assertArrayEquals(new int[]{1, 2, 3}, IntArray.remove(new int[]{1, 2, 3}, 5, false)); // element not found
  }

  @Test
  void testReverse() {
    Assertions.assertArrayEquals(new int[]{3, 2, 1}, IntArray.reverse(new int[]{1, 2, 3}));
    Assertions.assertArrayEquals(new int[]{}, IntArray.reverse(new int[]{}));
  }

  @Test
  void testIsPalindrome() {
    Assertions.assertTrue(IntArray.isPalindrome(new int[]{1, 2, 3, 2, 1}));
    Assertions.assertFalse(IntArray.isPalindrome(new int[]{1, 2, 3}));
    Assertions.assertTrue(IntArray.isPalindrome(new int[]{})); // empty is palindrome
  }

  @Test
  void testMergeSorted() {
    Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, IntArray.mergeSorted(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
    Assertions.assertArrayEquals(new int[]{1, 2, 3}, IntArray.mergeSorted(new int[]{1, 2, 3}, new int[]{}));
  }

  @Test
  void testDiagonalSum2d() {
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };
    Assertions.assertEquals(30, IntArray.diagonalSum2d(matrix)); // 1+5+9 + 3+5+7 = 30
  }
}