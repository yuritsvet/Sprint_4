package ru.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageScooter {
    private WebDriver driver; // создали драйвер

    // создаем локаторы для кнопок
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    private By orderButtonInTopOfPage = By.className("Button_Button__ra12g"); //кнопка заказать вверху страницы
    private By orderButtonInBottomOfPage = By.xpath("/html/body/div/div/div[1]/div[4]/div[2]/div[5]/button"); //кнопка заказать внизу страницы
    private By faqElements = By.xpath("/html/body/div/div/div/div[5]/div[2]");


    public HomePageScooter(WebDriver driver){ // конструктор класса
        this.driver = driver;
    }

    //Методы
    public void pushCookieButton(){
        driver.findElement(cookieButton).click(); //закрыли предупреждение о куках
    }
    public void pushButtonInTopOfPage() {
        driver.findElement(orderButtonInTopOfPage).click(); // нажимаем заказать вверху страницы
    }
    public void pushButtonInBottomOfPage() {
        scrollPage(orderButtonInBottomOfPage);
        driver.findElement(orderButtonInBottomOfPage).click();
    }

    public void waitForTopButtonLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderButtonInTopOfPage));
    }
    public void waitForBottomButtonLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(orderButtonInBottomOfPage));
    }
    public void scrollPage(By element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(element));
    }
    //нажатие на раскрытие элемента списка
    public void clickListElement(By elementN) {
        scrollPage(faqElements);
        driver.findElement(elementN).click();
    }

}
