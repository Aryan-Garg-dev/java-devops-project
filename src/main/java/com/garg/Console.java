package com.garg;

import java.util.Arrays;

public class Console {
  private static final String RESET = "\u001B[0m";
  private static final String WARN = "\u001B[33m"; // For warn
  private static final String ERROR = "\u001B[31m";    // For error

  private enum Level {
    LOG, WARN, ERROR
  }

  private Level currentLevel = Level.LOG;

  private static final Console instance = new Console();

  private Console() {};

  public static Console log() {
    instance.currentLevel = Level.LOG;
    return instance;
  }

  public static Console error() {
    instance.currentLevel = Level.ERROR;
    return instance;
  }

  public static Console warn() {
    instance.currentLevel = Level.WARN;
    return instance;
  }

  private String colorize(String message) {
    return switch (currentLevel) {
      case WARN -> WARN + "⚠️ " + message + RESET;
      case ERROR -> ERROR + "❌ " + message + RESET;
      default -> message;
    };
  }

  public Console print(Object message) {
    System.out.print(colorize(String.valueOf(message)));
    return this;
  }

  public Console println(Object message) {
    System.out.println(colorize(String.valueOf(message)));
    return this;
  }

  public Console println() {
    System.out.println();
    return this;
  }

  public Console printf(String format, Object... args) {
    String formatted = String.format(format, args);
    System.out.print(colorize(formatted));
    return this;
  }

  public <T> Console printArray(T[] array){
    System.out.print(colorize(Arrays.toString(array)));
    return this;
  }
}
