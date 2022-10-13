import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.HomePageScooter;

public class OrderButtonsTest {
    // класс проверки нажатия кнопок "заказать"
    private WebDriver driver;

    @Test
    public void checkOrderButtons() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePage = new HomePageScooter(driver); // создал объект класса домашней страницы
        objHomePage.waitForTopButtonLoad();

        objHomePage.pushCookieButton();
        objHomePage.pushButtonInTopOfPage(); // нажали верхнюю кнопку заказать
        driver.navigate().back();//назад
        objHomePage.waitForBottomButtonLoad();
        objHomePage.pushButtonInBottomOfPage(); // нажали нижнюю кнопку заказать
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
