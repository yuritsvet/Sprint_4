import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.HomePageScooter;
import ru.praktikum.scooter.OrderPageScooter;

public class OrderButtonsTest {
    private static final String URL_ADDRESS = "https://qa-scooter.praktikum-services.ru/";
    private final String actualTextHeader = "Для кого самокат";
    private WebDriver driver;
    @Test
    public void checkTopOrderButton() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get(URL_ADDRESS);
        HomePageScooter objHomePage = new HomePageScooter(driver); // создал объект класса домашней страницы
        objHomePage.waitForTopButtonLoad();
        objHomePage.pushButtonInTopOfPage(); // нажали верхнюю кнопку заказать
        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        Assert.assertEquals(objOrderPageScooter.orderPageIsOpen(), actualTextHeader);

    }
    @Test
    public void checkBottomOrderButton() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get(URL_ADDRESS);
        HomePageScooter objHomePage = new HomePageScooter(driver); // создал объект класса домашней страницы
        objHomePage.pushCookieButton();
        objHomePage.waitForBottomButtonLoad();
        objHomePage.pushButtonInBottomOfPage(); // нажали нижнюю кнопку заказать
        OrderPageScooter objOrderPageScooter = new OrderPageScooter(driver);
        Assert.assertEquals(objOrderPageScooter.orderPageIsOpen(), actualTextHeader);
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
