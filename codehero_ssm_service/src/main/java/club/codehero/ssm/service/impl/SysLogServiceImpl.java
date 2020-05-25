package club.codehero.ssm.service.impl;

import club.codehero.ssm.dao.SysLogDao;
import club.codehero.ssm.domain.SysLog;
import club.codehero.ssm.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/25 6:24
 */
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception{
// pageNum是页码值，参数pageSize是每一页显示条数
        PageHelper.startPage(pageNum, pageSize);
        return sysLogDao.findAll();
    }
}
