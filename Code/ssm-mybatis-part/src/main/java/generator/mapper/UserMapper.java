package generator.mapper;

import generator.com.hut.pojo.User;

/**
* @author 12279
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-10-12 22:13:58
* @Entity generator.com.hut.pojo.User
*/
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
