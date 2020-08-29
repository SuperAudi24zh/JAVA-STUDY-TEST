package com.xufe.remotemonitor.services;

import com.xufe.remotemonitor.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IAdminService {
    //admin
    void addAdmin(Admin admin);//添加管理员

    List<Admin> findAdminAll();//查询所有管理员

    Admin findAdminByNameAndPassword(String name, String password);//按照名字和密码查询管理员机型登录使用




    //house
    List<House> findAllHouses();//查询所有房子内的温度和湿度信息

    //    void deleteHouse(Integer id);//依据id删除房子信息
    Map<String, Object> findAllHouse();//查询所有房子内的温度和湿度信息

    List<House> findAllHousesByHouseIp(String ip);//依据ip信息查询对应的房间所有信息,返回list

    Map<String, Object> findAllHousesByHouseIpReturnMap(String num);//依据ip信息查询对应的房间所有信息,返回Map

    void addHouses(House house);//动态实时添加房间温湿度信息使用

    List<HouseRoom> findAbnormalHousesData();//查询房间异常数据的具体信息
    List<HouseRoom> findAbnormalHousesDataByRoomPrincipalOrRoomNum(String principal,String num);



    //room
    void saveRoom(Room room);//添加房屋信息

    void deleteRoom(String ids);//删除房屋信息

    void updateRoom(Room room);//修改房屋信息

    Room getRoomHouseIpByDeleteId(Integer id);//依据删除的id获取对应的houseip的值

    List<Room> findAllRoomsList();
    Map<String,Object> findAllRoomsMap();//查询监控房间的所有信息

    List<Room> findRoomsByLikeNumOrPrincipal(String num, String principal);//依据监控房间编号和房间负责人进行查询


    List<Temp> findTempAlertData();//查找为未读的数据
    void updataTemp();//修改临时存储的异常数据，将未读改为已读

}
