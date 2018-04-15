import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class TestDemo {
    @Test

    public void testxml(){
        when().get("http://127.0.0.1:8000/test.xml")
        .then()
                .body("shopping.category.item[0].name", equalTo("Chocolate"))
                .body("shopping.category.item.size()", equalTo(5))
                .body("shopping.category.findAll { it.@type == 'groceries'}.size()",equalTo(1))
                .body("shopping.category.item.findAll { it.price == 20}.name",equalTo("Coffee"))
                .body("**.findAll { it.price == 20}.name",equalTo("Coffee"))
                ;
    }
    @Test

    public void testjson(){

    }
    @Test

    public void testlogin(){

    }
}
