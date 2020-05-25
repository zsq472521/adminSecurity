package club.codehero.ssm.service;

import club.codehero.ssm.domain.SysLog;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/25 6:23
 */
public interface ISysLogService {

    public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception;
}
