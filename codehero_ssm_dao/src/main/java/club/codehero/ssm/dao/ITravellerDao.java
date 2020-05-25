package club.codehero.ssm.dao;

import club.codehero.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/19 15:27
 */
@Repository
public interface ITravellerDao {

    /**
     * 通过中间表根据ordersId查询
     *
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId} )")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
