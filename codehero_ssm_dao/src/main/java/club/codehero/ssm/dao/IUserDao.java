package club.codehero.ssm.dao;

import club.codehero.ssm.domain.Role;
import club.codehero.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/19 21:45
 */
@Repository
public interface IUserDao {


    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "club.codehero.ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    /**
     * 添加用户
     *
     * @throws Exception
     */
    @Insert("insert into users(username,email,password,phoneNum,status)values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "club.codehero.ssm.dao.IRoleDao.findRoleByUserId"))

    })
    UserInfo findById(String id) throws Exception;

    @Select("select * from role where id not in (select roleId from users_role where userId =#{userId}) ")
    List<Role> findOtherRoles(String userId);

    @Insert("insert into users_role (userId,roleId)values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);


    @Delete("delete from users_role where userId = #{id}")
    void deleteFromUsers_Role(String id);

    @Delete("delete from users where id = #{id}")
    void deleteById(String id);
}
/*
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNum;
    private int status;
    private String statusStr;
    private List<Role> roles;
 */