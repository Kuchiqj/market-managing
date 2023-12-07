package com.qf.Controller;

import com.github.pagehelper.PageInfo;
import com.qf.pojo.SmbmsBill;
import com.qf.pojo.SmbmsProvider;
import com.qf.pojo.SmbmsUser;
import com.qf.service.SmbmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class SmbmsController {

    public static SmbmsUser Controller=null;

    @Autowired
    public SmbmsService smbmsService;

    @RequestMapping("/")//默认到login
    public String login(){
        return "login";
    }

    @RequestMapping("/login")
    public String loginSmbms(Model model,String userName, String userPassword){

        SmbmsUser loginUser = smbmsService.login(userName,userPassword);

        Controller = loginUser;

        System.out.println(loginUser);

        if (loginUser!=null){
            model.addAttribute("userName",userName);
                return"welcome";
            }else {
                return "login";
            }
        }




    @RequestMapping("/userList")
    public String UserList(Model model, @RequestParam(defaultValue = "1") Integer PageNum, String name){

        //创建新的map集合
        HashMap<Object, Object> map = new HashMap<>();

        //给map集合传入数据 传给mapper.xml

        map.put("name",name);

        model.addAttribute("name",name);
        //调用service中的方法
        PageInfo<SmbmsUser> smbmsUserPageInfo = smbmsService.showList(PageNum, map);

        //通过model传到前端
        model.addAttribute("PageInfo",smbmsUserPageInfo);

        System.out.println(smbmsUserPageInfo);

        return "userList";
    }
    @RequestMapping("/userList2")
    public String UserList2(Model model, @RequestParam(defaultValue = "1") Integer PageNum, String name){

        //创建新的map集合
        HashMap<Object, Object> map = new HashMap<>();

        //给map集合传入数据 传给mapper.xml

        map.put("name",name);

        model.addAttribute("name",name);
        //调用service中的方法
        PageInfo<SmbmsUser> smbmsUserPageInfo = smbmsService.showList2(PageNum,map);

        //通过model传到前端
        model.addAttribute("PageInfo",smbmsUserPageInfo);

        System.out.println(smbmsUserPageInfo);

        return "userList2";
    }


    @RequestMapping("/userView")
    public String SelectUserById(Model model,int id){
        SmbmsUser i = smbmsService.selectUserById(id);

        if(i==null){
                    System.out.println("查询失败");

                    return "";
                }else{
                    model.addAttribute("user",i);

                    return "userView";
                }
    }

    @RequestMapping("/userAdd")
    public String addUser(){
        return "userAdd";
    }

    @RequestMapping("/add")
    public String Add(Model model, String userName, String userPassword, int gender, String birthday,String phone,String address,int userRole) throws ParseException {
        SmbmsUser User = new SmbmsUser();
        User.setUserName(userName);
        User.setUserPassword(userPassword);
        User.setGender(gender);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse(birthday);
        User.setBirthday(parse);

        User.setPhone(phone);
        User.setAddress(address);
        User.setUserRole(userRole);


        boolean b = smbmsService.addUser(User);

        if(b){
                    System.out.println("添加成功");

                    return "redirect:/userList";
                }else {
            System.out.println("添加失败");
            return "";
        }
    }

    @RequestMapping("/deleteUser")
    public  String deleteUser(int id){

        int i = smbmsService.deleteUser(id);
        if (i>0){
            System.out.println("删除成功");
            return "redirect:/userList";
        }else {
            System.out.println("删除失败");
            return "";
        }
    }

    @RequestMapping("/userUpdate")
    public String updateUser(String id,Model model){

        model.addAttribute("id",id);

        return "userUpdate";
    }

    @RequestMapping("/update")
    public String userUpdate(Model model,int id,String userName,int gender,String birthday,String phone,String address,int userRole) throws ParseException {

        SmbmsUser user = new SmbmsUser();
        user.setId(id);
        user.setUserName(userName);
        user.setGender(gender);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse(birthday);
        user.setBirthday(parse);

        user.setPhone(phone);
        user.setAddress(address);
        user.setUserRole(userRole);

        boolean b = smbmsService.updateUser(user);
        if (b){
            System.out.println("修改成功");
            return "redirect:/userList";
        }else {
            return "";
        }
    }

    @RequestMapping("/updateP")
    public String Password(){
        return "/updateP";
    }

    @RequestMapping("/updateS")
            public String Password(String oldpassword,String newpassword,String renewpassword){

                SmbmsUser user = Controller;

                System.out.println(Controller.getUserName());

                if (oldpassword.equals(user.getUserPassword())){

                    if (newpassword.equals(renewpassword)){
                        user.setUserPassword(newpassword);
                        System.out.println("修改成功");
                        smbmsService.updatePassword(user);
                        System.out.println(user);
                        return "redirect:/userList";
                    }else{
                        System.out.println("检测到与新密码不一致");

                        return "redirect:/updateP";
                    }
    }else {
        System.out.println("检测到与原密码不一致");

        return "redirect:/updateP";
    }
    }

    @RequestMapping("/providerAdd")
    public String providerAdd(){
        return "providerAdd";
    }

    @RequestMapping("/providerList")
    public String ProviderList(Model model, @RequestParam(defaultValue = "1")Integer PageNum, String name1){
        HashMap<Object,Object> map1=new HashMap<>();

        System.out.println("name1 " + name1);
//        给map集合传入数据 传给mapper.xml
        map1.put("name1",name1);
        model.addAttribute("name1",name1);
//        调用service中的方法
        PageInfo<SmbmsProvider> smbmsProviderPageInfo = smbmsService.showList3(PageNum,map1);


        // show page info
        for (SmbmsProvider p :
                smbmsProviderPageInfo.getList()) {
            System.out.println(p);
        }

//        通过model传到前端
        model.addAttribute("PageInfo1",smbmsProviderPageInfo);

        return "providerList";

    }
    @RequestMapping("/providerList4")
    public String ProviderList4(Model model,
                                @RequestParam(defaultValue = "1")Integer PageNum,
                                String name1){
        HashMap<Object,Object> map1=new HashMap<>();

        System.out.println("name1 " + name1);
//        给map集合传入数据 传给mapper.xml
        map1.put("name1",name1);
        model.addAttribute("name1",name1);
//        调用service中的方法
        PageInfo<SmbmsProvider> smbmsProviderPageInfo = smbmsService.showList4(PageNum,map1);

//        通过model传到前端
        model.addAttribute("PageInfo1",smbmsProviderPageInfo);

        return "providerList4";

    }
    @RequestMapping("/addpro")
    public String Addpro(Model model,String proCode,String proName,String proContact,String proPhone,String proAddress,String proFax,String creationDate) throws ParseException {

        SmbmsProvider Provider = new SmbmsProvider();

        Provider.setProCode(proCode);
        Provider.setProName(proName);
        Provider.setProContact(proContact);
        Provider.setProPhone(proPhone);
        Provider.setProAddress(proAddress);
        Provider.setProFax(proFax);



        boolean b = smbmsService.addProvider(Provider);

        if(b){
            System.out.println("添加成功");
            return "redirect:/providerList";
        }else{
            System.out.println("添加失败");
            return "";
        }
    }

    @RequestMapping("/deleteProvider")
    public String deleteProvider(int id){
        int i = smbmsService.deleteProvider(id);
        if(i>0){
            System.out.println("删除成功");
            return "redirect:/providerList";
        }else{
            System.out.println("删除失败");
            return "";
        }
    }

    @RequestMapping("/providerView")
    public String SelectProviderById(Model model,int id){
        SmbmsProvider i = smbmsService.selectProviderById(id);

        if(i==null){
            System.out.println("查询失败");

            return "";
        }else{
            model.addAttribute("provider",i);
            return "providerView";
        }
    }

    @RequestMapping("/providerUpdate")
    public String updateProvider(String id,Model model){

        model.addAttribute("id",id);

        return "providerUpdate";
    }

    @RequestMapping("/update2")
    public String providerUpdate(Model model,int id,String proCode,String proName,String proContact,String proPhone,String proAddress,String proFax){

        SmbmsProvider provider = new SmbmsProvider();
        provider.setId(id);
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProAddress(proAddress);
        provider.setProFax(proFax);

        boolean b = smbmsService.updateProvider(provider);
        if (b){
            System.out.println("修改成功");
            return "redirect:/providerList";
        }else {
            return "";
        }
    }

    @RequestMapping("/billList")
    public String BillList(Model model, @RequestParam(defaultValue = "1")Integer PageNum, String name){

        HashMap<Object,Object>map2=new HashMap<>();

//        给map集合传入数据 传给mapper.xml
        map2.put("name",name);
        model.addAttribute("name",name);
//        调用service中的方法
        PageInfo<SmbmsBill> smbmsBillPageInfo = smbmsService.showList5(PageNum,map2);

//        通过model传到前端
        model.addAttribute("PageInfo",smbmsBillPageInfo);

        System.out.println(smbmsBillPageInfo);

        return "billList";

    }
    @RequestMapping("/billView")
    public String SelectBillById(Model model,int id){
        SmbmsBill i = smbmsService.selectBillById(id);
        if(i==null){
            System.out.println("查询失败");
            return "";
        }else{
            model.addAttribute("bill",i);
            return "billView";
        }
    }

    @RequestMapping("/billList2")
    public String BillList2(Model model,@RequestParam(defaultValue = "1") Integer PageNum,String productName,Integer provideId,Integer isPayment){
        HashMap<Object,Object> map = new HashMap<>();

        map.put("name",productName);
        map.put("providerId",provideId);
        map.put("isPayment",isPayment);

        PageInfo<SmbmsBill> smbmsBillPageInfo = smbmsService.selectBill1(PageNum, map);
        model.addAttribute("PageInfo",smbmsBillPageInfo);

        return "billList2";
    }
    @RequestMapping("/billAdd")
    public String BillAdd(){
        return "billAdd";
    }
    @RequestMapping("/add1")
    public String Add(Model model, String billCode, String productName, String productUnit, BigDecimal productCount, BigDecimal totalPrice, Integer isPayment, Integer providerId) throws ParseException {
        SmbmsBill Bill=new SmbmsBill();
        Bill.setBillCode(billCode);
        Bill.setProductName(productName);
        Bill.setProductUnit(productUnit);
        Bill.setProductCount(productCount);
        Bill.setTotalPrice(totalPrice);
        Bill.setIsPayment(isPayment);
        Bill.setProviderId(providerId);



        boolean b = smbmsService.addBill(Bill);


        if(b){
            System.out.println("添加成功");
            return "redirect:/billList";
        }else{
            System.out.println("添加失败");
            return "";
        }
    }

    @RequestMapping("delectBill")
    public  String delectBill(Model model,int id){

        int i = smbmsService.delectBill(id);

        if(i>0){
            System.out.println("删除成功");
            return "redirect:/billList";
        }else{
            System.out.println("删除失败");
            return "";
        }
    }
    @RequestMapping("/billUpdate")
    public String updateBill(Integer providerId,Model model){
        model.addAttribute("providerId",providerId);
        return "billUpdate";
    }

    @RequestMapping("/updateB")
    public String billUpdate(Model model,String billCode,String productName,String productUnit, BigDecimal productCount, BigDecimal totalPrice, Integer isPayment, Integer providerId){
        SmbmsBill bill=new SmbmsBill();
        bill.setBillCode(billCode);
        bill.setProductName(productName);
        bill.setProductUnit(productUnit);
        bill.setProductCount(productCount);
        bill.setTotalPrice(totalPrice);
        bill.setIsPayment(isPayment);
        bill.setProviderId(providerId);

        System.out.println(bill);
        boolean b=smbmsService.updateBill(bill);

        System.out.println(bill);
        if (b){
            System.out.println("修改成功");
            return "redirect:/billList";
        }else{

            return "redirect:/billList";
        }
    }


}
