package com.xuesran.services.hello.common.utils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;

public class AliPayTest {


    public static void main(String[] args) throws AlipayApiException {

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
                "2021001140610795",
                "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCQ24rpWUpKWsowlx0E+Iy7l1LLNbVWa0SsIf+0/1QQMM0trKqEBUrIK1N50Ug0lGM0pqDjnxkmAskxKb7inQ/x5YqlmGkD4uvDRJ96OMIETQa6o6Ky0SDfl3+8KAiZL4ElyQ2vN2Kv2KI9+p9PvVm2fqN6uh84OISaHcIp19fZp5MkJTjzm/1Cg88XAeFxBwVZb1m/JagpK4YdJCaNjHGHwXpwrjyr7vX6e0GfjHa7D9QbXAVMBOcsO49c9xeA2JzGGypT7aa6EcmOWj7DSaI4F78yN0p1+pSRbIAlBkqPgHM08f/1DQMVkPCeUOc73y9JT4bqxVphhX/jRw2K8ARpAgMBAAECggEAf2cX/bPyiwLe4W2GsGCKJlMpFmDeZGtjsqEUbPRD0xmY25sJPaQJ6ZNxj6ppfxUjS6NhzdCYJb49hWfZ4yWQaIgiMRKjCjACe3NXb/+LZIz6ZhyVdABKkVyFk88CAPiu9bSmvHxR56b4ytoqU8+Nn9wxnDcmTiQnPAUASBz2Uw6kRm4ZIAlbKyPS6IfuInyEkPedy3wpPabwDXQun/wALCjKumRA68W1tyPbwODNq/VvVLlDviPSo7bd5g0TCWTV65TfyAFuuKsnhkMNrTzOJxDmA/kktA37ljk93ZNQFdXJn5XMed2iaWQfgMqm2AaJTBl9UplxvvZxkhViP73hIQKBgQDKl6FxCKyT5KS1VNyDQyCSeEPLXUIJzUlUSrtXJaf6wLe9B3eFCH0eQmuieVukWcwyYufCVy3t3K1bK5t2infqsXZPYkcZC5lvRzBM5noubkysnFeUPuIJzAFWOKsQq8erRlGAKgyP57wFME154hY/YdTTRVR2E0JT9qrBAQjrDwKBgQC3C5AKgsh9tLajvbEm/TYKyQauPWPmTQfnMAO06rSaagyoikwpzI9cuZ4NWE32q92AWPHKQrmxZfgB90BxW5sTbvN4XA9pJX2A9v6mkkFrmVVWEo4zcEDM1wU+N3ahfhPQQg5XtzOhhAAoIVQDR3ZttRWJ/GP5jSa1f1uT9/D5BwKBgFkLPl0VJ+008KP2sZlL9tQJ4hpPWgg+330Z/691EJjo/Zkq4ABr07pqDS7zUjExesumpyDG+pvyg4tv5ju67qwL5elMU92ROJYtXvBd2NPxjOfNK70vyl/t96Ry8dU4+2CvXoELekwB2aUaLuNkWMzw7f8SGOZw3pVS9IgyMT5HAoGBAKre1lWZhIMkQSJVH5wf32TuB5h7olgILIp53dvzBSjoOmzSvQp/9IxAkfQvLIhKI3l+jiebZjDd2UgsgTHQq9DWT91ZQuGKp7/N0iW4fe1ts6WnqKsH7NXLGw/bQpi6UtCj+TOUx1PNH0BW7FArU7hRxIuM2d7JDwt6mghk+cPdAoGAaXQ9eLJHd9/I9GaS3QAVQe9cBzh/13f4yhPNVL29nudcDj7OIB76KK01CqneKp2WhQtT7Kt0CdCtmrBNqA2YEPIhVVVsv+e6LqFtAPDDyEdyal/zzn2yvJ7ZaZJmG7ljJR2yUbmfPVmaR9YMW14F32ZkSlrqgNaKDaaVBPSzqQI=",
                "json",
                "GBK",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhlQBJiAtwhIaW9ZjKcbNXmCGb6Wg4jmOpmoSf1EwutjS55qqV0kQOwz9Up3YYP63pQYet/amqa5H71wkOhwGdMAlywfWkTBwIQSny81uPVa1WlwZJbhKW1YD3J+qyD5Y7qODjgmBFDT2y4D5tmQDKgOkKNymK3f0PKXYf8m62gx70McFne5LmwlVroRC9jTTM/fOWQDXny4l/eBnOmwTvEualT8Lg8QvDedU0Tpc4RVoUcwiYaVgsjm5LqtRSdrO9HLyc9GE7b4dV0gGFvVbq7FELizMnQIYD31tIWHYDoq4h8YShNOph8sPwQz0LhbJt0j3apmZtC7foNk1Fdcx8wIDAQAB",
                "RSA2");
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        model.setOutTradeNo("111");
        model.setTradeNo("222");
        request.setBizModel(model);

        AlipayTradeQueryResponse response = alipayClient.execute(request);
        System.out.println(JsonUtil.obj2Json(response));
        if(response.isSuccess()){
            System.out.println("调用成功");
        } else {
            System.out.println("调用失败");
        }
    }
}
