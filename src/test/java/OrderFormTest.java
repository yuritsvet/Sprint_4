import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.HomePageScooter;
import ru.praktikum.scooter.OrderPageScooter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderFormTest {
    // класс проверки заполнения формы заказа и ее отправки
    private WebDriver driver;

    @Test
    public void checkOrderForm() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver); // создал объект класса домашней страницы
        objHomePage.waitForTopButtonLoad();
        objHomePage.pushCookieButton();
        objHomePage.pushButtonInTopOfPage();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver); //объект класса страницы с формой заказа
        String userName = "Иван";
        objOrderPage.setUserName(userName);
        String userSurname = "Петров";
        objOrderPage.setUserSurname(userSurname);
        String userAddress = "Льва Толстого 16";
        objOrderPage.setUserAddress(userAddress);
        objOrderPage.setMetro();
        String userPhone = "79990001122";
        objOrderPage.setUserPhone(userPhone);
        objOrderPage.clickNextButton();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String deliveryDate = LocalDate.now().plusDays(3).format(formatter);
        objOrderPage.setDeliveryDate(deliveryDate);
        objOrderPage.setRentalPeriod();
        String comment = "комментарий для курьера";
        objOrderPage.setComment(comment);
        objOrderPage.clickOrderButton();
        objOrderPage.waitForApproveButtonLoad();
        objOrderPage.clickApproveButton();
        String success = "Заказ оформлен";
        objOrderPage.waitForSuccessOrder(success);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
