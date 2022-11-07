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
    private final String text1;
    private final String text2;
    private final String text3;
    private final String text4;
    private final String text5;
    private final String text6;
    private final String text7;
    private final String text8;
    public CheckDropDownListFAQ (String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8){
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.text6 = text6;
        this.text7 = text7;
        this.text8 = text8;
    }
    @Before public void startDriver() {
        driver = new ChromeDriver();
        driver.get(URL_ADDRESS);
    }
    @Parameterized.Parameters
    public static Object[][] getTestTextData() {
        return new Object[][] {
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."
                }
        };
    }
    @Test
    public void faqTest1() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.pushCookieButton();
        objHomePage.clickListElement1();
        objHomePage.waitForFAQTextLoad();
        Assert.assertEquals(text1, objHomePage.pathToString(objHomePage.listFAQTxt1));
    }
    @Test
    public void faqTest2() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.pushCookieButton();
        objHomePage.clickListElement2();
        objHomePage.waitForFAQTextLoad();
        Assert.assertEquals(text2, objHomePage.pathToString(objHomePage.listFAQTxt2));
    }
    @Test
    public void faqTest3() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.pushCookieButton();
        objHomePage.clickListElement3();
        objHomePage.waitForFAQTextLoad();
        Assert.assertEquals(text3, objHomePage.pathToString(objHomePage.listFAQTxt3));
    }
    @Test
    public void faqTest4() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.pushCookieButton();
        objHomePage.clickListElement4();
        objHomePage.waitForFAQTextLoad();
        Assert.assertEquals(text4, objHomePage.pathToString(objHomePage.listFAQTxt4));
    }
    @Test
    public void faqTest5() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.pushCookieButton();
        objHomePage.clickListElement5();
        objHomePage.waitForFAQTextLoad();
        Assert.assertEquals(text5, objHomePage.pathToString(objHomePage.listFAQTxt5));
    }
    @Test
    public void faqTest6() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.pushCookieButton();
        objHomePage.clickListElement6();
        objHomePage.waitForFAQTextLoad();
        Assert.assertEquals(text6, objHomePage.pathToString(objHomePage.listFAQTxt6));
    }
    @Test
    public void faqTest7() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.pushCookieButton();
        objHomePage.clickListElement7();
        objHomePage.waitForFAQTextLoad();
        Assert.assertEquals(text7, objHomePage.pathToString(objHomePage.listFAQTxt7));
    }
    @Test
    public void faqTest8() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.pushCookieButton();
        objHomePage.clickListElement8();
        objHomePage.waitForFAQTextLoad();
        Assert.assertEquals(text8, objHomePage.pathToString(objHomePage.listFAQTxt8));
    }
        @After
    public void teardown() { driver.quit(); }
}
