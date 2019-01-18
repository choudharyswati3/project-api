import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.omg.CORBA.ServiceDetailHelper;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Operations {

    static  String strPost = "{\n" +
            "   \"title\": \"swati\",\n" +
            "   \"body\": \"uuuu\",\n" +
            "   \"userId\": 10\n" +
            "}";

    static  String strPut = "{\n" +
            "\"id\": 1,\n" +
            "      \"title\": \"foo\",\n" +
            "      \"body\": \"bar\",\n" +
            "      \"userId\": 1\n"+
            "}";

    static  String url = "https://jsonplaceholder.typicode.com/posts";
    static  String url2 = "https://jsonplaceholder.typicode.com/posts/1";

    static  Map<String,String> map =new HashMap<String, String>();


    public static void main(String[] args) {

        map.put("content-type","application/json");
        map.put("charset","UTF-8");

        Operations operations = new Operations();
        operations.post(url);
        operations.get(url2);
        operations.put(url2);
        operations.del(url2);


        }

        public static void post(String url)
        {
            //to post
            Response response = given().headers(map).body(strPost).
                    when().post(url).
                    then().assertThat().statusCode(201).extract().response();
            System.out.println(response.getBody().asString());
        }

        public static void get(String url2)
        {
            //to get
            Response response1 = given().headers(map).
                    when().get(url2).
                    then().extract().response();
            System.out.println(response1.getBody().asString());

        }

        public static void put(String url2)
        {
            //to put
            Response response2 = given().headers(map).body(strPut).
                    when().put(url2).
                    then().extract().response();
            System.out.println(response2.getBody().asString());

        }

        public static void del(String url2)
        {
            //to delete
            Response response3 = given().headers(map).headers(map).
                    when().delete(url2).
                    then().assertThat().statusCode(200).extract().response();
            System.out.println(response3.getBody().asString());

        }
}
