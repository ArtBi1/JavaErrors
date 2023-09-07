package javaerrors;

public class ExceptionBirthDateFormat extends NumberFormatException {
  public ExceptionBirthDateFormat() {
    super("Неправильный формат даты рождения, недопустимый (день/месяц/год)");
  }

  public ExceptionBirthDateFormat(String message) {
    super(message);
  }
}