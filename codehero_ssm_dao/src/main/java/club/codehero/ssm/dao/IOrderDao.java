package club.codehero.ssm.dao;

import club.codehero.ssm.domain.Member;
import club.codehero.ssm.domain.Orders;
import club.codehero.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/18 22:00
 */
@Repository
public interface IOrderDao {

    /**
     * 查询所有订单
     *
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "club.codehero.ssm.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    /**
     * 根据id查询详情
     *
     * @param ordersId
     * @return
     */
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "club.codehero.ssm.dao.IProductDao.findById")),
            @Result(property = "member", column = "memberId", javaType = Member.class, one = @One(select = "club.codehero.ssm.dao.IMemberDao.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many = @Many(select = "club.codehero.ssm.dao.ITravellerDao.findByOrdersId"))


    })
    Orders findById(String ordersId);
}
