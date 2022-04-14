package com.example.task;

import com.alibaba.fastjson.JSON;
import com.example.config.CronTaskRegistrar;
import com.example.config.SchedulingRunnable;
import com.example.model.SysJob;
import com.example.util.UrlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2022/4/13 18:25
 * @Version 1.0
 */
@Component
public class taskDemo {
    //定义全局参数
    LocalDate date = LocalDate.now();

    @Autowired
    CronTaskRegistrar cronTaskRegistrar;

    /**
     * 随机选座功能
     * @param openid
     */
    public void random(String openid){

        System.out.println("===========开始任务============");

        //设置发送的url
        String url = "https://wplib.haut.edu.cn/seatbook/api/seatbook/random?openid=" + openid + "&starttime=" + date + "%2007%3A30%3A00&endtime=" + date + "%2022%3A00%3A00&layerid=&channel=1003&regionId=";

        //给小程序发送预约请求 并接受返回的结果
        String result = UrlUtil.send(url);
        System.out.println(result);

        //将json对象转换程map集合
        Map map = (Map) JSON.parse(result);

        System.out.println("===========结束任务============");

        /**
         * 结束任务的代码
         */
        if ((Integer) map.get("code") == 0 || (Integer) map.get("code") == 666){
            SysJob sysJob = new SysJob();
            sysJob.setBeanName("taskDemo");
            sysJob.setMethodName("random");
            sysJob.setMethodParams(openid);
            SchedulingRunnable schedulingRunnable = new SchedulingRunnable(sysJob.getBeanName(), sysJob.getMethodName(), sysJob.getMethodParams());
            cronTaskRegistrar.removeCronTask(schedulingRunnable);
        }
    }

    public void define_xml(String seatid) throws InterruptedException {
        //设置发送的url
        String url = "https://wplib.haut.edu.cn/seatbook/api/seatbook/addbooking?bookingdate=null&regionid=null&channel=1003&openid=o-WiZ5Vr4zpnjwDSsDhc9Eq3p9tE&seatid="+seatid+"&starttime="+date+"%2020%3A31%3A00&endtime="+date+"%2022%3A00%3A00";
        System.out.println("===========开始循环任务============");

        for (int i = 0; i < 1200; i++) {
            //给小程序发送预约请求 并接受返回的结果
            String result = UrlUtil.send(url);
            System.out.println(result);

            //将json对象转换程map集合
            Map map = (Map) JSON.parse(result);

            /**
             * 结束任务的代码
             */
            if ((Integer) map.get("code") == 0 || (Integer) map.get("code") == 666){
                SysJob sysJob = new SysJob();
                sysJob.setBeanName("taskDemo");
                sysJob.setMethodName("define_xml");
                sysJob.setMethodParams(seatid);
                SchedulingRunnable schedulingRunnable = new SchedulingRunnable(sysJob.getBeanName(), sysJob.getMethodName(), sysJob.getMethodParams());
                cronTaskRegistrar.removeCronTask(schedulingRunnable);
                break;
            }
            //睡眠0.5s
            Thread.sleep(500);
        }
        System.out.println("===========结束循环任务============");
    }

    public void define_lxl(String seatid) throws InterruptedException {
        //设置发送的url
        String url = "https://wplib.haut.edu.cn/seatbook/api/seatbook/addbooking?bookingdate=null&regionid=null&channel=1003&openid=o-WiZ5TOYV_W38VlkRt0mTLfDuPI&seatid="+seatid+"&starttime="+date+"%2020%3A31%3A00&endtime="+date+"%2022%3A00%3A00";
        System.out.println("===========开始循环任务============");

        for (int i = 0; i < 1200; i++) {
            //给小程序发送预约请求 并接受返回的结果
            String result = UrlUtil.send(url);
            System.out.println(result);

            //将json对象转换程map集合
            Map map = (Map) JSON.parse(result);

            /**
             * 结束任务的代码
             */
            if ((Integer) map.get("code") == 0 || (Integer) map.get("code") == 666){
                SysJob sysJob = new SysJob();
                sysJob.setBeanName("taskDemo");
                sysJob.setMethodName("define_lxl");
                sysJob.setMethodParams(seatid);
                SchedulingRunnable schedulingRunnable = new SchedulingRunnable(sysJob.getBeanName(), sysJob.getMethodName(), sysJob.getMethodParams());
                cronTaskRegistrar.removeCronTask(schedulingRunnable);
                break;
            }
            //睡眠0.5s
            Thread.sleep(500);
        }
        System.out.println("===========结束循环任务============");
    }

    public void define_zkd(String seatid) throws InterruptedException {
        //设置发送的url
        String url = "https://wplib.haut.edu.cn/seatbook/api/seatbook/addbooking?bookingdate=null&regionid=null&channel=1003&openid=o-WiZ5c3IwCyLc0g7wqWBtOD0mNY&seatid="+seatid+"&starttime="+date+"%2020%3A31%3A00&endtime="+date+"%2022%3A00%3A00";
        System.out.println("===========开始任务============");

        for (int i = 0; i < 1200; i++) {
            //给小程序发送预约请求 并接受返回的结果
            String result = UrlUtil.send(url);
            System.out.println(result);

            //将json对象转换程map集合
            Map map = (Map) JSON.parse(result);

            /**
             * 结束任务的代码
             */
            if ((Integer) map.get("code") == 0 || (Integer) map.get("code") == 666){
                SysJob sysJob = new SysJob();
                sysJob.setBeanName("taskDemo");
                sysJob.setMethodName("define_zkd");
                sysJob.setMethodParams(seatid);
                SchedulingRunnable schedulingRunnable = new SchedulingRunnable(sysJob.getBeanName(), sysJob.getMethodName(), sysJob.getMethodParams());
                cronTaskRegistrar.removeCronTask(schedulingRunnable);
                break;
            }
            //睡眠0.5s
            Thread.sleep(500);
        }
        System.out.println("===========结束循环任务============");
    }
}
