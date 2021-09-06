package ge.ka.pwrserver;

import ge.ka.pwrserver.model.Accelerator;
import ge.ka.pwrserver.model.Gyroscope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageExecutor {
    public Map<String, Runnable> selector = new HashMap();
    private String payload;

    public MessageExecutor() {
        this.selector.put("testtopic", () -> this.handleTesttopic());
        this.selector.put("testtopic2", () -> this.handleTesttopic2());
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    private void handleTesttopic2() {
        System.out.println("TEST2");
    }

    private void handleTesttopic() {
        String[] data = this.payload.split("/");
        int chiptime = Integer.valueOf(data[0].toString().substring(1));
        Accelerator acc = new Accelerator(chiptime, Double.valueOf(data[4]), Double.valueOf(data[5]), Double.valueOf(data[6]));
        Gyroscope gyr = new Gyroscope(chiptime, Double.valueOf(data[1]), Double.valueOf(data[2]), Double.valueOf(data[3]));
        System.out.println(acc);
        System.out.println(gyr);
    }
}
