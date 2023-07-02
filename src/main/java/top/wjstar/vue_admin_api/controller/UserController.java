package top.wjstar.vue_admin_api.controller;

import org.springframework.web.bind.annotation.*;
import top.wjstar.vue_admin_api.entity.User;
import top.wjstar.vue_admin_api.mapper.UserMapper;
import top.wjstar.vue_admin_api.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserMapper userMapper;

    private final UserService userService;

    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping
    public String index() {
        return "ok";
    }

    @GetMapping("/list")
    public List<User> userList() {
        return userMapper.findAll();
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        boolean isSuccess = userService.saveOrUpdate(user);
        System.out.println(isSuccess);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        boolean b = userService.removeByMap(map);
        System.out.println(b);
    }

    // ?pageNum=1&pageSize=10
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        Integer offset = (pageNum - 1) * pageSize;
        List<User> data = userMapper.selectPage(offset, pageSize);
        Integer total = userMapper.selectTotal();
        System.out.println(total);
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
