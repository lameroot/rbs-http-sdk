package ru.rbs.http.api;

import junit.framework.TestCase;
import org.junit.Test;
import ru.rbs.http.api.client.ApiClient;
import ru.rbs.http.api.client.DefaultApiClient;
import ru.rbs.http.api.client.providers.CustomHostProvider;
import ru.rbs.http.api.domain.*;
import ru.rbs.http.api.methods.OrderStatusExtendedProcess;
import ru.rbs.http.api.methods.PaymentOrderProcess;
import ru.rbs.http.api.methods.RegisterOrderProcess;

import java.util.UUID;

public class RbsRegisterOrderTest extends TestCase {

    private ApiClient client = new DefaultApiClient.Builder()
            .setDebugMode(true)
            //.setHostsProvider(new WebRbsDevAlfaHostProvider())
            .setTimeout(40L)
            //.setHostsProvider(new TestPaymentGateAlfaHostProvider())
            //.setHostsProvider(new LocalhostHostProvider("http://localhost/payment"))
            .setHostsProvider(new CustomHostProvider("https://web.rbsdev.com/sbrfpayment"))
            .create();

    @Test
    public void testRegisterOrder() throws Exception {
        RegisterOrderParams registerOrderParams = new RegisterOrderParams("test","testPwd","https://web.rbsdev.com/alfapayment");
        registerOrderParams.setAmount(100L);
        registerOrderParams.setCurrency("810");
        registerOrderParams.setLanguage("en");
        registerOrderParams.setOrderNumber(UUID.randomUUID().toString().substring(0, 20));
        registerOrderParams.setReturnUrl("http://ya.ru");


        //registerOrderParams.setJsonParams("{\"orderNumber\":1234567890}");
        registerOrderParams.setJsonParams(new JsonParams().add("orderNumber", 1234567890).add("name", "test"));
        registerOrderParams.setPageView(PageView.DESKTOP);

        RegisterOrderProcess registerOrderProcess = client.execute(RegisterOrderProcess.Request.newInstance(registerOrderParams));
        //RegisterOrderProcess registerOrderProcess = client.execute(RegisterPreAuthOrderProcess.Request.newInstance(registerOrderParams));
        assertNotNull(registerOrderProcess);
        System.out.println(registerOrderProcess);
        System.out.println(registerOrderProcess.getOrderId());



        PaymentOrderParams paymentOrderParams = new PaymentOrderParams();
        paymentOrderParams.setUserName("test");
        paymentOrderParams.setPassword("testPwd");
        paymentOrderParams.setMdOrder(registerOrderProcess.getOrderId());
        paymentOrderParams.setPan("5555555555555599");
        //paymentOrderParams.setPan("4111111111111111");
        paymentOrderParams.setCvc("123");
        paymentOrderParams.setExpiry("201912");
        paymentOrderParams.setCardHolder("test test");
        paymentOrderParams.setLanguage("en");

        PaymentOrderProcess paymentOrderProcess = client.execute(PaymentOrderProcess.Request.newInstance(paymentOrderParams));
        assertNotNull(paymentOrderProcess);
        System.out.println(paymentOrderProcess);
        assertTrue(paymentOrderProcess.isSslPayment());

        OrderStatusExtendedParams orderStatusExtendedParams = new OrderStatusExtendedParams();
        orderStatusExtendedParams.setLanguage("en");
        orderStatusExtendedParams.setOrderId(registerOrderProcess.getOrderId());
        orderStatusExtendedParams.setUserName("test");
        orderStatusExtendedParams.setPassword("testPwd");
        OrderStatusExtendedProcess orderStatusExtendedProcess = client.execute(OrderStatusExtendedProcess.Request.newInstance(orderStatusExtendedParams));
        assertNotNull(orderStatusExtendedProcess);
        System.out.println(orderStatusExtendedProcess);
    }

}
