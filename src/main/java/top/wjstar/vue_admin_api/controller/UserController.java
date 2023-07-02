package top.wjstar.vue_admin_api.controller;

import org.springframework.web.bind.annotation.*;
import top.wjstar.vue_admin_api.entity.User;
import top.wjstar.vue_admin_api.mapper.UserMapper;
import top.wjstar.vue_admin_api.service.UserService;

import java.util.List;

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
    public int saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }
}
