import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class xueqiu {
    @Test
    public void testSearch(){
        useRelaxedHTTPSValidation();

        given().log().all()
              .queryParam("code","SH601318")
              .header("Cookie", "aliyungf_tc=AQAAAP6QlkRXjwsA+lBI32G68oKXfPgl; xq_a_token=229a3a53d49b5d0078125899e528279b0e54b5fe; xq_a_token.sig=oI-FfEMvVYbAuj7Ho7Z9mPjGjjI; xq_r_token=8a43eb9046efe1c0a8437476082dc9aac6db2626; xq_r_token.sig=Efl_JMfn071_BmxcpNvmjMmUP40; Hm_lvt_1db88642e346389874251b5a1eded6e3=1523745891; u=691523745891315; __utmc=1; __utmz=1.1523745891.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); device_id=b1e2544584a2fbb4a6afa5cd40f3d55c; __utma=1.1983869111.1523745891.1523745891.1523751493.2; __utmt=1; __utmb=1.1.10.1523751493; Hm_lpvt_1db88642e346389874251b5a1eded6e3=1523751494")
        .when()
              .get("https://xueqiu.com/stock/search.json")
        .then().log().all()
              .statusCode(200)
              .body("stocks.name", hasItems("中国平安"))
              .body("stocks.code",hasItems("SH601318"))
        .body("stocks.find { it.code == 'SH601318'}.name", equalTo("中国平安"))
        ;
    }
}
