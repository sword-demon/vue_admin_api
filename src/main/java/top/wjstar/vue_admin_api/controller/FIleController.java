package top.wjstar.vue_admin_api.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.wjstar.vue_admin_api.service.IFileService;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;

/**
 * 文件上传
 * 这里如果再次使用代码生成器这里代码会被覆盖，DANGER
 */
@RestController
@RequestMapping("/file")
public class FIleController {

    @Value("${files.upload.path}")
    private String filesUploadPath;

    @Resource
    private IFileService fileService;

    /**
     * 文件上传接口
     *
     * @param file 前端传递的 file 文件
     * @return 返回文件地址链接
     * @throws IOException 抛出 IO 异常
     */
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        // 获取文件原始名称
        String originalFilename = file.getOriginalFilename();
        // 获取文件类型
        String type = FileUtil.extName(originalFilename);
        // 获取文件大小
        long size = file.getSize();

        // 先存储到磁盘
        File uploadParentFile = new File(filesUploadPath);
        // 判断配置的文件目录是否存在，不存在就创建一个目录
        if (!uploadParentFile.exists()) {
            uploadParentFile.mkdirs();
        }
        // 定义一个文件唯一的标识码
        String uuid = IdUtil.fastSimpleUUID();
        // 文件名唯一 + 文件类型要存在
        String fileUUID = uuid + StrUtil.DOT + type;
        File uploadFilePath = new File(filesUploadPath + fileUUID);
        file.transferTo(uploadFilePath);
        // 后存储到 mysql
        String url = "http://localhost:9093/file/" + fileUUID;
        top.wjstar.vue_admin_api.entity.File saveFile = new top.wjstar.vue_admin_api.entity.File();
        saveFile.setName(originalFilename);
        saveFile.setType(type);
        saveFile.setSize(size / 1024); // kb 单位 存储
        saveFile.setUrl(url);
        saveFile.setCreateTime(LocalDateTime.now());
        fileService.save(saveFile);

        return url;
    }

    @GetMapping("/{fileUUID}")
    public void download(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {
        // 使用流来生成文件
        // 根据文件的唯一标识码获取文件
        File uploadFilePath = new File(filesUploadPath + fileUUID);
        // 设置输出流的格式
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUUID, "UTF-8"));
        response.setContentType("application/octet-stream");

        // 读取文件的字节流
        os.write(FileUtil.readBytes(uploadFilePath));
        os.flush();
        os.close();
    }
}
