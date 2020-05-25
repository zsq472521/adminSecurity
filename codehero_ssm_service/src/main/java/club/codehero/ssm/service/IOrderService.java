package club.codehero.ssm.service;

import club.codehero.ssm.domain.Orders;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/18 21:56
 */

public interface IOrderService {

    /**
     * 查询所有订单
     *
     * @return
     */
    List<Orders> findAll(int pageNum, int pageSize) throws Exception;

    /**
     * 根据id查询订单
     *
     * @param ordersId
     */
    Orders findById(String ordersId) throws Exception;
}
