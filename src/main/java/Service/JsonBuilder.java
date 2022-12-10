package Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonBuilder {

    public void addToJson(List<? extends Object> list) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FileWriter writer = new FileWriter("src\\main\\resources\\task.json");
        objectMapper.writeValue(writer, list);
    }
}
