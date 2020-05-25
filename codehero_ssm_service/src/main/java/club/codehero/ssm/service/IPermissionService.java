package club.codehero.ssm.service;

import club.codehero.ssm.domain.Permission;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/21 15:29
 */
public interface IPermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void delete(String id) throws Exception;
}
