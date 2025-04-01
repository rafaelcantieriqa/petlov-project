package br.com.rocketskills.petlov.tests;


import br.com.rocketskills.petlov.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

class HomeTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://petlov.vercel.app");
        homePage = new HomePage(driver);
    }

    @Test
    @DisplayName("Deve exibir o slogan do site")
    void testSlogan() {
        String expectedSlogan = "Conectando corações, mudando vidas!";
        assertEquals(expectedSlogan, homePage.getSloganText(), "Verificando o Slogan");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
