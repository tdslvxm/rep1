package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.mapper.UserMapper;
import com.tdd.online_ddketang.model.pojo.User;
import com.tdd.online_ddketang.utils.CommonUtils;
import com.tdd.online_ddketang.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public int save(Map<String,String > userInfo) {
        User user = parseUser(userInfo);
        if (user==null){
            return 0;
        }else{
            int num = userMapper.save(user);
            return  num;
        }
    }

    @Override
    public User findByPhone(String phone) {
        User user = userMapper.findByPhone(phone);
        if (user==null){
            return  null;
        }
        return user;
    }

    @Override
    public String findByPhoneAndPwd(String phone, String pwd) {
        //注意密码需要md5转换
        User user = userMapper.findByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        if (user==null){
            return null;
        }else{
            String token = JWTUtils.geneJsonWebToken(user);
            return  token;
        }
    }

    @Override
    public User findById(Integer id) {

        return userMapper.findById(id);
    }


    /**
     * 通过userInfo生成对应的user对象
     * @return
     */
    private User parseUser(Map<String,String> userInfo){
        if (userInfo.containsKey("phone")&&userInfo.containsKey("pwd")&&userInfo.containsKey("name")){
            User user = new User();
            user.setName(userInfo.get("name"));
            user.setPwd(CommonUtils.MD5(userInfo.get("pwd")));
            user.setPhone(userInfo.get("phone"));
            user.setHeadImg(getRandomImg());
            user.setCreateTime(new Date());
            return  user;
        }
        return  null;
    }

    /**
     * 放在CDN上的随机头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg(){
        int size =  headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
