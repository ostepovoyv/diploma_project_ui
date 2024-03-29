# Дипломный проект по тестированию интернет-магазина [shop.kz](https://shop.kz/)

<p align="center">
<img title="shop.kz" name="shop.kz" src="media/logo/shop_kz_logo.png">
</p>

## :open_book: Содержание:

- [Технологии и инструменты](#gear-технологии-и-инструменты)
- [Тест кейсы](#heavy_check_mark-Тест-кейсы)
- [Запуск тестов](#computer-запуск-тестов)
- [Примеры использования](#примеры-использования)
- [Запуск тестов в Jenkins](#-запуск-тестов-из-jenkins)
- [Отчет о результатах тестирования в Allure Report](#-отчет-о-результатах-тестирования-в-Allure-report)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео прохождения тестов](#movie_camera-видео-с-прогоном-тестов)

## :gear: Технологии и инструменты

<p align="left">
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="media/logo/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="media/logo/GitHub.svg" width="50" height="50" alt="Github" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="media/logo/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://selenide.org/"><img src="media/logo/Selenide.svg" width="50" height="50" alt="Selenide" title="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="media/logo/Selenoid.svg" width="50" height="50" alt="Selenoid" title="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="media/logo/Allure_Report.svg" width="50" height="50" alt="Allure" title="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="media/logo/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://web.telegram.org/"><img src="media/logo/Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"></a>
<a href="https://qameta.io/"><img src="media/logo/Allure_TO.svg" width="50" height="50" alt="Allure_TO" title="Allure_TO"></a>
</p>


> Автотесты написаны на <code>Java</code>
>
> <code>Selenide</code> - это фреймворк для автоматизированного тестирования веб-приложений на основе <code>Selenium WebDriver</code>.
>
> <code>Selenoid</code> выполняет запуск браузеров в контейнерах <code>Docker</code>.
>
> <code>Allure Report</code> формирует отчет о запуске тестов.
>
> <code>AllureTestOps</code> используются для запуска тестов и отображения результатов тестирования.
>
> <code>Gradle</code> автоматизированной сборки проекта.
>
> <code>JUnit 5</code> библиотека для модульного тестирования.
>
> <code>Jenkins</code> выполняет запуск тестов.
>
> <code>Selenoid</code> используется для запуска браузеров в контейнерах <code>Docker</code>.
>
> После прохождения тестов отправляются уведомления с помощью бота в <code>Telegram</code>.

## :heavy_check_mark: Тест кейсы

> Разработаны автотесты на <code>UI</code>.

- [x] Успешная авторизация на сайте
- [x] Авторизация на сайте, пользователь не зарегистрирован
- [x] Проверка наличия разделов на главной странице
- [x] Проверка бокового меню
- [x] Проверка горизонтального меню
- [x] Проверка элементов в футере
- [x] Проверка наличия контактной информации
- [x] Проверка доступности и содержимого розничного прайс-листа
- [x] Проверка доступности и содержимого прайс-листа сервисных услуг
- [x] Проверка карточки товара
- [x] Проверка добавления товара в корзину
- [x] Проверка удаления товара из корзины
- [x] Проверка сортировки по имени
- [x] Проверка поиска по названию товара
- [x] Проверка поиска по артикулу

## :computer: Запуск тестов

### Локальный запуск тестов
```
gradle clean test -Denv=local
```
### Запуск тестов удаленно (selenoid)
```
gradle clean test -Denv=remote 
```
### Запуск тестов в Jenkins
#### Для запуска тестов в Jenkins без параметров используется команда
```
gradle clean test -Denv=remote
```
#### Для запуска тестов в Jenkins используется <code>remote.proterties</code>

### :earth_asia: Удаленный запуск тестов с параметрами

```bash
clean
test
"-DremoteUrl=${REMOTE_SELENOID_URL}"
"-DbrowserSize=${BROWSER_SIZE}"
"-Dbrowser=${BROWSER}"
"-DbrowserVersion=${BROWSER_VERSION}"
```

## Примеры использования

### Для запуска удаленных тестов необходимо заполнить remote.properties или передать значение:


#### Параметры сборки
>
><code>baseUrl</code> – адрес удаленного сервера, на котором будут запускаться тесты.
>
><code>browser</code> – браузер для тестов.
>
><code>browserVersion</code> – версия браузера.
>
><code>browserSize</code> – размер окна браузера.
>
><code>remoteUrl</code> – адрес удаленного сервера, на котором будут запускаться тесты.
>
><code>pageLoadTimeout</code> – таймаут, для ожидания загрузки страницы.
>
> Для запуска тестов в несколько потоков необходимо добавить параметр <code>-Dthreads={Количество потоков}</code>
>
> Например: <code>gradle clean test -Dthreads=2</code>

Логин и пароль извлекаются из файла конфигурации:
```bash
test.properties
```


## <img width="4%" title="Jenkins" src="media/logo/Jenkins.svg"> Запуск тестов из [Jenkins](https://jenkins.autotests.cloud/job/diploma_project_ui/)
Для запуска сборки необходимо перейти в раздел <code><strong>*Собрать с параметрами*</strong></code> и нажать кнопку <code><strong>*Собрать*</strong></code>.

<p align="center">
  <img src="media/screen/jenkins1.png" alt="Jenkins" width="900">
</p>

После выполнения сборки, в блоке <code><strong>*История сборок*</strong></code> напротив номера сборки появится
значок *Allure Report* и *Allure TestOps* кликнув по которому, откроется страница с сформированным html-отчетом и тестовой документацией.

## <img width="4%" title="Allure Report" src="media/logo/Allure_Report.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/diploma_project_ui/4/allure/)

<p align="center">
  <img src="media/screen/allure-report1.png" alt="allure-report_1" width="900">
</p>

<p align="center">
  <img src="media/screen/allure-report2.png" alt="allure-report_2" width="900">
</p>

## <img width="4%" title="Allure TestOPS" src="media/logo/Allure_TO.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/19415/)

### Основной дашборд
<p align="center">
  <img src="media/screen/Allure_TO1.png" alt="dashboard1" width="900">
</p>

### Список тестов с результатами
<p align="center">
  <img src="media/screen/Allure_TO2.png" alt="dashboard2" width="900">
</p>

### Test plans
<p align="center">
  <img src="media/screen/Allure_TO3.png" alt="dashboard3" width="900">
</p>


## <img width="4%" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram
После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прохождении тестов.

<p align="center">
<img title="Telegram Notifications" src="media/screen/tg_notify.png">

## :movie_camera: Видео с примером прохождения теста

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста

<p align="center">
  <img title="Video" src="media/video/toCart.gif">
</p>

[Вернуться к началу ⬆](#shop.kz)