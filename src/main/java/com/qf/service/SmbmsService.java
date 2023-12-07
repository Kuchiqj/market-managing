package com.qf.service;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.SmbmsBill;
import com.qf.pojo.SmbmsProvider;
import com.qf.pojo.SmbmsUser;

import java.util.HashMap;


public interface SmbmsService {

    //登录（查询用户）
    public SmbmsUser login(String userName,String userPassword);

    //用户查询列表
    public PageInfo<SmbmsUser> showList(Integer pageNum, HashMap<Object,Object> map);

    public PageInfo<SmbmsUser> showList2(Integer pageNum, HashMap<Object,Object> map);


    public SmbmsUser selectUserById(int id);

    //添加用户
    public boolean addUser(SmbmsUser smbmsUser);

    //删除用户
    public int deleteUser(int id);

    //修改用户
    public boolean updateUser(SmbmsUser smbmsUser);

    //修改密码
    public boolean updatePassword(SmbmsUser smbmsUser);

    public PageInfo<SmbmsProvider> showList3(Integer pageNum, HashMap<Object,Object> map1);

    public PageInfo<SmbmsProvider> showList4(Integer pageNum, HashMap<Object,Object> map1);

    public SmbmsProvider selectProviderById(int id);

    public boolean addProvider(SmbmsProvider smbmsProvider);

    public int deleteProvider(int id);

    public boolean updateProvider(SmbmsProvider smbmsProvider);

    public boolean addBill(SmbmsBill smbmsBill);

    public PageInfo<SmbmsBill> showList5(Integer pageNum, HashMap<Object, Object> map);

    public SmbmsBill selectBillById(int id);

    public int delectBill(int id);

    public boolean updateBill(SmbmsBill smbmsBill);

    public PageInfo<SmbmsBill> selectBill1(Integer pageNum,HashMap<Object,Object> map);
}
