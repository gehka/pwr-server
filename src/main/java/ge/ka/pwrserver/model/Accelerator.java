package ge.ka.pwrserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Accelerator {

    private int Id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Timestamp time;
    private int chiptime;
    private double x_axis;
    private double y_axis;
    private double z_axis;

    public Accelerator() {
    }

    public Accelerator(int chiptime, double x_axis, double y_axis, double z_axis) {
        this(new Timestamp(System.currentTimeMillis()), chiptime, x_axis, y_axis, z_axis);
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.z_axis = z_axis;
    }

    public Accelerator(Timestamp time, int chiptime, double x_axis, double y_axis, double z_axis) {
        this.time = time;
        this.chiptime = chiptime;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.z_axis = z_axis;
    }

    public Accelerator(int id, Timestamp time, int chiptime, double x_axis, double y_axis, double z_axis) {
        Id = id;
        this.time = time;
        this.chiptime = chiptime;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.z_axis = z_axis;
    }

    @Override
    public String toString() {
        return "Accelerator{" +
                "Id=" + Id +
                ", chiptime=" + chiptime +
                ", time=" + time +
                ", x_axis=" + x_axis +
                ", y_axis=" + y_axis +
                ", z_axis=" + z_axis +
                '}';
    }
}
