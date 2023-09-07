## Задача:

Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

**Условия:**
Форматы данных:
1. Фамилия, имя, отчество - строки
2. Дата рождения - строка формата dd.mm.yyyy
3. Номер телефона - целое беззнаковое число без форматирования
4. Пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.


## Описание программы:

Эта программа помогает вам вводить информацию о пользователях, проверять её на корректность и хранить данные в файлах для дальнейшего использования.

1. При запуске приложения, оно предоставит вам приглашение ввести информацию о пользователе.
2. Вы вводите информацию в следующем формате: "Фамилия Имя Отчество Дата_рождения Номер_телефона Пол". Разделяйте каждый элемент пробелами. 
3. После ввода информации, приложение проверит её на соответствие определенным критериям:

* Длина фамилии, имени, отчества, должна быть от 2 до 20 символов.
* Фамилия, имя и отчество не могут быть пустыми.
* Дата рождения должна быть в формате "дд.мм.гггг" и должна быть корректной (например, "01.01.1991").
* Номер телефона должен содержать только цифры и не превышать 15 символов.
* Пол может быть "М" (мужской) или "Ж" (женский).

4. Если введенная информация соответствует всем критериям, она будет сохранена в файле. Файл будет иметь имя, совпадающее с Фамилией пользователя и расширение ".txt". Например, если Фамилия пользователя - "Иванов", то файл будет назван "Иванов.txt" и будет содержать введенную информацию.
5. Если введенная информация не соответствует критериям, приложение выдаст соответствующее сообщение об ошибке и попросит вас ввести информацию снова.