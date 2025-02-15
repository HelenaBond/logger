Реализация Системы Логгирования
1. Логгирование сообщений разных уровней (INFO, DEBUG, WARN, ERROR).
2. Возможность конфигурирования логгеров (например, уровень логирования, формат сообщений, выходные потоки (консоль, файл и т.д.)).
3. Возможность добавления различных аппендеров (console, file).
4. Поддержка конфигурации через файл конфигурации.


### Как создать логгер
Создайте один конфигуратор, одну фабрику и один логгер на всё приложение.

LoggerConfigurator configurator = new LoggerJsonConfigurator("Путь к файлу с настройками");

или

LoggerConfigurator configurator = new LoggerPropertiesConfigurator("Путь к файлу с настройками");

и затем

LoggerFactory loggerFactory = new LoggerFactory(configurator);

Logger logger = loggerFactory.createLogger();

### Как добавить собственную реализацию конфигуратора для поддержки иного формата файла конфигурации.
Отнаследуйтесь от AbstractConfigurator.