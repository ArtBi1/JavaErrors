package javaerrors;

public class ExceptionIncorrectGender extends RuntimeException {
  public ExceptionIncorrectGender() {
    super("Неправильный пол: либо М либо Ж");
  }

  public ExceptionIncorrectGender(String message) {
    super(message);
  }
}
