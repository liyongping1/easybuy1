package cn.bdqn.easybuy.controller;

import cn.bdqn.easybuy.entity.OrderDetail;
import cn.bdqn.easybuy.entity.Ordey;
import cn.bdqn.easybuy.service.OrderDetailService;
import cn.bdqn.easybuy.service.OrdeyService;
import cn.bdqn.easybuy.utils.Message;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/22.
 */
@Controller
@RequestMapping("ordey")
public class OrdeyController {
    @Resource
    private OrdeyService ordeyService;

    @Resource
    private OrderDetailService orderDetailService;

    @RequestMapping("queryAll")
    public String queryAll(Integer pageNum,Integer pageSize,Integer uId, Model model) {
        PageInfo<Ordey> pageInfo = ordeyService.queryAll(pageNum,pageSize,uId);
        List<OrderDetail> detailList = orderDetailService.queryAllUserId(uId);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("detailList", detailList);
        return "ordey";
    }

    @ResponseBody
    @RequestMapping(value = "createOrder", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String createOrder(Integer ordeyId) {
        Integer n = ordeyService.createOrder(ordeyId);
        Integer m = ordeyService.deleteOrdey(ordeyId);
        if (n > 0 && m > 0) {
            return JSON.toJSONString(Message.succeed());
        }
        return JSON.toJSONString(Message.error());
    }

    @ResponseBody
    @RequestMapping(value = "deleteOrdey",method = RequestMethod.POST,
    produces = {"application/json;charset=utf-8"})
    public String deleteOrdeyIds(String ordeyIds){
        String[] ordeyId=ordeyIds.split(",");
        List<Integer> list=new ArrayList<>();
        for (String s : ordeyId) {
            list.add(Integer.parseInt(s));
        }
        Integer n=ordeyService.deleteOrderyIds(list);
        if (n > 0) {
            return JSON.toJSONString(Message.succeed());
        }
        return JSON.toJSONString(Message.error());
    }

}
