package club.codehero.ssm.dao;

import club.codehero.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author CodeHero
 * @email imissyou5201314@outlook.com
 * @date 2020/5/19 15:21
 */
@Repository
public interface IMemberDao {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id =#{id}")
    public Member findById(String id) throws Exception;
}
