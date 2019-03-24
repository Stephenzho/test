package cn.shuyiio.test.jsonschema;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhoushuyi
 * @since 2019/3/24
 */
public class JSONSchemaValidator {

    private Schema schema;



    @Before
    public void validator(){

        try (InputStream inputStream = getClass().getResourceAsStream("/jsonSchema.json")) {
            JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
            schema = SchemaLoader.load(rawSchema);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void vali() {

        try {
            schema.validate(new JSONObject("{\n" +
                    "  \"name\": \"1aaa\",\n" +
                    "  \"url\": \"http://baidu.cn\",\n" +
                    "  \"age\": 123\n" +
                    "}"));
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }


    }


}
