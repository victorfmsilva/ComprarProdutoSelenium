import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class NewTesteCompra {
    private WebDriver driver;
    private PageBase pageBase;
    private EscolherPruduto escolherPruduto;
    //private FormasDePagamento formasDePagamento;
    private AdicionarCarrinho adicionarCarrinho;
    private GarantiaEstendida garantiaEstendida;
    private ConcluirCompra concluirCompra;

    @Before
    public void before() {
       driver = new ChromeDriver();
       driver.get("https://www.casasbahia.com.br/");
       driver.manage().window().maximize();
       pageBase = new PageBase(driver);
       escolherPruduto = new EscolherPruduto(driver);
       //formasDePagamento = new FormasDePagamento(driver);
       adicionarCarrinho = new AdicionarCarrinho(driver);
       concluirCompra = new ConcluirCompra(driver);
       garantiaEstendida = new GarantiaEstendida(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test
    public void testarComprarProduct() {
        this.adicionarCarrinho.clicarBarraBuscar();
        this.adicionarCarrinho.escreverBarraBusca("moto g5");
         this.escolherPruduto.clicarProdutoSelecionado();
         this.adicionarCarrinho.clicarBtnComprar();
         //this.formasDePagamento.btnContinuarForPag();
         this.garantiaEstendida.clicarBotaoContinuar();
         this.concluirCompra.btnConcluirCompra();

    }
}

