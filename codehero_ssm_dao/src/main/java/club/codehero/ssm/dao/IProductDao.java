package club.codehero.ssm.dao;

import club.codehero.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/17 15:40
 */
public interface IProductDao {

    /**
     * 查询所有商品信息
     *
     * @return
     */
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    /**
     * 保存产品
     *
     * @param product
     */
    @Insert("insert into " +
            "product(PRODUCTNUM,PRODUCTNAME,CITYNAME,DEPARTURETIME,PRODUCTPRICE,PRODUCTDESC,PRODUCTSTATUS)" +
            " values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    /**
     * 根据id查询产品
     *
     * @param id
     * @return
     */
    @Select("select * from product where id =#{id}")
    Product findById(String id) throws Exception;

}
