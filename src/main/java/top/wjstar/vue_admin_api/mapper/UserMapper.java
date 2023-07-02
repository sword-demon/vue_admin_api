package top.wjstar.vue_admin_api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.wjstar.vue_admin_api.entity.User;

@Repository
public interface UserMapper extends BaseMapper<User> {

//    @Select("select * from sys_user")
//    List<User> findAll();
//
//    @Insert("insert into sys_user (username, password, nickname, email, phone, address) values (#{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address})")
//    int addUser(User user);
//
//    int updateUser(User user);
//
//    // 多个参数要加 @Param 一个参数可不加
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from sys_user limit #{offset}, #{pageSize}")
//    List<User> selectPage(Integer offset, Integer pageSize);
//
//    @Select("select count(1) from sys_user")
//    Integer selectTotal();
}
