package com.garg;

import java.io.InputStream;
import java.util.Scanner;

public class Input {
  private final Scanner sc;
  private final InputStream source;

  public Input(){
    this.source = System.in;
    sc = new Scanner(source);
  }

  public Input(InputStream source){
    this.source = source;
    sc = new Scanner(this.source);
  }

  public int readInt(){
    int input = sc.nextInt();
    sc.nextLine(); // consumes newline left by nextInt
    return input;
  }

  public int[] readIntArray(int size){
    int[] arr = new int[size];
    for (int i = 0; i < size; i++){
      arr[i] = sc.nextInt();
    }
    sc.nextLine();
    return arr;
  }

  public Input prompt(String message) {
    System.out.print(message);
    return this;
  }
}
