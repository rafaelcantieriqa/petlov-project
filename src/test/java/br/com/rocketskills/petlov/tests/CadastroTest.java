package br.com.rocketskills.petlov.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import br.com.rocketskills.petlov.pages.CadastroPage;

class CadastroTest {
    private WebDriver driver;
    private CadastroPage cadastroPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://petlov.vercel.app/signup");
        cadastroPage = new CadastroPage(driver);
    }

    @Test
    @DisplayName("Deve poder cadastrar um ponto de doação")
    void createPoint() {
        assertEquals("Cadastro de ponto de doação", cadastroPage.getTitleText(), "Verificando o título da página de cadastro");

        cadastroPage.fillForm("rafa point", "rafa@yahoo.com", "04534011", "1000", "Ao lado da padaria");
        cadastroPage.selectCategory();
        cadastroPage.submitForm();

        String expectedMessage = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";
        assertEquals(expectedMessage, cadastroPage.getSuccessMessage(), "Verificando a mensagem de sucesso.");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
