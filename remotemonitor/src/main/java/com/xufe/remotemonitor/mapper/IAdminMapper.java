package com.xufe.remotemonitor.mapper;

import com.xufe.remotemonitor.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IAdminMapper {
    //admin
    //添加管理员
    void addAdmin(Admin admin);

    //查询所有管理员
    List<Admin> findAdminAll();

    //按照名字和密码查询管理员机型登录使用
    Admin findAdminByNameAndPassword(@Param("name") String name, @Param("password") String password);



    //house
    //查询所有房子内的温度和湿度信息
    List<House> findAllHouses();

    List<House> findAllHousesByHouseIp(String ip);

    void deleteHouseByHouseIp(String ip);//删除房间信息

    void addHouses(House house);//动态实时添加房间温湿度信息使用

    List<HouseRoom> findAbnormalHousesData();//查询异常数据

    List<HouseRoom> findAbnormalHousesDataByRoomPrincipalOrRoomNum(@Param("principal") String principal, @Param("num") String num);





    //room
    void addRoom(Room room);  //添加房间信息

    void deleteRoom(Integer id);//删除房间信息

    void updateRoom(Room Room);//修改房间信息

    Room getRoomHouseIpByDeleteId(Integer id);//依据删除的id获取对应的houseip的值

    Room getRoomByRoomNum(String num);//依据房间的编号获取房间信息

    List<Room> findAllRooms();//所有房间信息查询

    List<Room> findRoomsByLikeNumOrPrincipal(@Param("num") String num, @Param("principal") String principal);//根据负责人和房间编号进行查询


    //temp临时表格
    void addTemp(Temp temp);//添加临时存储的异常数据
    List<Temp> findTempAlertData();//查找为未读的数据
    void updataTemp();//修改临时存储的异常数据，将未读改为已读


}
