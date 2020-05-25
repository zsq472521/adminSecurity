package club.codehero.ssm.controller;

import club.codehero.ssm.domain.Orders;
import club.codehero.ssm.service.IOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/18 21:50
 */
@Controller
@RequestMapping("/orders/")
public class OrdersController {

    @Autowired
    private IOrderService orderService;


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = orderService.findById(ordersId);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");

        return mv;
    }


    /**
     * 分页查询订单
     *
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer  size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = orderService.findAll(page, size);

        //pageInfo就是一个分页Bean
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);

        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;

    }
}