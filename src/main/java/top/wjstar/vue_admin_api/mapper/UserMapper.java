package top.wjstar.vue_admin_api.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.wjstar.vue_admin_api.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from sys_user")
    List<User> findAll();

    @Insert("insert into sys_user (username, password, nickname, email, phone, address) values (#{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address})")
    int addUser(User user);

    int updateUser(User user);

    // 多个参数要加 @Param 一个参数可不加
    Integer deleteById(@Param("id") Integer id);
}
