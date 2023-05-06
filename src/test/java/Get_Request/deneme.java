package Get_Request;

import baseURL.a3mPojo;
import baseURL.a3mURL;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginStep;
import utilities.Driver;
import utilities.JsonToJava;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class deneme extends a3mURL {

String access_token = "eyJraWQiOiIyOGQ1MDVjMy01MDgxLTQwOGEtOGU0NC01NTgzMTYxN2EwYjQiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJib0BleGF0ZXN0LmNvbSIsInN1Yl9kZWZhdWx0X21lbWJlcnNoaXBfdHlwZV9pZCI6NSwic3ViX2lkIjoyMDQsInN1Yl9kZWZhdWx0X3N1YnNjcmlwdGlvbl9pZCI6ImEwYzQyOTgxLTFmOWYtNDI2ZC04OGVhLThkMDBjOGI1MTE1NiIsInN1Yl9hcHAiOjIsImlzcyI6Imh0dHBzOlwvXC9hM20tcWEtZ20zLnF1YXNwYXJlcGFydHMuY29tIiwic3ViX2RlZmF1bHRfb3JnX2lkIjoyNiwiYXVkIjoiMTY3Mzk4NTE4NF9aWHNOVDdDdWhUenJpamwiLCJuYmYiOjE2ODA2NDE3NDEsInN1Yl9kZWZhdWx0X29yZ19uYW1lIjoiRXhhVGVzdCIsInNjb3BlIjpbIlJPTEVfQnVzaW5lc3MgT3duZXIiLCJhcHBsaWNhdGlvbjpyZWFkIiwib3JkZXI6d3JpdGUiLCJmaWxlOndyaXRlIiwiaW52ZW50b3J5OnJlYWQiLCJyZWNlcHRpb246Y29uZmlybSIsIndpc2hsaXN0OmFwcHJvdmVkIiwiaW52b2ljZTpyZWFkIiwiaW52ZW50b3J5OndyaXRlIiwidXNlci1yb2xlOnJlYWQiLCJkYXNoYm9hcmQ6cmVhZCIsInBlcm1pc3Npb246d3JpdGUiLCJ1c2VyOndyaXRlIiwic3BlY3ByaWNlOnJlYWQiLCJhY2NvdW50aW5nOndyaXRlIiwidXNlci1vcmdhbml6YXRpb246cmVhZCIsInVzZXItZ3JvdXA6cmVhZCIsInNwZWNwcmljZTp3cml0ZSIsImNvbXBhbnk6YWRtaW4iLCJtZW1iZXJzaGlwLXR5cGU6d3JpdGUiLCJyb2xlOndyaXRlIiwicGVybWlzc2lvbjpyZWFkIiwicHVyY2hhc2luZzpjb25maXJtIiwicmVjZXB0aW9uOnJlYWQiLCJ3aXNobGlzdDpxdWFsaXR5X2NvbmZpcm0iLCJ1c2VyLWdyb3VwOndyaXRlIiwidXNlci1zdGF0dXM6cmVhZCIsImNvdW50cnk6cmVhZCIsIm1lbWJlcnNoaXAtdHlwZTpyZWFkIiwicHJvY3VyZW1lbnQ6cmVhZCIsIm9yZ2FuaXphdGlvbi1zdGF0dXM6d3JpdGUiLCJjb21wYW55OnJlYWQiLCJjb21wYW55OmZpbl9jb25maXJtIiwidXNlci1zdGF0dXM6d3JpdGUiLCJ3aXNobGlzdDpzZXRfY29kaW5nIiwidXNlci1ncm91cC10eXBlOnJlYWQiLCJ1c2VyLXJvbGU6d3JpdGUiLCJ3aXNobGlzdDpvZmZlcl9yZWFkeSIsInB1cmNoYXNpbmc6cmVhZCIsIm9yZ2FuaXphdGlvbjpyZWFkIiwid2lzaGxpc3Q6YWRtaW4iLCJvcmRlcjpyZWFkIiwidXNlci1vcmdhbml6YXRpb246d3JpdGUiLCJoYW5kbWFkZTp3cml0ZSIsIndpc2hsaXN0Om9mZmVyX2NvbmZpcm0iLCJ3aXNobGlzdDpjYW5jZWwiLCJhcHBsaWNhdGlvbjp3cml0ZSIsInN1YnNjcmlwdGlvbjpyZWFkIiwiY29tcGFueTp3cml0ZSIsImZpbGU6cmVhZCIsInVzZXI6cmVhZCIsInVzZXItZ3JvdXAtdHlwZTp3cml0ZSIsIm9yZ2FuaXphdGlvbi1ncm91cDpyZWFkIiwiaW52b2ljZTp3cml0ZSIsImhhbmRtYWRlOmNvbmZpcm0iLCJyZWNlcHRpb246d3JpdGUiLCJ3aXNobGlzdDpzZXRfcHJpY2UiLCJvcmdhbml6YXRpb246d3JpdGUiLCJyb2xlOnJlYWQiLCJtZW1iZXJzaGlwOnJlYWQiLCJ3aXNobGlzdDpzYWxlX2NvbmZpcm0iLCJvcmdhbml6YXRpb24tZ3JvdXA6d3JpdGUiLCJwdXJjaGFzaW5nOndyaXRlIiwiaW52b2ljZTpjb25maXJtIiwiY2xpZW50OndyaXRlIiwiaGFuZG1hZGU6cmVhZCIsInByb2N1cmVtZW50OndyaXRlIiwib3JnYW5pemF0aW9uLXN0YXR1czpyZWFkIiwiY29tcGFueTpxdWFsX2NvbmZpcm0iLCJwdXJjaGFzaW5nOnJlYWRfY29zdCIsIm1lbWJlcnNoaXA6d3JpdGUiLCJhY2NvdW50aW5nOnJlYWQiLCJvcmRlcjpjb25maXJtIiwic3Vic2NyaXB0aW9uOndyaXRlIiwid2lzaGxpc3Q6cmVhZCIsImNsaWVudDpyZWFkIl0sInN1Yl9kZWZhdWx0X3JvbGVfaWQiOjUsImV4cCI6MTY4MDY0MzU0MSwiaWF0IjoxNjgwNjQxNzQxfQ.Up-cuVr_QbTYw6S0fUOurQxuhtsXaIVQi0Qkf7C2ADf77jqNxAKBw19R1owQYe3Xr2TBaZgEq3HX57C6br5c7eHKUsHc6dqpII-mvU2ZWdEh5LV_mrfPfERZQrC6etm9S8bK9un_UKjr1bP_5LimTjGp461OEVgRO5UP_fGsn3UuVO30cW4tMUe8k4379xWGxFVueCkjPmdaGzEFJol4VgjGdN7VKtyvhyYYhMKwYAilX88QjBOrJsqnGaW5IGRH8iLSpee18lxpqvIzLPG-FEpF3GaD_MJxBSc8tWOEx4ktgiIuMK_foAxYPLuNjPO4nlyr-a_u_jTaQmnia9tYRA";
HashMap<String, Object> userData;


    @Test
    public void GET_TC001_GetAllUsers(){
        specification.pathParam("userPath","user");
//        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user";
        Response response = given().
                spec(specification).
                when().
                header("Authorization","Bearer "+access_token).
                get("/{userPath}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }



    @Test
    public void GET_TC002_GetAllUsersofOrganization(){
        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user?organizationId=1";
        Response response = given().
                when().
                header("Authorization","Bearer "+access_token).
                get(URL);
       //response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }

    @Test
    public void POST_TC003_AddNewUser(){
        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/organization/1/application/2/role/5/user";
        a3mPojo pj = new a3mPojo("00","Celine","Dion","CelineD","celine@xxx.com","123456789","Adana","TR");
        Response response = given().
                contentType(ContentType.JSON).
                header("Authorization","Bearer "+access_token).
                body(pj).
                when().
                post(URL);

        response.prettyPrint();
        userData = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("actualDataMap = " + userData);

        response.then().assertThat().statusCode(201);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }
    @Test
    public void GET_TC004_GetUserbyId(){
        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user/336";
        Response response = given().
                when().
                header("Authorization","Bearer "+access_token).
                get(URL);
        response.prettyPrint();
        userData = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        System.out.println("userData.get(\"id\") = " + userData.get("id"));
        System.out.println("userData.get(\"email\") = " + userData.get("email"));
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }
    @Test
    public void POST_TC005_SendEmailVerification(){
        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user/send-verification-request?organizationId=1&appId=2";
           a3mPojo reqBody = new a3mPojo("336","celine@xxx.com");
        Response response = given().
                contentType(ContentType.JSON).
                header("Authorization","Bearer "+access_token).
               body(reqBody).
                when().
                post(URL);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }

    @Test
    public void PUT_TC007_UpdateExistingUser(){
                String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user";
       a3mPojo pj = new a3mPojo("476","hüsnüüü","sülüüüü","birsen@example.com","birsen@example.com","123456789","Bursa","TR");
        Response response = given().
                contentType(ContentType.JSON).
                header("Authorization","Bearer "+access_token).
                body(pj).
                when().
                put(URL);

        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }





    @Test
    public void DELETE_TC008_UpdateExistingUser(){
        String URL = "https://a3m-qa-gm3.quaspareparts.com/auth/api/user/335";
        Response response = given().
                header("Authorization","Bearer "+access_token).
                when().
                delete(URL);

        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
    }
}
