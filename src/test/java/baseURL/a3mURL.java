package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class a3mURL {
    protected RequestSpecification specification;

    @Before
    public void setUpBaseURL(){
        specification = new RequestSpecBuilder().setBaseUri("https://a3m-qa-gm3.quaspareparts.com/auth/api").build();
    }
}
