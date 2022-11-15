import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.scooter.HomePageScooter;

@RunWith(Parameterized.class)
public class CheckDropDownListFAQ{
    private WebDriver driver;
    private static final String URL_ADDRESS = "https://qa-scooter.praktikum-services.ru/";
    private String text;
    private  int elementNum;
    private int elementTextNum;
    public CheckDropDownListFAQ (String text, int elementNum, int elementTextNum) {
        this.text = text;
        this.elementNum = elementNum;
        this.elementTextNum = elementTextNum;
    }
    @Before public void startDriver() {
        driver = new ChromeDriver();
        driver.get(URL_ADDRESS);
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.pushCookieButton();
    }
    @Parameterized.Parameters
    public static Object[][] getTestTextData() {
        return new Object[][] {
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0, 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1, 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2, 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3, 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4, 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5, 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6, 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7, 7}
        };
    }
    @Test
    public void faqTest() {
        HomePageScooter objHomePage = new HomePageScooter(driver);

        objHomePage.clickListElement(elementNum);
        objHomePage.waitForFAQTextLoad();
        Assert.assertEquals(objHomePage.pathToString(elementTextNum), text);
    }
        @After
    public void teardown() { driver.quit(); }
}
