package com.xufe.remotemonitor.services.impl;

import com.xufe.remotemonitor.entity.*;
import com.xufe.remotemonitor.mapper.IAdminMapper;
import com.xufe.remotemonitor.services.IAdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.awt.print.Book;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("ims")
public class AdminServiceImpl implements IAdminService {
    @Resource
    private IAdminMapper iAdminMapper;

    private SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void addAdmin(Admin admin) {
        iAdminMapper.addAdmin(admin);
    }

    @Override
    public List<Admin> findAdminAll() {
        return iAdminMapper.findAdminAll();
    }

    @Override
    public Admin findAdminByNameAndPassword(String name, String password) {
        return iAdminMapper.findAdminByNameAndPassword(name, password);
    }

    @Override
    public List<House> findAllHouses() {
        return iAdminMapper.findAllHouses();
    }

    @Override
    public Map<String, Object> findAllHouse() {
        Map<String, Object> map = new HashMap<>();
        List<House> allHouses = iAdminMapper.findAllHouses();
        List<Double> tempperature = new ArrayList<>();
        List<Double> humidity = new ArrayList<>();
        List<Date> days = new ArrayList<>();
        List<String> time = new ArrayList<>();
        List<String> status = new ArrayList<>();
        for (House house : allHouses) {
            tempperature.add(house.getTemperature());
            humidity.add(house.getHumidity());
            days.add(house.getDay());
            time.add(house.getTime());
            status.add(house.getStatus());
        }
        map.put("tempperature", tempperature);
        map.put("humidity", humidity);
        map.put("days", days);
        map.put("time", time);
        map.put("status", status);
        return map;
    }

    @Override
    public List<House> findAllHousesByHouseIp(String num) {
        if ("{{room.num}}".equals(num) || StringUtils.isEmpty(num)) {
            num = "一号房间";
        }
        Room roomByRoomNum = iAdminMapper.getRoomByRoomNum(num);
        return iAdminMapper.findAllHousesByHouseIp(roomByRoomNum.getIp());
    }

    @Override
    public Map<String, Object> findAllHousesByHouseIpReturnMap(String num) {
//        System.out.println("NUMNUMNUMNUMNUM&^&%^#@#%^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^*====" + num);

        if ("{{room.num}}".equals(num) || StringUtils.isEmpty(num)||"null".equals(num)) {
            num = "一号房间";
        }

        Room roomByRoomNum = iAdminMapper.getRoomByRoomNum(num);
//        System.out.println("rommmmmmmmm-====" + roomByRoomNum);
//        System.out.println("333333===" + roomByRoomNum.getIp());
        Map<String, Object> map = new HashMap<>();
        List<House> allHouses = iAdminMapper.findAllHousesByHouseIp(roomByRoomNum.getIp());
        List<Double> tempperature = new ArrayList<>();
        List<Double> humidity = new ArrayList<>();
        List<String> days = new ArrayList<>();
        List<String> time = new ArrayList<>();
        List<String> status = new ArrayList<>();
        List<String> dayandtime = new ArrayList<>();
        String dayandtimestr = "";
        for (House house : allHouses) {
            tempperature.add(house.getTemperature());
            humidity.add(house.getHumidity());

            Date day = house.getDay();
            String timeString = ft.format(day);
            days.add(timeString);

            time.add(house.getTime());
            dayandtimestr = timeString+" "+house.getTime();
            dayandtime.add(dayandtimestr);
            status.add(house.getStatus());
        }
        map.put("keytempperature", tempperature);
        map.put("keyhumidity", humidity);
        map.put("keydays", days);
        map.put("keytime", time);
        map.put("keystatus", status);
        map.put("dayandtime", dayandtime);
        return map;
    }

    @Override
    public void addHouses(House house) {
        iAdminMapper.addHouses(house);
    }

    @Override
    public List<HouseRoom> findAbnormalHousesData() {
        return iAdminMapper.findAbnormalHousesData();
    }

    @Override
    public List<HouseRoom> findAbnormalHousesDataByRoomPrincipalOrRoomNum(String principal, String num) {
        return iAdminMapper.findAbnormalHousesDataByRoomPrincipalOrRoomNum(principal, num);
    }

    @Override
    public void saveRoom(Room room) {
        iAdminMapper.addRoom(room);
    }

    @Override
    public void deleteRoom(String ids) {
        String[] str = ids.split(",");
        for (String s : str) {
            Integer id = Integer.parseInt(s);
            Room roomHouseIpByDeleteId = iAdminMapper.getRoomHouseIpByDeleteId(id);
            String ip = roomHouseIpByDeleteId.getIp();
            iAdminMapper.deleteRoom(id);
            iAdminMapper.deleteHouseByHouseIp(ip);
        }
    }

    @Override
    public void updateRoom(Room room) {
        iAdminMapper.updateRoom(room);
    }

    @Override
    public Room getRoomHouseIpByDeleteId(Integer id) {
        return iAdminMapper.getRoomHouseIpByDeleteId(id);
    }

    @Override
    public List<Room> findAllRoomsList() {
        return iAdminMapper.findAllRooms();
    }


    @Override
    public Map<String, Object> findAllRoomsMap() {
        Map<String, Object> map = new HashMap<>();
        List<Room> allRooms = iAdminMapper.findAllRooms();
        List<String> roomnums = new ArrayList<>();
        for (Room room : allRooms) {
            roomnums.add(room.getNum());
        }
        List<Temp> tempAlertData = iAdminMapper.findTempAlertData();
        map.put("roomnum", roomnums);
        map.put("alertdatanum",tempAlertData.size());
        return map;
    }

    @Override
    public List<Room> findRoomsByLikeNumOrPrincipal(String num, String principal) {
        return iAdminMapper.findRoomsByLikeNumOrPrincipal(num, principal);
    }

    @Override
    public List<Temp> findTempAlertData() {
        return iAdminMapper.findTempAlertData();
    }

    @Override
    public void updataTemp() {
        iAdminMapper.updataTemp();
    }
}