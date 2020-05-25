package club.codehero.ssm.dao;

import club.codehero.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/20 17:11
 */
@Repository
public interface IPermissionDao {

    // @Select("select * from permission where id in (select permissionId from role_permission where roleId= #{id})")
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;


    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission (permissionName,url)values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;


    @Select("select * from permission where id = #{id}")
    Permission findById(String id);

    @Delete("delete from permission where id = #{id}")
    void delete(String id);

    @Delete("delete from role_permission where permissionId=#{id}")
    void deleteFromRole_Permission(String id);
}

