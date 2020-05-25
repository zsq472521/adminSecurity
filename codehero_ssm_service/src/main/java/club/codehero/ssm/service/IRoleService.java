package club.codehero.ssm.service;

import club.codehero.ssm.domain.Permission;
import club.codehero.ssm.domain.Role;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/21 10:44
 */

public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    void delete(String id) throws Exception;
}
