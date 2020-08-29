package com.xufe.remotemonitor.services;

import com.xufe.remotemonitor.entity.House;
import com.xufe.remotemonitor.entity.Room;
import com.xufe.remotemonitor.entity.Temp;
import com.xufe.remotemonitor.mapper.IAdminMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ScheduleService {
    @Resource
    private IAdminMapper iAdminMapper;

    //    @Scheduled(cron = "0 * * * * 0-7")//按照分钟输出
//    @Scheduled(cron = "* * * * * 0-7") //每秒都执行
//    @Scheduled(cron = "0/5 * * * * 0-7")//每五秒执行一次
    @Scheduled(cron = "0/4 * * * * 0-7")//每四秒执行一次
    public void dynamicInsertHouseData() {
        //温度设置范围10.0-38.0之间，最大值40
        double x = 10.0;
        double y = 40.0;
        double d = x + Math.random() * y % (y - x + 1);
        String temperatureFormat = String.format("%.1f", d);
        double temperature = Double.parseDouble(temperatureFormat);

        //湿度设置范围40.0-50.0之间，最大值55
        double humidityx = 40.0;
        double humidityy = 55.0;
        double humidityd = humidityx + Math.random() * humidityy % (humidityy - humidityx + 1);
        String humidityFormat = String.format("%.1f", humidityd);
        double humidity = Double.parseDouble(humidityFormat);

        //日期
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dbDay = date.format(formatter);
//        String time = "2019-07-23";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;

        try {
            dateTime = simpleDateFormat.parse(dbDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //时间
        LocalTime time = LocalTime.now(); // get the current time
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String dbTime = time.format(timeFormatter);


        String status = "标准";
        if (temperature > 38.0) {
            status = "异常-温度高于标准38°";
        }
        if (humidity > 50.0) {
            status = "异常-湿度高于标准50%";
        }
        if (temperature > 38.0 && humidity > 50.0) {
            status = "异常";
        }

        List<Room> roomSize = iAdminMapper.findAllRooms();
        List<String> ip = new ArrayList<>();
        for(Room room:roomSize){
            ip.add(room.getIp());
        }
//        System.out.println("******=="+ip);
        Random random = new Random();
        int n = random.nextInt(ip.size());
//        System.out.println("nnn====="+n);
        String s1 = ip.get(n);
//        System.out.println("s1s1s1s1==="+s1);

        House house = new House(temperature, humidity, dateTime, dbTime, status,s1);

        if (temperature > 38.0 || humidity > 50.0) {
            Temp temp = new Temp(temperature, humidity, dbDay, dbTime, status,"未读");
            iAdminMapper.addTemp(temp);
        }
//
//        System.out.println("&&&&&&&&&&=="+house);
        iAdminMapper.addHouses(house);

        System.out.println("hello");
    }
}
