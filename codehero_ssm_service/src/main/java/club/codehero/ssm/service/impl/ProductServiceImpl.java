package club.codehero.ssm.service.impl;

import club.codehero.ssm.dao.IProductDao;
import club.codehero.ssm.domain.Product;
import club.codehero.ssm.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/17 15:46
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll(int pageNum, int pageSize) throws Exception {
// pageNum是页码值，参数pageSize是每一页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
