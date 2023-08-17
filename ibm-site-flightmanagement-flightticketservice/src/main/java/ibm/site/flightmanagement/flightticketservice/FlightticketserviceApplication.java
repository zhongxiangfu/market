package ibm.site.flightmanagement.flightticketservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
@MapperScan("ibm.site.flightmanagement.flightticketservice.mapper")
public class FlightticketserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlightticketserviceApplication.class, args);
    }
}
