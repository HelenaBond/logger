Реализация Системы Логгирования
1. Логгирование сообщений разных уровней (INFO, DEBUG, WARN, ERROR).
2. Возможность конфигурирования логгеров (например, уровень логирования, формат сообщений, выходные потоки (консоль, файл и т.д.)).
3. Возможность добавления различных аппендеров (console, file).
4. Поддержка конфигурации через файл конфигурации.

### Настройка логгера через файл конфигурации
Если настройки лежат в файле с расширением .properties.

log.appenders=test - вместо test должны быть перечислены через запятую все имена аппендеров.

log.appender.test.type=file - к приставке log.appender. добавляете одно из имён
перечисленных в списке выше и суффикс .type . 
После равно указываете тип аппендера для которого будут производится настройка.
Например file или console или кастомный аппендер.

Для всех аппендеров - наследников AbstractAppender существуют значения по умолчанию.

log.appender.test.dateTimeFormat=yyyy-MM-dd HH:mm:ss

log.appender.test.messageFormat=[%s] [%s] %s

log.appender.test.from=INFO

log.appender.test.to=ERROR

Для FileAppender

log.appender.test.filePath="log.txt

### Как создать логгер
Создайте один конфигуратор, одну фабрику и один логгер на всё приложение.

LoggerConfigurator configurator = new LoggerJsonConfigurator("Путь к файлу с настройками");

или

LoggerConfigurator configurator = new LoggerPropertiesConfigurator("Путь к файлу с настройками");

затем

LoggerFactory loggerFactory = new LoggerFactory(configurator);

Logger logger = loggerFactory.createLogger();

### Как добавить собственную реализацию Appender в дополнение к существующим
Для этого нужно вручную инициализировать AppenderRegister.

AppendersRegister appenders = new AppendersRegister();

LoggerConfigurator configurator = new LoggerJsonConfigurator("Путь к файлу с настройками", appenders);

или

LoggerConfigurator configurator = new LoggerPropertiesConfigurator("Путь к файлу с настройками", appenders);

затем

appenders.registerAppender("appenderName", CustomAppender.class);

LoggerFactory loggerFactory = new LoggerFactory(configurator);

Logger logger = loggerFactory.createLogger();

Вместо "appenderName" в методе registerAppender() вставьте имя которое вы будете использовать для настройки файла конфигурации
в качестве значения для ключа type. Вместо CustomAppender.class вставьте название вашего кастомного аппендера.
Самый простой способ создания кастомного аппендера - это наследование от класса AbstractAppender.
Теперь вы можете настраивать свой аппендер через файл конфигурации по примеру выше. Обязательно зарегистрируйте ваш аппендер 
прежде чем вызывать метод создания логгера.
В вашем аппендере должен быть конструктор без параметров.

### Как добавить собственную реализацию PropertiesDeserializer в дополнение к существующим
Для работы с файлом конфигурации в формате .properties зарегистрированы десериализаторы для трёх типов данных:

String

LogLevel

DateTimeFormatter

Если вам нужен кастомный десериализатор для другого типа данных
используйте аннотацию PropsDeserializer(using = CustomPropsDeserializer.class) над полем которое нужно десериализовать.
Где CustomPropsDeserializer.class ваша кастомная реализация интерфейса PropertiesDeserializer<T>

### Как добавить собственную реализацию конфигуратора для поддержки иного формата файла конфигурации.
Отнаследуйтесь от AbstractConfigurator.