package javaerrors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.setProperty("console.encoding", "UTF-8"); // Устанавливаем кодировку консоли в UTF-8
    Scanner scanner = new Scanner(System.in); // Scanner для считывания ввода с клавиатуры
    System.out.println("Введите информацию: "); // Предложение для пользователя
    String info = scanner.nextLine(); // Считываем введенную строку


    String[] userData = check(info); // Проверяем введенные данные с помощью метода check()
    if (userData != null) { // Если данные корректны, сохраняем их в файл
      String lastName = userData[0];
      saveDataToFile(lastName, userData);
    }
    scanner.close(); // Закрываем Scanner

  }

  public static String[] check(String info) { // Метод для проверки введенных данных
    String[] userData = info.split(" "); // Разбиваем введенную строку на массив строк,пробел - разделитель
    if (userData.length != 6) {   // Проверка количества элементов в массиве
      throw new RuntimeException("Введите все нужные данные");
    }

    String lastName = userData[0]; // Далее идет проверка каждого элемента массива
    String firstName = userData[1]; //на соответствие определенным критериям
    String middleName = userData[2]; // (длина, формат и т. д.)
    String birthDate = userData[3]; // Если данные не соответствуют критериям
    String phoneNumber = userData[4]; // То выбрасываются соответствующие исключения
    String gender = userData[5];
    if (lastName.length() > 15 || firstName.length() > 20 || middleName.length() > 20 || lastName.length() < 2
        || firstName.length() < 2 || middleName.length() < 2 || !FIOValid(lastName) || !FIOValid(firstName)
        || !FIOValid(middleName)) {
      throw new ExceptionLongName();
    }

    validateBirthDate(birthDate);

    if (!phoneNumber.matches("\\d+") || phoneNumber.length() > 15) {
      throw new ExceptionPhoneNumberFormat();
    }

    if (!(gender.equals("М") || gender.equals("Ж"))) {
      throw new ExceptionIncorrectGender();
    }
    return userData; // В конце возвращает массив userData
  }

  public static boolean FIOValid(String name) { // Метод для проверки, что ФИО не пустое
    return !name.trim().isEmpty();
  }

  public static void validateBirthDate(String birthDate) { // Метод для проверки даты рождения
    String[] dateComponents = birthDate.split("\\.");
    int day = Integer.parseInt(dateComponents[0]); // Разбиваем дату рождения
    int month = Integer.parseInt(dateComponents[1]); // На день, месяц, год
    int year = Integer.parseInt(dateComponents[2]);

    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    // и проводим проверки на корректность введенной даты
    int maxDay;
    if (month == 2) {
      maxDay = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28;
    } else if (month == 4 || month == 6 || month == 9 || month == 11) {
      maxDay = 30;
    } else {
      maxDay = 31;
    }

    if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}") || year < 1900 || year > currentYear || month < 1 || month > 12
        || day < 1 || day > maxDay) {
      throw new BirthDateFormatException();
    }
  }

  public static void saveDataToFile(String lastName, String[] userData) { // Метод для сохранения данных в файл
    try {
      String packageDirectory = "C:\\GitGeekBrains\\JavaErrors"; // Путь к файлу, в который будем сохранять данные

      String filePath = packageDirectory + "\\" + lastName + ".txt";

      BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true)); // Создаем BufferedWrit, он позволит

      String dataToWrite = String.join(" ", userData); // записывать данные в файл. 

      writer.write(dataToWrite);
      writer.newLine(); // Добавляем новую строку в файл, чтобы следующие данные записывались на новой строке.
      writer.close(); // Закрываем объект writer
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}