package com.example.controller;

import com.example.model.RespBean;
import com.example.model.SysJob;
import com.example.service.SysJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 江南一点雨
 * @微信公众号 江南一点雨
 * @网站 http://www.itboyhub.com
 * @国际站 http://www.javaboy.org
 * @微信 a_java_boy
 * @GitHub https://github.com/lenve
 * @Gitee https://gitee.com/lenve
 */
@RestController
@RequestMapping("/jobs")
public class SysJobController {
    @Autowired
    SysJobService sysJobService;

    @GetMapping("/getAll")
    public List<SysJob> getAllJobs() {
        return sysJobService.getAllJobs();
    }

    @PostMapping("/add")
    public RespBean addJob(@RequestBody SysJob sysJob) {
        Boolean flag = sysJobService.addJob(sysJob);
        if (flag) {
            return RespBean.ok("作业添加成功");
        }
        return RespBean.error("作业重复，添加失败");
    }

    @PutMapping("/update")
    public RespBean updateJob(@RequestBody SysJob sysJob) {
        Boolean flag = sysJobService.updateJob(sysJob);
        if (flag) {
            return RespBean.ok("作业更新成功");
        }
        return RespBean.error("作业更新失败");
    }

    @DeleteMapping("/delete")
    public RespBean deleteJobs(Integer id) {
        Boolean flag = sysJobService.deleteJobsById(id);
        if (flag) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
