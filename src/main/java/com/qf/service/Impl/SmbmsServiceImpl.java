package com.qf.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.mapper.SmbmsMapper;
import com.qf.pojo.SmbmsBill;
import com.qf.pojo.SmbmsUser;
import com.qf.pojo.SmbmsProvider;
import com.qf.service.SmbmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SmbmsServiceImpl implements SmbmsService {

    @Autowired
    public SmbmsMapper smbmsMapper;

    @Override
    public SmbmsUser login(String userName,String userPassword){
        SmbmsUser smbmsUser = smbmsMapper.selectUserByName(userName,userPassword);

        return smbmsUser;

    }

    @Override
    public PageInfo<SmbmsUser> showList(Integer pageNum, HashMap<Object, Object> map) {
        //设置分页的内容
        PageHelper.startPage(pageNum,5);

        List<SmbmsUser> smbmsUsers = smbmsMapper.showList(map);

        PageInfo<SmbmsUser> userPageInfo = new PageInfo<>(smbmsUsers);
        return userPageInfo;
    }

    @Override
    public PageInfo<SmbmsUser> showList2(Integer pageNum, HashMap<Object, Object> map) {
        //设置分页的内容
        PageHelper.startPage(pageNum,5);

        List<SmbmsUser> smbmsUsers = smbmsMapper.showList2(map);

        PageInfo<SmbmsUser> userPageInfo = new PageInfo<>(smbmsUsers);

        return userPageInfo;
    }

    @Override
    public PageInfo<SmbmsProvider> showList3(Integer pageNum, HashMap<Object, Object> map1) {

        PageHelper.startPage(pageNum,5);

        List<SmbmsProvider> smbmsProviders = smbmsMapper.showList3(map1);

        PageInfo<SmbmsProvider> providerPageInfo = new PageInfo<>(smbmsProviders);

        return providerPageInfo;

    }

    @Override
    public PageInfo<SmbmsProvider> showList4(Integer pageNum, HashMap<Object, Object> map1) {

        PageHelper.startPage(pageNum,5);

        List<SmbmsProvider> smbmsProviders = smbmsMapper.showList4(map1);

        PageInfo<SmbmsProvider> providerPageInfo = new PageInfo<>(smbmsProviders);

        return providerPageInfo;

    }

    @Override
    public SmbmsProvider selectProviderById(int id) {
        return smbmsMapper.selectProviderById(id);
    }

    @Override
    public boolean addProvider(SmbmsProvider smbmsProvider) {
        int i = smbmsMapper.addProvider(smbmsProvider);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int deleteProvider(int id) {
        return smbmsMapper.deleteProvider(id);
    }

    @Override
    public boolean updateProvider(SmbmsProvider smbmsProvider) {
        int i = smbmsMapper.updateProvider(smbmsProvider);

        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SmbmsUser selectUserById(int id) {
        return smbmsMapper.selectUserById(id);

    }

    @Override
    public boolean addUser(SmbmsUser smbmsUser) {
        int i = smbmsMapper.addUser(smbmsUser);

        if(1>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int deleteUser(int id) {

        return smbmsMapper.deleteUser(id);
    }

    @Override
    public boolean updateUser(SmbmsUser smbmsUser) {
        int i = smbmsMapper.updateUser(smbmsUser);

        if (1>0){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public boolean updatePassword(SmbmsUser smbmsUser) {
        int i = smbmsMapper.updatePassword(smbmsUser);

        if (1>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SmbmsBill selectBillById(int id) {
        return smbmsMapper.selectBillById(id);
    }
    @Override
    public boolean addBill(SmbmsBill smbmsBill) {
        int i = smbmsMapper.addBill(smbmsBill);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PageInfo<SmbmsBill> showList5(Integer pageNum, HashMap<Object, Object> map) {

//        设置分页内容
        PageHelper.startPage(pageNum,5);

        List<SmbmsBill> smbmsBills = smbmsMapper.showList5(map);

        PageInfo<SmbmsBill> billPageInfo = new PageInfo<>(smbmsBills);

        return billPageInfo;
    }

    @Override
    public int delectBill(int id) {

        return smbmsMapper.delectBill(id);
    }

    @Override
    public boolean updateBill(SmbmsBill smbmsBill) {
        int i= smbmsMapper.updateBill(smbmsBill);
        if(i>0){return true;
        }else{
            return false;
        }
    }

    @Override
    public PageInfo<SmbmsBill> selectBill1(Integer pageNum, HashMap<Object, Object> map) {
        PageHelper.startPage(pageNum,5);
        List<SmbmsBill> smbmsBills =smbmsMapper.selectBill1(map);
        PageInfo<SmbmsBill> userPageInfo =new PageInfo<>(smbmsBills);
        return userPageInfo;
    }


}
