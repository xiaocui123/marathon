package com.marathon.manage.controller;

import com.marathon.manage.pojo.ActivityFileResource;
import com.marathon.manage.service.FileResourceService;
import com.marathon.manage.vo.BaseResultBean;
import com.marathon.manage.vo.ResultEnum;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/fileresource")
public class FileResourceController {

    @Autowired
    private FileResourceService fileResourceService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    @ResponseBody
    public ActivityFileResource add(@RequestParam("file") MultipartFile file, String activityId) throws IOException {
        ActivityFileResource fileResource = new ActivityFileResource();
        if (!file.isEmpty()) {
            InputStream in = null;
            OutputStream out = null;

            try {
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                in = file.getInputStream();
                out = new FileOutputStream(serverFile);
                byte[] b = new byte[1024];
                int len = 0;
                while ((len = in.read(b)) > 0) {
                    out.write(b, 0, len);
                }

                fileResource.setFileResourceId(UUID.randomUUID().toString());
                fileResource.setFileResourceDate(new Date());
                fileResource.setFileResourceName(file.getOriginalFilename());
                fileResource.setFileResourceType("0");
                fileResource.setFileResourceUrl(serverFile.getAbsolutePath());
                if (StringUtils.isNotEmpty(activityId)) {
                    fileResource.setActivityId(activityId);
                }
                fileResourceService.addFileResource(fileResource);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(in);
                IOUtils.closeQuietly(out);
            }
        }
        return fileResource;
    }

    @RequestMapping("/deleteFile")
    @ResponseBody
    public BaseResultBean deleteFile(@RequestBody ActivityFileResource fileResource) {
        BaseResultBean result = new BaseResultBean();
        try {
            Files.deleteIfExists(Paths.get(fileResource.getFileResourceUrl()));
            fileResourceService.delete(fileResource.getFileResourceId());
        } catch (IOException e) {
            result.setEnum(ResultEnum.SUCCESS);
        }
        return result;
    }
}
