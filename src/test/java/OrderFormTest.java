import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.HomePageScooter;
import ru.praktikum.scooter.OrderPageScooter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(Parameterized.class)
public class OrderFormTest {
    private WebDriver driver;
    private static final String URL_ADDRESS = "https://qa-scooter.praktikum-services.ru/";
        private final String userName;
        private final String userSurname;
        private final String userAddress;
        private final String userPhone;
        private final String comment;
        private final String success;
        public OrderFormTest(String userName, String userSurname, String userAddress, String userPhone, String comment, String success) {
            this.userName = userName;
            this.userSurname = userSurname;
            this.userAddress = userAddress;
            this.userPhone = userPhone;
            this.comment = comment;
            this.success = success;
        }
        @Parameterized.Parameters
        public static Object[][] getTestData() {
            return new Object[][] {
                    {"Иван", "Петров", "Льва Толстого 16", "79990001122", "комментарий курьеру", "Заказ оформлен"},
                    {"Семен", "Иванов", "Главная 3", "73338881122", "простой нкомментарий курьеру", "Заказ оформлен"}
            };
        }
    @Test
    public void checkOrderFormTopBtn() {
        driver = new ChromeDriver();
        driver.get(URL_ADDRESS);
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.waitForTopButtonLoad();
        objHomePage.pushCookieButton();
        objHomePage.pushButtonInTopOfPage();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.setUserName(userName);
        objOrderPage.setUserSurname(userSurname);
        objOrderPage.setUserAddress(userAddress);
        objOrderPage.setMetro();
        objOrderPage.setUserPhone(userPhone);
        objOrderPage.clickNextButton();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String deliveryDate = LocalDate.now().plusDays(3).format(formatter);
        objOrderPage.setDeliveryDate(deliveryDate);
        objOrderPage.setRentalPeriod();
        objOrderPage.setComment(comment);
        objOrderPage.clickOrderButton();
        objOrderPage.waitForApproveButtonLoad();
        objOrderPage.clickApproveButton();
        objOrderPage.waitForSuccessOrder(success);
    }
    @Test
    public void checkOrderFormBottomBtn() {
        driver = new ChromeDriver();
        driver.get(URL_ADDRESS);
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.waitForTopButtonLoad();
        objHomePage.pushCookieButton();
        objHomePage.pushButtonInBottomOfPage();

        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.setUserName(userName);
        objOrderPage.setUserSurname(userSurname);
        objOrderPage.setUserAddress(userAddress);
        objOrderPage.setMetro();
        objOrderPage.setUserPhone(userPhone);
        objOrderPage.clickNextButton();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String deliveryDate = LocalDate.now().plusDays(3).format(formatter);
        objOrderPage.setDeliveryDate(deliveryDate);
        objOrderPage.setRentalPeriod();
        objOrderPage.setComment(comment);
        objOrderPage.clickOrderButton();
        objOrderPage.waitForApproveButtonLoad();
        objOrderPage.clickApproveButton();
        objOrderPage.waitForSuccessOrder(success);
    }
    @After
    public void teardown() { driver.quit(); }
}
