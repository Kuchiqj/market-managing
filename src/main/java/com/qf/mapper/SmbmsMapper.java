package com.qf.mapper;

import com.qf.pojo.SmbmsUser;
import com.qf.pojo.SmbmsBill;

import java.util.HashMap;
import java.util.List;
import com.qf.pojo.SmbmsProvider;
public interface SmbmsMapper {

    //查询用户根据name属性
    public SmbmsUser selectUserByName(String userName,String userPassword);

    //查询用户列表
    public List<SmbmsUser> showList(HashMap<Object,Object> map);

    public List<SmbmsUser> showList2(HashMap<Object,Object> map);

    public SmbmsUser selectUserById(int id);

    public int addUser(SmbmsUser smbmsUser);

    public int deleteUser(int id);

    public int updateUser(SmbmsUser smbmsUser);

    public int updatePassword(SmbmsUser smbmsUser);

    public List<SmbmsProvider> showList3(HashMap<Object,Object> map1);

    public List<SmbmsProvider> showList4(HashMap<Object,Object> map1);

    public SmbmsProvider selectProviderById(int id);

    public int addProvider(SmbmsProvider smbmsProvider);

    public int deleteProvider(int id);

    public int updateProvider(SmbmsProvider smbmsProvider);

    public List<SmbmsBill> showList5(HashMap<Object, Object> map);

    //查看过去订单
    public SmbmsBill selectBillById(int id);

    //添加账单
    public int addBill(SmbmsBill smbmsBill);

    public int delectBill(int smbmsBill);

    public int updateBill(SmbmsBill smbmsBill);

    public List<SmbmsBill> selectBill1(HashMap<Object, Object> map);

}
