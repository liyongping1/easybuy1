package cn.bdqn.easybuy.controller;

import cn.bdqn.easybuy.entity.Order;
import cn.bdqn.easybuy.entity.OrderDetail;
import cn.bdqn.easybuy.service.OrderDetailService;
import cn.bdqn.easybuy.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20.
 */
@Controller
@RequestMapping("detail")
public class OrderDetailController {
    @Resource
    private OrderDetailService orderDetailService;

    @Resource
    private OrderService orderService;

    @RequestMapping("queryAll")
    public String queryAll(Model model) {
        List<Order> olist = orderService.queryAll();
        List<OrderDetail> list=null;
        for (Order order : olist) {
           list = orderDetailService.queryAll(order.getSerialNumber());
        }
        model.addAttribute("olist", olist);
        model.addAttribute("list", list);
        return "order";
    }

    @RequestMapping("queryAllUserId")
    public String queryAllUserId(Integer uId, Model model) {
        List<OrderDetail> list = orderDetailService.queryAllUserId(uId);
        model.addAttribute("list", list);
        return "order";
    }

    @RequestMapping("getAll")
    public String getAll(Integer pageNum,Integer pageSize,Model model){
        PageInfo<Order> orderList=orderService.queryAll(pageNum,pageSize);
        List<OrderDetail> orderDetailList=orderDetailService.getAll();
        model.addAttribute("pageInfo",orderList);
        model.addAttribute("orderDetailList",orderDetailList);
        return "order";
    }

    @RequestMapping("queryAllUserIds")
    public String queryAllUserIds(Integer pageNum,Integer pageSize,Integer uId,Model model) {
        PageInfo<Order> pageInfo=orderService.queryAll(pageNum,pageSize);
        List<OrderDetail> orderDetailList=orderDetailService.queryAllUserId(uId);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("detailList",orderDetailList);
        return "myorder";
    }
}
