package javaerrors;

public class ExceptionLongName extends StringIndexOutOfBoundsException {
    
  public ExceptionLongName() {
    super("Имя, фамилия либо отчество слишком длинное либо содержит цифры, пробелы и т.д.");
  }

  public ExceptionLongName(String message) {
    super(message);
  }
}
