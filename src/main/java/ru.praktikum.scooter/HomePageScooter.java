package ru.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomePageScooter {
    private WebDriver driver;
    // создаем локаторы для кнопок
    private By cookieButton = By.className("App_CookieButton__3cvqF");
    private By orderButtonInTopOfPage = By.className("Button_Button__ra12g"); //кнопка заказать вверху страницы
    private By orderButtonInBottomOfPage = By.xpath("/html/body/div/div/div[1]/div[4]/div[2]/div[5]/button"); //кнопка заказать внизу страницы
    private By faqElements = By.xpath("/html/body/div/div/div/div[5]/div[2]");
    // выдадающие поля FAQ
    private By listFAQElement1 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]");
    public By listFAQTxt1 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[1]/div[2]/p");

    private By listFAQElement2 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]");
    public By listFAQTxt2 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[2]/div[2]/p");

    private By listFAQElement3 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]");
    public By listFAQTxt3 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[3]/div[2]/p");

    private By listFAQElement4 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]");
    public By listFAQTxt4 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[4]/div[2]/p");

    private By listFAQElement5 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]");
    public By listFAQTxt5 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[5]/div[2]/p");

    private By listFAQElement6 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]");
    public By listFAQTxt6 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[6]/div[2]/p");

    private By listFAQElement7 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]");
    public By listFAQTxt7 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[7]/div[2]/p");

    private By listFAQElement8 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]");
    public By listFAQTxt8 = By.xpath("/html/body/div/div/div/div[5]/div[2]/div/div[8]/div[2]/p");


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
    public void waitForFAQTextLoad() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(faqElements));
    }
    //нажатие на раскрытие элемента списка
    public void clickListElement1() {
        scrollPage(faqElements);
        driver.findElement(listFAQElement1).click();
    }
    public void clickListElement2() {
        scrollPage(faqElements);
        driver.findElement(listFAQElement2).click();
    }
    public void clickListElement3() {
        scrollPage(faqElements);
        driver.findElement(listFAQElement3).click();
    }
    public void clickListElement4() {
        scrollPage(faqElements);
        driver.findElement(listFAQElement4).click();
    }
    public void clickListElement5() {
        scrollPage(faqElements);
        driver.findElement(listFAQElement5).click();
    }
    public void clickListElement6() {
        scrollPage(faqElements);
        driver.findElement(listFAQElement6).click();
    }
    public void clickListElement7() {
        scrollPage(faqElements);
        driver.findElement(listFAQElement7).click();
    }
    public void clickListElement8() {
        scrollPage(faqElements);
        driver.findElement(listFAQElement8).click();
    }
    public String pathToString(By elementPath){
        return driver.findElement(elementPath).getText();
    }

}
