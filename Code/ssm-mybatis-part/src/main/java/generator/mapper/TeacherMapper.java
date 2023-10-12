package generator.mapper;

import generator.com.hut.pojo.Teacher;

/**
* @author 12279
* @description 针对表【teacher】的数据库操作Mapper
* @createDate 2023-10-12 22:13:58
* @Entity generator.com.hut.pojo.Teacher
*/
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

}
