package bank;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PaymentServiceTest {

    PaymentService testedObject;
    @Before
    public void setUp(){
        testedObject = new PaymentService();
    }

    private Object[][] parametersForTestingTwoNumberInInput() {
//        Account customer1 = new Account(100 , "Ola" );
//        Account customer2 = new Account(30 , "Mieszko");
        return new Object[][]{
                {100 , 30 },
                {0,10, 1},
                {"2,3,15", 20}
        };
    }

    @Test
    public void shouldCreateObject() throws Exception
    {
        assertThat(testedObject).isNotNull();
    }

    @Test
    @Parameters (method ="IllegalArgumentExtepionWhenNotEnoughMoney")
    public void IllegalArgumentExtepionWhenNotEnoughMoney(Account customer1 ,Account customer2 ,int howMuch)
    {
        customer1 = new Account(100 , "Ola" );
        customer2 = new Account(30 , "Mieszko");

        testedObject.transferMoney(customer1 ,customer2 , 20);

        assertThat(customer1.amount).isEqualTo(80);
        assertThat(customer2.amount).isEqualTo(50);

    }

}