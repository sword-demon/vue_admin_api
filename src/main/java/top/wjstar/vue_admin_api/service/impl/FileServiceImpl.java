package top.wjstar.vue_admin_api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.wjstar.vue_admin_api.entity.File;
import top.wjstar.vue_admin_api.mapper.FileMapper;
import top.wjstar.vue_admin_api.service.IFileService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author wxvirus
 * @since 2023-07-04
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
