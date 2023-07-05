package top.wjstar.vue_admin_api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import top.wjstar.vue_admin_api.common.Result;
import top.wjstar.vue_admin_api.entity.Role;
import top.wjstar.vue_admin_api.service.IRoleService;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 控制器
 * </p>
 *
 * @author wxvirus
 * @since 2023-07-05
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private IRoleService roleService;

    @PostMapping
    public Result save(@RequestBody Role role) {
        return Result.success(roleService.saveOrUpdate(role));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.success(roleService.removeById(id));
    }

    @GetMapping
    public Result findAll() {
        return Result.success(roleService.list());
    }

    @GetMapping("/{id}")
    public Result findOne(@PathVariable Integer id) {
        return Result.success(roleService.getById(id));
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam String name) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.like("name", name);
        return Result.success(roleService.page(new Page<>(pageNum, pageSize), queryWrapper));
    }

    @PostMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        return Result.success(roleService.removeByIds(ids));
    }
}

