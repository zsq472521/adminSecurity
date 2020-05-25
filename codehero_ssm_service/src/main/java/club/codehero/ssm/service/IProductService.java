package club.codehero.ssm.service;

import club.codehero.ssm.domain.Product;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/17 15:45
 */
public interface IProductService {

    /**
     * 查询所有商品信息
     *
     * @return
     */
    public List<Product> findAll(int pageNum, int pageSize) throws Exception;

    /**
     * 保存产品
     *
     * @param product
     * @throws Exception
     */
    void save(Product product) throws Exception;
}
