package club.codehero.ssm.controller;

import club.codehero.ssm.domain.Product;
import club.codehero.ssm.service.IProductService;
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
 * @date 2020/5/18 10:31
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll(page, size);

        //pageInfo就是一个分页Bean
        PageInfo<Product> pageInfo = new PageInfo<>(productList);

        mv.addObject("pageInfo", pageInfo);

        mv.setViewName("product-list");
        return mv;

    }

    /**
     * 产品添加
     *
     * @param product
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }
}
