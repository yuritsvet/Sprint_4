import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.HomePageScooter;

public class OrderButtonsTest {
    private static final String URL_ADDRESS = "https://qa-scooter.praktikum-services.ru/";
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
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
