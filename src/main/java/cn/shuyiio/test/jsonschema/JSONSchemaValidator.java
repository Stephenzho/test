package cn.shuyiio.test.jsonschema;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhoushuyi
 * @since 2019/3/24
 */
public class JSONSchemaValidator {


    @Test
    public void valid() throws IOException {
        // 通过文件流获取JSON Schema
        try (InputStream inputStream = getClass().getResourceAsStream("/jsonSchema.json")) {

            JSONObject jsonSchema = new JSONObject(new JSONTokener(inputStream));

            Schema schema = SchemaLoader.builder().schemaJson(jsonSchema)
                    .useDefaults(true)                      // 设置验证器开启默认值
                    .build().load().build();

            JSONObject myJson = new JSONObject("{\n" +
                    "  \"age\": 123\n" +
                    "}");

            schema.validate(myJson);       // 验证，不通过则抛出 ValidationException


            System.out.println(myJson.get("name"));     //输出默认值 stephen zho

        } catch (ValidationException e) {

            System.out.println(e);      //验证失败，输入分析结果
        }

    }

    @Test
    public void test() {
        try{

            JSONObject jsonSchema = new JSONObject("{\n" +
                    "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
                    "  \"type\": \"object\",\n" +
                    "  \"properties\": {\n" +
                    "    \"id\": {\n" +
                    "      \"type\": \"string\",\n" +
                    "      \"minLength\": 7\n" +
                    "    },\n" +
                    "    \"status\": {\n" +
                    "      \"type\": \"string\",\n" +
                    "       \"enum\": [\"EA\", \"EB\", \"EC\"]" +
                    "    }\n" +
                    "  },\n" +
                    "  \"required\": [\n" +
                    "    \"id\"\n" +
                    "  ],\n" +
                    "  \"additionalProperties\": false\n" +
                    "}");

            Schema schema = SchemaLoader.builder().schemaJson(jsonSchema)
                    .draftV7Support()           // 使用v7版本
                    .build().load().build();

            JSONObject myJson = new JSONObject("{\n" +
                    "  \"id\": \"12313123131\"\n" +
                    "}");

            schema.validate(myJson);       // 验证，不通过则抛出 ValidationException


        } catch (ValidationException e) {

            System.out.println(e);      //验证失败，输入分析结果
        }


    }

}
