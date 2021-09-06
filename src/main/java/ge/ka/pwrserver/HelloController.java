package ge.ka.pwrserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ge.ka.pwrserver.model.Accelerator;
import ge.ka.pwrserver.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;

@RestController
public class HelloController {

    @Autowired
    private RestService restService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home() {
        return new Timestamp(System.currentTimeMillis()).toString();
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String Hello() throws JsonProcessingException {
        Accelerator acc = new Accelerator(0, 11, 22, 33);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(acc);
    }

    @RequestMapping(value="/acc", method = RequestMethod.GET)
    public void getAccs(){
        this.restService.doPost();
    }
}
