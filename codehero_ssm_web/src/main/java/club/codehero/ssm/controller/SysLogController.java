package club.codehero.ssm.controller;

import club.codehero.ssm.domain.Product;
import club.codehero.ssm.domain.SysLog;
import club.codehero.ssm.service.ISysLogService;
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
 * @date 2020/5/25 9:09
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        List<SysLog> sysLogs = sysLogService.findAll(page, size);
        ModelAndView mv = new ModelAndView();

        //pageInfo就是一个分页Bean
        PageInfo<SysLog> pageInfo = new PageInfo<>(sysLogs);

        mv.addObject("pageInfo", pageInfo);

        mv.setViewName("syslog-list");
        return mv;

    }
}
