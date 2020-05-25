package club.codehero.ssm.service.impl;

import club.codehero.ssm.dao.IOrderDao;
import club.codehero.ssm.domain.Orders;
import club.codehero.ssm.service.IOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/18 21:59
 */
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<Orders> findAll(int pageNum, int pageSize) throws Exception {
        // pageNum是页码值，参数pageSize是每一页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return orderDao.findById(ordersId);
    }
}
