package club.codehero.ssm.dao;

import club.codehero.ssm.domain.Permission;
import club.codehero.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/19 23:01
 */
@Repository
public interface IRoleDao {


    /**
     * 根据用户的id查询出所有对应的角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "ROLENAME"),
            @Result(property = "roleDesc", column = "ROLEDESC"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "club.codehero.ssm.dao.IPermissionDao.findPermissionByRoleId"))

    })
    List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc)values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "club.codehero.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String id) throws Exception;

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);

    @Insert("Insert into role_permission (roleId,permissionId)values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;

    @Delete("delete from users_role where roleId = #{id}")
    void deleteFromUsers_Role(String id);

    @Delete("delete from role_permission where roleId = #{id}")
    void deleteFromRole_Permission(String id);

    @Delete("delete from role where id = #{id}")
    void deleteById(String id);
}
/*
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permissions;
    private List<User> users;
 */