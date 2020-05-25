package club.codehero.ssm.service.impl;

import club.codehero.ssm.dao.IPermissionDao;
import club.codehero.ssm.domain.Permission;
import club.codehero.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/21 15:30
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public void delete(String id) throws Exception {
        permissionDao.deleteFromRole_Permission(id);
        permissionDao.delete(id);
    }

    @Override
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }
}
