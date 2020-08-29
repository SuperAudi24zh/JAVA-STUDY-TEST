package com.xufe.remotemonitor.actions;

import com.google.gson.Gson;
import com.xufe.remotemonitor.entity.Admin;
import com.xufe.remotemonitor.entity.House;
import com.xufe.remotemonitor.entity.HouseRoom;
import com.xufe.remotemonitor.entity.Room;
import com.xufe.remotemonitor.services.IAdminService;
import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//@Controller
//public class MovieAction {
//    @Value("${web.upload}")
//    private String path;
//    private Map<String,Object> map = new HashMap<>();
//    @Resource
//    private IMovieService ims;
@Controller
public class AdminAction {
    @Resource
    private IAdminService ims;

    // 管理员登录
    @RequestMapping("/adminlogin.action")
    public @ResponseBody
    String adminLogin(String username, String password) {
        Admin admin = ims.findAdminByNameAndPassword(username, password);
        if (admin != null) {
            return "成功";
        } else {
            return "失败";
        }
    }

    @RequestMapping("/findAllHouses.action")
    public @ResponseBody
    List<House> findAllHouses() {
        return ims.findAllHouses();
    }

    @RequestMapping("/findAllHouse.action")
    public @ResponseBody
    Map<String, Object> findAllHouse() {
        return ims.findAllHouse();
    }


    @RequestMapping("/findAlertHouses.action")
    public @ResponseBody
    List<HouseRoom> findAlertHouses() {
        System.out.println("1111111====" + ims.findAbnormalHousesData());
        return ims.findAbnormalHousesData();
    }

    @RequestMapping("/findAbnormalHousesDataByRoomPrincipalOrRoomNum.action")
    public @ResponseBody
    List<HouseRoom> findAbnormalHousesDataByRoomPrincipalOrRoomNum(String principal, String num) {
//        System.out.println("1111111===="+ims.findAbnormalHousesDataByRoomPrincipalOrRoomNum());
        return ims.findAbnormalHousesDataByRoomPrincipalOrRoomNum(principal, num);
    }


    @RequestMapping("/findAllRoomNums.action")
    public @ResponseBody
    String findRoomNums() {
//        System.out.println("***********&&&&&&&&&&&&&^^^^^^^^^^^^");
        Gson gson = new Gson();
//        String s = gson.toJson(ims.findAllRooms());
//        response.getWriter().print(gson.toJson(list));
        return gson.toJson(ims.findAllRoomsMap());
    }

    @RequestMapping("/findRooms.action")
    public @ResponseBody
    List<Room> findRooms() {
        return ims.findAllRoomsList();
    }


    @RequestMapping("/addRoom.action")
    public @ResponseBody
    String addRooms(Room room) {
//        System.out.println(room);
        ims.saveRoom(room);
        return "添加成功";
    }


    @RequestMapping("/updateRoom.action")
    public @ResponseBody
    String updateRoom(Room room) {
//        System.out.println("111");
//        System.out.println(room);
        ims.updateRoom(room);
        return "修改成功";
    }


    @RequestMapping("/deleteRoom.action")
    public @ResponseBody
    String deleteRoom(String ids) {
        ims.deleteRoom(ids);
        return "删除成功";
    }


    @RequestMapping("/findRoomsByLikeNumOrPrincipal.action")
    public @ResponseBody
    List<Room> findRoomsByLikeNumOrPrincipal(String num, String principal) {
        return ims.findRoomsByLikeNumOrPrincipal(num, principal);
    }

    @RequestMapping("/findAllHousesByHouseIp.action")
    public @ResponseBody
    Map<String, Object> findAllHouseByHouseIp(String num) {
//        System.out.println("11111111111111=="+num);
        return ims.findAllHousesByHouseIpReturnMap(num);
    }


    @RequestMapping("/updatetempisreader.action")
    public @ResponseBody String updatealertdatatempisreader() {
        ims.updataTemp();
        return "已标记";
    }
}
