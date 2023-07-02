package top.wjstar.vue_admin_api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import top.wjstar.vue_admin_api.entity.User;
import top.wjstar.vue_admin_api.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index() {
        return "ok";
    }

    @GetMapping("/list")
    public List<User> userList() {
        return userService.list();
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        boolean isSuccess = userService.saveOrUpdate(user);
        System.out.println(isSuccess);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    @PostMapping("/delete/batch")
    public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return userService.removeByIds(ids);
    }

    // ?pageNum=1&pageSize=10
//    @GetMapping("/page")
//    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
//        Integer offset = (pageNum - 1) * pageSize;
//        List<User> data = userMapper.selectPage(offset, pageSize);
//        Integer total = userMapper.selectTotal();
//        System.out.println(total);
//        Map<String, Object> res = new HashMap<>();
//        res.put("data", data);
//        res.put("total", total);
//        return res;
//    }

    @GetMapping("/page")
    public IPage<User> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String username) {
        log.info("pageNum: {}", pageNum);
        log.info("pageSize: {}", pageSize);
        IPage<User> page = new Page<>(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", username);
        queryWrapper.orderByDesc("id");
        IPage<User> userPage = userService.page(page, queryWrapper);
        System.out.println(userPage);
        return userPage;
    }
}
